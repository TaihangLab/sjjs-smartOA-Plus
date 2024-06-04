package com.ruoyi.ip.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.IntellectualPropertyTypeEnum;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.ip.domain.IntellectualProperty;
import com.ruoyi.ip.domain.IpUser;
import com.ruoyi.ip.domain.bo.IntellectualPropertyBO;
import com.ruoyi.ip.domain.vo.IntellectualPropertyDetailVO;
import com.ruoyi.ip.domain.vo.IntellectualPropertyVO;
import com.ruoyi.ip.mapper.IntellectualPropertyMapper;
import com.ruoyi.ip.service.IntellectualPropertyService;
import com.ruoyi.ip.service.IpOssService;
import com.ruoyi.ip.service.IpUserService;
import com.ruoyi.project.domain.ProjectBaseInfo;
import com.ruoyi.project.service.ProjectBaseInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static com.ruoyi.ip.constant.IpConstants.*;

/**
 * 知识产权
 *
 * @author bailingnan
 * @date 2024/1/2
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class IntellectualPropertyServiceImpl implements IntellectualPropertyService {
    private final IntellectualPropertyMapper intellectualPropertyMapper;
    private final IpOssService ipOssService;
    private final IpUserService ipUserService;
    private final ProjectBaseInfoService projectBaseInfoService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertIntellectualProperty(IntellectualPropertyBO intellectualPropertyBO) {
        if (intellectualPropertyBO == null) {
            throw new IllegalArgumentException("intellectualPropertyBO can not be null");
        }
        IntellectualProperty intellectualProperty = new IntellectualProperty();
        BeanCopyUtils.copy(intellectualPropertyBO, intellectualProperty);
        int cnt = intellectualPropertyMapper.insert(intellectualProperty);
        if (cnt != 1) {
            log.error("新增知识产权失败 intellectualPropertyBO:{}", intellectualPropertyBO);
            throw new RuntimeException("新增知识产权失败");
        }
        Long ipId = intellectualProperty.getIpId();
        if (ipId == null) {
            throw new IllegalStateException("获取知识产权Id失败");
        }
	    ipOssService.insertIpOssList(ipId, intellectualPropertyBO.getOssIdList());
	    ipUserService.insertIpUserList(ipId, intellectualPropertyBO.getUserIdList());
    }

    /**
     * @param ipId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteIntellectualProperty(Long ipId) {
        int cnt = intellectualPropertyMapper.deleteById(ipId);
        if (cnt != 1) {
            log.error("删除知识产权失败 ipId:{}", ipId);
            throw new NoSuchElementException("删除知识产权失败,ipId为:" + ipId);
        }
	    ipUserService.deleteIpUserByIpId(ipId);
	    ipOssService.deleteIpOssByIpId(ipId);
    }

    /**
     * @param intellectualPropertyBO
     */
    @Override
    public void updateIntellectualProperty(IntellectualPropertyBO intellectualPropertyBO) {
        if (intellectualPropertyBO == null) {
            throw new IllegalArgumentException("intellectualPropertyBO can not be null");
        }
        IntellectualProperty intellectualProperty = new IntellectualProperty();
        BeanCopyUtils.copy(intellectualPropertyBO, intellectualProperty);
        int cnt = intellectualPropertyMapper.updateById(intellectualProperty);
        if (cnt != 1) {
            log.info("cnt:{}", cnt);
            log.error("更新知识产权失败 intellectualPropertyBO:{}", intellectualPropertyBO);
            throw new RuntimeException("更新知识产权失败");
        }
        Long ipId = intellectualProperty.getIpId();
	    ipUserService.updateIpUserByIpId(ipId, intellectualPropertyBO.getUserIdList());
	    ipOssService.updateIpOssByIpId(ipId, intellectualPropertyBO.getOssIdList());
    }

    /**
     * @param ipId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public IntellectualPropertyDetailVO getIntellectualPropertyDetail(Long ipId) {
        IntellectualPropertyDetailVO intellectualPropertyDetailVO = new IntellectualPropertyDetailVO();
        IntellectualProperty intellectualProperty = intellectualPropertyMapper.selectById(ipId);
        if (intellectualProperty == null) {
            throw new NoSuchElementException("ipId为:" + ipId + "的知识产权不存在");
        }
        BeanCopyUtils.copy(intellectualProperty, intellectualPropertyDetailVO);
        if (UNASSOCIATED_PROJECT_CODE.equals(intellectualProperty.getProjectId())) {
            intellectualPropertyDetailVO.setAssignedSubjectName(UNASSOCIATED_PROJECT_IDENTIFIER);
        } else {
            intellectualPropertyDetailVO.setAssignedSubjectName(Optional.ofNullable(projectBaseInfoService.selectProjectBaseInfoById(intellectualPropertyDetailVO.getProjectId())).map(ProjectBaseInfo::getAssignedSubjectName).orElse(PROJECT_DELETED_REASSOCIATE));
        }
        intellectualPropertyDetailVO.setProjectPath(projectBaseInfoService.getProjectPathById(intellectualProperty.getProjectId()));
        intellectualPropertyDetailVO.setSysOssVoList(ipOssService.getSysOssVoListByIpId(ipId));
        intellectualPropertyDetailVO.setIpUserVOList(ipUserService.getIpUserVOListByIpId(ipId));
        intellectualPropertyDetailVO.setUserPathList(ipUserService.getUserPathListByIpId(ipId));
        return intellectualPropertyDetailVO;
    }

    /**
     * @param intellectualPropertyBO
     * @param pageQuery
     * @return
     */
    @Override
    public TableDataInfo<IntellectualPropertyVO> queryIntellectualPropertVOList(IntellectualPropertyBO intellectualPropertyBO, PageQuery pageQuery) {
        LambdaQueryWrapper<IntellectualProperty> lqw = buildIntellectualPropertyQueryWrapper(intellectualPropertyBO);
        Page<IntellectualPropertyVO> result = intellectualPropertyMapper.selectVoPage(pageQuery.build(), lqw);
        List<IntellectualPropertyVO> records = result.getRecords();

        if (!records.isEmpty()) {
	        setAssignedSubjectName(records);
        }

        return TableDataInfo.build(result);
    }

    @Override
    public Map<String, Integer> getIpTypeStatistics() {
        // 使用所有IP类型和零计数初始化映射。
        Map<String, Integer> ipTypeStatistics = Arrays.stream(IntellectualPropertyTypeEnum.values())
            .collect(Collectors.toMap(IntellectualPropertyTypeEnum::getDescription, ipType -> 0));

        // 流处理知识产权并更新计数。
	    intellectualPropertyMapper.selectList(Wrappers.lambdaQuery())
            .stream()
            .filter(ip -> ip.getIpType() != null)
            .map(ip -> ip.getIpType().getDescription())
            .forEach(ipType -> ipTypeStatistics.merge(ipType, 1, Integer::sum));

        return ipTypeStatistics;
    }

    @Override
    public void deleteIntellectualPropertyByMilestoneId(Long milestoneId) {
        if (milestoneId == null) {
            return;
        }
        intellectualPropertyMapper.delete(
            new LambdaQueryWrapper<IntellectualProperty>().eq(IntellectualProperty::getMilestoneId, milestoneId));
    }

    @Override
    public void deleteIntellectualPropertyByMilstoneIdList(List<Long> milstoneIdList) {
        if (milstoneIdList == null || milstoneIdList.isEmpty()) {
            return;
        }
        intellectualPropertyMapper.delete(
            new LambdaQueryWrapper<IntellectualProperty>().in(IntellectualProperty::getMilestoneId, milstoneIdList));
    }

    @Override
    public void deleteIntellectualPropertyByProjectId(Long projectId) {
        if (projectId == null) {
            return;
        }
        intellectualPropertyMapper.delete(
            new LambdaQueryWrapper<IntellectualProperty>().eq(IntellectualProperty::getProjectId, projectId));
    }

    private LambdaQueryWrapper<IntellectualProperty> buildIntellectualPropertyQueryWrapper(IntellectualPropertyBO intellectualPropertyBO) {
        LambdaQueryWrapper<IntellectualProperty> lqw = new LambdaQueryWrapper<>();
        if (intellectualPropertyBO == null) {
            return lqw.orderByDesc(IntellectualProperty::getUpdateTime);
        }

        if (intellectualPropertyBO.getUserId() != null) {
            List<Long> ipIdList = getIpIdListFromUserId(intellectualPropertyBO.getUserId());
            if (ipIdList.isEmpty()) {
                lqw.apply("0=1");
                return lqw;
            }
            lqw.in(IntellectualProperty::getIpId, ipIdList);
        }

        lqw.eq(intellectualPropertyBO.getProjectId() != null, IntellectualProperty::getProjectId, intellectualPropertyBO.getProjectId())
            .eq(intellectualPropertyBO.getIpType() != null, IntellectualProperty::getIpType, intellectualPropertyBO.getIpType())
            .eq(intellectualPropertyBO.getIpStatus() != null, IntellectualProperty::getIpStatus, intellectualPropertyBO.getIpStatus())
            .like(StringUtils.isNotBlank(intellectualPropertyBO.getIpName()), IntellectualProperty::getIpName, intellectualPropertyBO.getIpName())
            .ge(intellectualPropertyBO.getIpDateSta() != null, IntellectualProperty::getIpDate, intellectualPropertyBO.getIpDateSta())
            .le(intellectualPropertyBO.getIpDateEnd() != null, IntellectualProperty::getIpDate, intellectualPropertyBO.getIpDateEnd())
            .orderByDesc(IntellectualProperty::getUpdateTime);

        return lqw;
    }

    private void setAssignedSubjectName(List<IntellectualPropertyVO> recordList) {
        Set<Long> projectSet = recordList.stream().map(IntellectualPropertyVO::getProjectId).collect(Collectors.toSet());
        Map<Long, String> projectIdAndNameMapping = projectBaseInfoService.getProjectIdAndNameMappingByProjectIdSet(projectSet);

        recordList.forEach(intellectualPropertyVO ->
            intellectualPropertyVO.setAssignedSubjectName(
                projectIdAndNameMapping.getOrDefault(intellectualPropertyVO.getProjectId(), PROJECT_DELETED_REASSOCIATE)
            )
        );
    }

    /**
     * @param userId
     *
     * @return {@link List}<{@link Long}>
     */
    private List<Long> getIpIdListFromUserId(Long userId) {
        return Optional.ofNullable(userId)
            .map(ipUserService::getIpUserListByUserId)
            .orElseGet(Collections::emptyList)
            .stream()
            .map(IpUser::getIpId)
            .collect(Collectors.toList());
    }
}
