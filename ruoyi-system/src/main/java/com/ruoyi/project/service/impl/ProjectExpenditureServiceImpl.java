package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.config.GlobalMappingConfig;
import com.ruoyi.project.domain.ProjectBalancePaid;
import com.ruoyi.project.domain.ProjectBalanceUnpaid;
import com.ruoyi.project.domain.ProjectExpenditure;
import com.ruoyi.project.domain.bo.ProjectExpenditureBO;
import com.ruoyi.project.domain.vo.ProjectExpenditureVO;
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
        List<ProjectBalancePaid> projectBalancePaidListToInsert = new ArrayList<>();
        List<ProjectBalanceUnpaid> projectBalanceUnpaidListToInsert = new ArrayList<>();
        //对每一条记录进行判断，判断是否超出预算，更新关联的一二级科目，插入支出明细
        projectExpenditureBOList.forEach(projectExpenditureBO -> {
            try {
                processProjectExpenditureBO(projectExpenditureBO, projectExpenditureListToInsert,
                    projectBalancePaidListToInsert, projectBalanceUnpaidListToInsert);
            } catch (Exception e) {
                log.info("编号为{},导入支出明细失败: {}", projectExpenditureBO.getVoucherNo(), e.getMessage());
                errorMessages.add(e.getMessage());
            }
        });
        // 执行批量插入操作
        performBatchInsertAndUpdate(projectExpenditureListToInsert, projectBalancePaidListToInsert,
            projectBalanceUnpaidListToInsert, errorMessages);
    }

    private void processProjectExpenditureBO(ProjectExpenditureBO projectExpenditureBO,
        List<ProjectExpenditure> projectExpenditureListToInsert,
        List<ProjectBalancePaid> projectBalancePaidListToInsert,
        List<ProjectBalanceUnpaid> projectBalanceUnpaidListToInsert)
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
        //获取经费数额，并转化为万元
        BigDecimal expenditure = projectExpenditureBO.getAmount().divide(new BigDecimal("10000"));
        //获取余额
        ProjectBalancePaid projectBalancePaid =
            projectBalanceService.getProjectBalancePaidByProjectId(projectExpenditureBO.getProjectId());
        ProjectBalanceUnpaid projectBalanceUnpaid =
            projectBalanceService.getProjectBalanceUnpaidByProjectId(projectExpenditureBO.getProjectId());
        if (projectBalancePaid == null || projectBalanceUnpaid == null) {
            log.error("项目余额不存在");
            throw new ServiceException("项目余额不存在,凭证号为:" + projectExpenditureBO.getVoucherNo());
        }
        //获取未支付余额
        String unpaidField = unpaidReverseMapping.get(field);
        BigDecimal unpaid = (BigDecimal)FieldUtils.readField(projectBalanceUnpaid, unpaidField, true);
        if (expenditure.compareTo(unpaid) > 0) {
            log.error("支付经费超出余额");
            throw new ServiceException("支付经费超出余额,凭证号为:" + projectExpenditureBO.getVoucherNo());
        }
        //扣减未支付余额
        FieldUtils.writeField(projectBalanceUnpaid, unpaidField, unpaid.subtract(expenditure), true);
        String paidField = paidReverseMapping.get(field);
        //添加已支付金额
        BigDecimal paid = (BigDecimal)FieldUtils.readField(projectBalancePaid, paidField, true);
        FieldUtils.writeField(projectBalancePaid, paidField, paid.add(expenditure), true);
        //TODO:更新关联的一二级科目
        //        String firstLevelSubject = fundsMapping.get(projectExpenditureBO.getFunds());
        //        String secondLevelSubject = fundsReverseMapping.get(projectExpenditureBO.getFunds());
        //        projectExpenditureBO.setFirstLevelSubject(firstLevelSubject);
        //        projectExpenditureBO.setSecondLevelSubject(secondLevelSubject);
        //插入支出明细
        projectExpenditureListToInsert.add(BeanCopyUtils.copy(projectExpenditureBO, ProjectExpenditure.class));
        projectBalancePaidListToInsert.add(projectBalancePaid);
        projectBalanceUnpaidListToInsert.add(projectBalanceUnpaid);
    }

    private void performBatchInsertAndUpdate(List<ProjectExpenditure> projectExpenditures,
        List<ProjectBalancePaid> projectBalancePaidList, List<ProjectBalanceUnpaid> projectBalanceUnpaidList,
        List<String> errorMessageList) {
        if (!errorMessageList.isEmpty()) {
            throw new RuntimeException("导入失败: " + String.join("; ", errorMessageList));
        }
        if (!projectExpenditures.isEmpty()) {
            projectExpenditureMapper.insertBatch(projectExpenditures);
        }
        if (!projectBalancePaidList.isEmpty() && !projectBalanceUnpaidList.isEmpty()) {
            projectBalanceService.batchUpdateProjectBalancePaid(projectBalancePaidList);
            projectBalanceService.batchUpdateProjectBalanceUnpaid(projectBalanceUnpaidList);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void rollBackProjectExpenditureById(Long expenditureId) throws IllegalAccessException {
        ProjectExpenditure projectExpenditure = projectExpenditureMapper.selectById(expenditureId);
        if (projectExpenditure == null) {
            log.error("支出明细不存在");
            throw new ServiceException("支出明细不存在");
        }
        //回滚支出记录
        projectExpenditureMapper.deleteById(expenditureId);
        //回滚经费余额
        rollBackProjectBalance(projectExpenditure);
    }

    private void rollBackProjectBalance(ProjectExpenditure projectExpenditure) throws IllegalAccessException {
        //获取余额
        ProjectBalancePaid projectBalancePaid =
            projectBalanceService.getProjectBalancePaidByProjectId(projectExpenditure.getProjectId());
        ProjectBalanceUnpaid projectBalanceUnpaid =
            projectBalanceService.getProjectBalanceUnpaidByProjectId(projectExpenditure.getProjectId());
        if (projectBalancePaid == null || projectBalanceUnpaid == null) {
            log.error("项目余额不存在");
            throw new ServiceException("项目余额不存在,凭证号为:" + projectExpenditure.getVoucherNo());
        }
        //获取经费字段
        String field = GlobalMappingConfig.getObjectByTags(projectExpenditure.getZxzc(), projectExpenditure.getZjjj(),
            projectExpenditure.getFirstLevelSubject(), projectExpenditure.getSecondLevelSubject(),
            projectExpenditure.getThirdLevelSubject());
        //判断录入经费的名称是否存在
        if (field == null) {
            log.error("支出记录的支付经费类型不存在");
            throw new ServiceException("支付经费类型不存在,凭证号为:" + projectExpenditure.getVoucherNo());
        }
        //获取经费数额,并转化为万元
        BigDecimal expenditure = projectExpenditure.getAmount().divide(new BigDecimal("10000"));
        //获取已支付余额
        String paidField = paidReverseMapping.get(field);
        BigDecimal paid = (BigDecimal)FieldUtils.readField(projectBalancePaid, paidField, true);
        if (expenditure.compareTo(paid) > 0) {
            log.error("回滚支付经费超出已支付余额");
            throw new ServiceException("回滚支付经费超出已支付余额,凭证号为:" + projectExpenditure.getVoucherNo());
        }
        //回滚已支付余额
        FieldUtils.writeField(projectBalancePaid, paidField, paid.subtract(expenditure), true);
        String unpaidField = unpaidReverseMapping.get(field);
        //回滚未支付金额
        BigDecimal unpaid = (BigDecimal)FieldUtils.readField(projectBalanceUnpaid, unpaidField, true);
        FieldUtils.writeField(projectBalanceUnpaid, unpaidField, unpaid.add(expenditure), true);
        //TODO:更新关联的一二级科目
        //        String firstLevelSubject = fundsMapping.get(projectExpenditureBO.getFunds());
        //        String secondLevelSubject = fundsReverseMapping.get(projectExpenditureBO.getFunds());
        //        projectExpenditureBO.setFirstLevelSubject(firstLevelSubject);
        //        projectExpenditureBO.setSecondLevelSubject(secondLevelSubject);
        projectBalanceService.updateProjectBalancePaid(projectBalancePaid);
        projectBalanceService.updateProjectBanlanceUnpaid(projectBalanceUnpaid);
    }

    /**
     * 查询项目支出明细
     * @param projectId
     * @return
     */
    public List<ProjectExpenditureVO> getProjectExpenditureByProId(Long projectId) {
        return projectExpenditureMapper.selectVoList(new LambdaQueryWrapper<ProjectExpenditure>()
            .eq(ProjectExpenditure::getProjectId,projectId));
    }
}
