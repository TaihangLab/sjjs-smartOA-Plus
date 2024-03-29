package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.config.GlobalMappingConfig;
import com.ruoyi.project.domain.ProjectBalance;
import com.ruoyi.project.domain.ProjectExpenditure;
import com.ruoyi.project.domain.bo.ProjectExpenditureBO;
import com.ruoyi.project.mapper.ProjectExpenditureMapper;
import com.ruoyi.project.service.ProjectBalanceService;
import com.ruoyi.project.service.ProjectExpenditureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/**
 * 项目支出Service
 *
 * @author bailingnan
 * @date 2024/03/01
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectExpenditureServiceImpl implements ProjectExpenditureService{
    private final ProjectExpenditureMapper projectExpenditureMapper;
    private final ProjectBalanceService projectBalanceService;
    private final ConcurrentMap<String, String> fundsMapping;
    private final ConcurrentMap<String, String> fundsReverseMapping;
    private final ConcurrentMap<String, String> paidMapping;
    private final ConcurrentMap<String, String> paidReverseMapping;
    private final ConcurrentMap<String, String> unpaidMapping;
    private final ConcurrentMap<String, String> unpaidReverseMapping;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addProjectExpenditureList(List<ProjectExpenditureBO> projectExpenditureBOList) {
        if (projectExpenditureBOList == null || projectExpenditureBOList.isEmpty()) {
            return;
        }
        //出错信息记录
        List<String> errorMessages = new ArrayList<>();
        //缓存可插入的记录
        List<ProjectExpenditure> projectExpenditureListToInsert = new ArrayList<>();
        List<ProjectBalance> projectBalanceListToInsert = new ArrayList<>();
        //对每一条记录进行判断，判断是否超出预算，更新关联的一二级科目，插入支出明细
        projectExpenditureBOList.forEach(projectExpenditureBO -> {
            try {
                processProjectExpenditureBO(projectExpenditureBO, projectExpenditureListToInsert,
                    projectBalanceListToInsert);
            } catch (Exception e) {
                errorMessages.add(e.getMessage());
            }
        });
        // 执行批量插入操作
        performBatchInsertAndUpdate(projectExpenditureListToInsert, projectBalanceListToInsert, errorMessages);
    }

    private void processProjectExpenditureBO(ProjectExpenditureBO projectExpenditureBO,
        List<ProjectExpenditure> projectExpenditureListToInsert, List<ProjectBalance> projectBalanceListToInsert)
        throws ServiceException, IllegalAccessException {
        //获取经费字段
        String field =
            GlobalMappingConfig.getObjectByTags(projectExpenditureBO.getZxzc(), projectExpenditureBO.getZjjj(),
                projectExpenditureBO.getFirstLevelSubject(), projectExpenditureBO.getSecondLevelSubject(),
                projectExpenditureBO.getThirdLevelSubject());
        //判断录入经费的名称是否存在
        if (field == null) {
            log.error("录入的支付经费类型不存在");
            throw new ServiceException("支付经费类型不存在,凭证号为:" + projectExpenditureBO.getVoucherNo());
        }
        //获取经费数额
        BigDecimal expenditure = projectExpenditureBO.getAmount();
        //获取余额
        ProjectBalance projectBalance =
            projectBalanceService.getProjectBalanceByProjectId(projectExpenditureBO.getProjectId());
        if (projectBalance == null) {
            log.error("项目余额不存在");
            throw new ServiceException("项目余额不存在,凭证号为:" + projectExpenditureBO.getVoucherNo());
        }
        //获取未支付余额
        String unpaidField = unpaidReverseMapping.get(field);
        BigDecimal unpaid = (BigDecimal)FieldUtils.readField(projectBalance, unpaidField, true);
        if (expenditure.compareTo(unpaid) > 0) {
            log.error("支付经费超出余额");
            throw new ServiceException("支付经费超出余额,凭证号为:" + projectExpenditureBO.getVoucherNo());
        }
        //扣减未支付余额
        FieldUtils.writeField(projectBalance, unpaidField, unpaid.subtract(expenditure), true);
        String paidField = paidReverseMapping.get(field);
        //添加已支付金额
        BigDecimal paid = (BigDecimal)FieldUtils.readField(projectBalance, paidField, true);
        FieldUtils.writeField(projectBalance, paidField, paid.add(expenditure), true);
        //TODO:更新关联的一二级科目
        //        String firstLevelSubject = fundsMapping.get(projectExpenditureBO.getFunds());
        //        String secondLevelSubject = fundsReverseMapping.get(projectExpenditureBO.getFunds());
        //        projectExpenditureBO.setFirstLevelSubject(firstLevelSubject);
        //        projectExpenditureBO.setSecondLevelSubject(secondLevelSubject);
        //插入支出明细
        projectExpenditureListToInsert.add(BeanCopyUtils.copy(projectExpenditureBO, ProjectExpenditure.class));
        projectBalanceListToInsert.add(projectBalance);
    }

    private void performBatchInsertAndUpdate(List<ProjectExpenditure> projectExpenditures,
        List<ProjectBalance> projectBalanceList, List<String> errorMessageList) {
        if (!errorMessageList.isEmpty()) {
            throw new RuntimeException("导入失败: " + String.join("; ", errorMessageList));
        }
        if (!projectExpenditures.isEmpty()) {
            projectExpenditureMapper.insertBatch(projectExpenditures);
        }
        if (!projectBalanceList.isEmpty()) {
            projectBalanceService.batchUpdateProjectBalance(projectBalanceList);
        }
    }

    @Override
    public void deleteProjectExpenditureByProjectId(Long projectId) {
        //TODO
    }

    /**
     * 查询项目支出明细
     * @param projectId
     * @return
     */
    public List<ProjectExpenditure> getProjectExpenditureByProId(Long projectId){
        return projectExpenditureMapper.selectList(new LambdaQueryWrapper<ProjectExpenditure>()
            .eq(ProjectExpenditure::getProjectId,projectId));
    }
}
