package com.ruoyi.project.service.impl;

import cn.hutool.core.lang.Opt;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ProjectMilestoneTypeEnum;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.domain.*;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import com.ruoyi.project.domain.vo.ProjectMilestoneVo;
import com.ruoyi.project.mapper.*;
import com.ruoyi.project.service.ProjectMilestoneService;
import com.ruoyi.system.domain.SysOss;
import com.ruoyi.system.domain.vo.SysOssVo;
import com.ruoyi.system.mapper.SysOssMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 项目大事记
 *
 * @author bailingnan
 * @date 2024/02/06
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ProjectMilestoneServiceImpl implements ProjectMilestoneService {

    private final ProjectMilestoneMapper projectMilestoneMapper;

    private final ProjectMilestoneOssMapper projectMilestoneOssMapper;

    private final SysOssMapper sysOssMapper;

    private final ProjectMilestoneTypeMapper projectMilestoneTypeMapper;


    /**
     * 新增单个项目大事记
     *
     * @param projectMilestoneBo 项目指标信息Bo
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertProjectMilestone(ProjectMilestoneBo projectMilestoneBo) {

        if (projectMilestoneBo == null) {
            throw new IllegalArgumentException("projectMilestoneBo cannot be null");
        }
        ProjectMilestone projectMilestone = new ProjectMilestone();

        BeanCopyUtils.copy(projectMilestoneBo, projectMilestone);

        // 插入 projectMilestone
        int insertedRows = projectMilestoneMapper.insert(projectMilestone);

        if (insertedRows > 0) {
            Long milestoneId = projectMilestone.getMilestoneId(); // 获取生成的 milestoneId
            if (projectMilestoneBo.getProjectMilestoneTypes() != null && !projectMilestoneBo.getProjectMilestoneTypes().isEmpty()) {
                List<ProjectMilestoneTypeEnum> projectMilestoneTypes = projectMilestoneBo.getProjectMilestoneTypes();
                projectMilestoneTypes.forEach(projectMilestoneCategoryEnum -> {
                    ProjectMilestoneType projectMilestoneType = new ProjectMilestoneType();
                    projectMilestoneType.setMilestoneType(projectMilestoneCategoryEnum);
                    projectMilestoneType.setMilestoneId(milestoneId);
                    log.info("projectMilestoneType:{}", projectMilestoneType);
                    projectMilestoneTypeMapper.insert(projectMilestoneType);
                });
            }
            projectMilestoneBo.setMilestoneId(milestoneId);//给BO对象赋值milestoneId，在经费到账时需要调用
            if (projectMilestoneBo.getOssIds() != null && !projectMilestoneBo.getOssIds().isEmpty()) {
                for (Long ossId : projectMilestoneBo.getOssIds()) {
                    ProjectMilestoneOss projectMilestoneOss = new ProjectMilestoneOss();
                    projectMilestoneOss.setMilestoneId(milestoneId);
                    projectMilestoneOss.setOssId(ossId);
                    projectMilestoneOssMapper.insert(projectMilestoneOss);
                }
            }
        }
        return insertedRows;
    }


    /**
     * 查询所有大事记分类
     */
    @Override
    public List<ProjectMilestoneTypeEnum> selectCategoryAll() {
        return Arrays.asList(ProjectMilestoneTypeEnum.values());
    }


    /**
     * 删除某一项目对应的全部项目大事记
     *
     * @param projectId 项目ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteMilestoneByProjectId(Long projectId) {
        // 1. 根据项目 ID 获取该项目下所有的大事记 ID
        List<ProjectMilestone> projectMilestones = projectMilestoneMapper.selectList(
            new LambdaQueryWrapper<ProjectMilestone>()
                .eq(ProjectMilestone::getProjectId, projectId));

        // 如果该项目下没有大事记，则直接返回
        if (projectMilestones.isEmpty()) {
            return 0;
        }

        // 提取大事记 ID 列表
        List<Long> milestoneIds = projectMilestones.stream()
            .map(ProjectMilestone::getMilestoneId)
            .collect(Collectors.toList());

        // 2. 使用大事记 ID 删除每个大事记对应的 OSS 对象
        if (!milestoneIds.isEmpty()) {
            projectMilestoneOssMapper.delete(new LambdaQueryWrapper<ProjectMilestoneOss>()
                .in(ProjectMilestoneOss::getMilestoneId, milestoneIds));
        }

        if (!milestoneIds.isEmpty()) {
            projectMilestoneTypeMapper.delete(new LambdaQueryWrapper<ProjectMilestoneType>()
                .in(ProjectMilestoneType::getMilestoneId, milestoneIds));
        }

        // 3. 删除该项目下的所有大事记
        return projectMilestoneMapper.delete(new LambdaQueryWrapper<ProjectMilestone>()
            .eq(ProjectMilestone::getProjectId, projectId));

    }

    /**
     * 删除单条目大事记
     *
     * @param milestoneId 项目大事记ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteProjectMilestone(Long milestoneId) {
        // 先检查是否存在与 milestoneId 相关的 ProjectMilestoneOss 记录
        long count1 = projectMilestoneOssMapper.selectCount(new LambdaQueryWrapper<ProjectMilestoneOss>()
            .eq(ProjectMilestoneOss::getMilestoneId, milestoneId));

        // 如果存在相关记录，则执行删除操作；否则直接返回
        if (count1 > 0) {
            projectMilestoneOssMapper.delete(new LambdaQueryWrapper<ProjectMilestoneOss>()
                .eq(ProjectMilestoneOss::getMilestoneId, milestoneId));
        }

        // 删除 ProjectMilestoneType 表中的指定 milestoneId 的记录
        Long count2 = projectMilestoneTypeMapper.selectCount(new LambdaQueryWrapper<ProjectMilestoneType>()
            .eq(ProjectMilestoneType::getMilestoneId, milestoneId));
        if (count2 > 0) {
            projectMilestoneTypeMapper.delete(new LambdaQueryWrapper<ProjectMilestoneType>()
                .eq(ProjectMilestoneType::getMilestoneId, milestoneId));
        }

        // 删除 ProjectMilestone 表中的指定 milestoneId 的记录
        return projectMilestoneMapper.delete(new LambdaQueryWrapper<ProjectMilestone>()
            .eq(ProjectMilestone::getMilestoneId, milestoneId));
    }

    /**
     * 修改项目大事记
     *
     * @param projectMilestoneBo 项目大事记信息Bo
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateMilestone(ProjectMilestoneBo projectMilestoneBo) {


        if (projectMilestoneBo == null) {
            throw new IllegalArgumentException("projectMilestoneBo cannot be null");
        }
        LambdaUpdateWrapper<ProjectMilestone> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(ProjectMilestone::getMilestoneId, projectMilestoneBo.getMilestoneId());
        lambdaUpdateWrapper.set(ProjectMilestone::getMilestoneRemark, projectMilestoneBo.getMilestoneRemark())
            .set(ProjectMilestone::getMilestoneTitle, projectMilestoneBo.getMilestoneTitle())
            .set(ProjectMilestone::getMilestoneDate, projectMilestoneBo.getMilestoneDate());

        int updatedRows = projectMilestoneMapper.update(new ProjectMilestone(), lambdaUpdateWrapper);
        if (updatedRows > 0) {

            // 删除旧的关联关系
            Long milestoneId = projectMilestoneBo.getMilestoneId();
            projectMilestoneOssMapper.delete(new LambdaQueryWrapper<ProjectMilestoneOss>()
                .eq(ProjectMilestoneOss::getMilestoneId, milestoneId));

            // 插入新的关联关系
            List<Long> ossIds = projectMilestoneBo.getOssIds();
            if (!ossIds.isEmpty()) {
                for (Long ossId : ossIds) {
                    ProjectMilestoneOss projectMilestoneOss = new ProjectMilestoneOss();
                    projectMilestoneOss.setMilestoneId(milestoneId);
                    projectMilestoneOss.setOssId(ossId);
                    projectMilestoneOssMapper.insert(projectMilestoneOss);
                }
            }

            //删除旧的分类关系
            projectMilestoneTypeMapper.delete(new LambdaQueryWrapper<ProjectMilestoneType>()
                .eq(ProjectMilestoneType::getMilestoneId, milestoneId));

            // 插入新的分类关系
            List<ProjectMilestoneTypeEnum> projectMilestoneCategoryEnumList = projectMilestoneBo.getProjectMilestoneTypes();
            if (projectMilestoneCategoryEnumList != null && !projectMilestoneCategoryEnumList.isEmpty()) {
                for (ProjectMilestoneTypeEnum projectMilestoneCategoryEnum : projectMilestoneCategoryEnumList) {
                    ProjectMilestoneType projectMilestoneType = new ProjectMilestoneType();
                    projectMilestoneType.setMilestoneId(milestoneId);
                    projectMilestoneType.setMilestoneType(projectMilestoneCategoryEnum);
                    projectMilestoneTypeMapper.insert(projectMilestoneType);
                }
            }

        }
        return updatedRows;
    }

    /**
     * 根据查询条件查询对应的大事纪
     *
     * @param projectMilestoneBo projectMilestoneBo
     * @return 项目大事记Vo列表List<ProjectMilestoneVo>
     */
    @Override
    public List<ProjectMilestoneVo> queryMilestoneList(ProjectMilestoneBo projectMilestoneBo) {

        List<Long> milestoneIds = new ArrayList<>();
        //根据分类去查对应的大事记
        if (projectMilestoneBo.getMilestoneType() != null) {
            milestoneIds = projectMilestoneTypeMapper.selectList(new LambdaQueryWrapper<ProjectMilestoneType>()
                    .eq(ProjectMilestoneType::getMilestoneType, projectMilestoneBo.getMilestoneType())
                    .select(ProjectMilestoneType::getMilestoneId))
                .stream()
                .map(ProjectMilestoneType::getMilestoneId)
                .collect(Collectors.toList());
        }

        LambdaQueryWrapper<ProjectMilestone> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper

            .eq(ProjectMilestone::getProjectId, projectMilestoneBo.getProjectId())
            //拼一个恒成立的条件，避免sql语句and后无条件导致报错
            .and(wrapper -> wrapper.apply("1=1")
                .like(StringUtils.isNotBlank(projectMilestoneBo.getKeyword()), ProjectMilestone::getMilestoneTitle, projectMilestoneBo.getKeyword())
                .or()
                .like(StringUtils.isNotBlank(projectMilestoneBo.getKeyword()), ProjectMilestone::getMilestoneRemark, projectMilestoneBo.getKeyword()))
            .ge(projectMilestoneBo.getMilestoneStaTime() != null, ProjectMilestone::getMilestoneDate, projectMilestoneBo.getMilestoneStaTime())
            .le(projectMilestoneBo.getMilestoneEndTime() != null, ProjectMilestone::getMilestoneDate, projectMilestoneBo.getMilestoneEndTime())
            .in(!milestoneIds.isEmpty(), ProjectMilestone::getMilestoneId, milestoneIds);

        List<ProjectMilestone> projectMilestones = projectMilestoneMapper.selectList(lambdaQueryWrapper);

        return buildMilestoneVos(projectMilestones);

    }


    /**
     * 根据大事记id查询对应的类型集合
     *
     * @param milestoneId 大事记的ID
     * @return 返回一个TreeSet，包含对应大事记的所有类型枚举
     */
    private Set<ProjectMilestoneTypeEnum> getCategoryEnumsByMilestoneId(Long milestoneId) {
        return projectMilestoneTypeMapper.selectList(new LambdaQueryWrapper<ProjectMilestoneType>()
                .eq(ProjectMilestoneType::getMilestoneId, milestoneId))
            .stream()
            .map(ProjectMilestoneType::getMilestoneType)
            .collect(Collectors.toCollection(TreeSet::new));
    }


    /**
     * 将ProjectMilestone列表中的必要属性赋给ProjectMilestoneVo对象，生成ProjectMilestoneVo列表
     *
     * @param milestones
     * @return
     */
    private List<ProjectMilestoneVo> buildMilestoneVos(List<ProjectMilestone> milestones) {
        List<ProjectMilestoneVo> milestoneVos = new ArrayList<>();

        for (ProjectMilestone milestone : milestones) {
            ProjectMilestoneVo milestoneVo = new ProjectMilestoneVo();
            BeanCopyUtils.copy(milestone, milestoneVo);

            Set<ProjectMilestoneTypeEnum> categoryEnums = getCategoryEnumsByMilestoneId(milestone.getMilestoneId());
            milestoneVo.setCategoryTypeSet(categoryEnums);

            List<Long> ossIds = projectMilestoneOssMapper.selectList(
                    new LambdaQueryWrapper<ProjectMilestoneOss>().eq(ProjectMilestoneOss::getMilestoneId, milestone.getMilestoneId()))
                .stream()
                .map(ProjectMilestoneOss::getOssId)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

            if (CollectionUtils.isNotEmpty(ossIds)) {
                List<SysOss> sysOsses = sysOssMapper.selectBatchIds(ossIds);
                milestoneVo.setSysOsses(sysOsses);
            } else {
                milestoneVo.setSysOsses(Collections.emptyList());
            }

            milestoneVos.add(milestoneVo);
        }
        return milestoneVos;
    }

    /**
     * 根据项目id去查类型列表
     */
    @Override
    public Set<ProjectMilestoneTypeEnum> getCategoryEnumsByProjectId(Long projectId) {
        if (projectId == null) {
            return Collections.emptySet();
        }

        Set<Long> milestoneIds = projectMilestoneMapper.selectList(
                new LambdaQueryWrapper<ProjectMilestone>().eq(ProjectMilestone::getProjectId, projectId))
            .stream()
            .map(ProjectMilestone::getMilestoneId)
            .collect(Collectors.toSet());

        if (milestoneIds.isEmpty()) {
            return Collections.emptySet();
        }

        return projectMilestoneTypeMapper.selectList(
                new LambdaQueryWrapper<ProjectMilestoneType>().in(ProjectMilestoneType::getMilestoneId, milestoneIds))
            .stream()
            .map(ProjectMilestoneType::getMilestoneType)
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }


    /**
     * 分页查询项目附件（大事记附件）
     *
     * @param projectMilestoneBo
     * @param pageQuery
     * @return
     */
    @Override
    public TableDataInfo<SysOssVo> queryPageAllList(ProjectMilestoneBo projectMilestoneBo, PageQuery pageQuery) {

        projectMilestoneBo = Optional.ofNullable(projectMilestoneBo).orElseGet(ProjectMilestoneBo::new);

        // 查询关联的大事记信息
        List<ProjectMilestone> milestones = fetchProjectMilestones(projectMilestoneBo);
        if (milestones.isEmpty()) {
            return TableDataInfo.build(new Page<>());
        }

        // 构建大事记 ID 到名称的映射
        Map<Long, String> milestoneIdToNameMap = buildMilestoneIdToNameMap(milestones);

        // 获取与大事记相关的 OSS ID 和对应的大事记 ID
        List<ProjectMilestoneOss> milestoneOssList = fetchMilestoneOssList(milestones);

        // 构建 OSS ID 到大事记名称的映射
        Map<Long, String> ossIdToMilestoneNameMap = buildOssIdToMilestoneNameMap(milestoneOssList, milestoneIdToNameMap);
        if (ossIdToMilestoneNameMap.isEmpty()) {
            return TableDataInfo.build(new Page<>());
        }

        // 分页查询 OSS 对象
        Page<SysOssVo> voPage = fetchOssPage(ossIdToMilestoneNameMap, pageQuery);

        // 填充 SysOssVo 列表
        List<SysOssVo> ossVoList = fillSysOssVoList(voPage.getRecords(), ossIdToMilestoneNameMap);

        // 返回结果
        return TableDataInfo.build(new Page<SysOssVo>(voPage.getCurrent(), voPage.getSize(), voPage.getTotal()).setRecords(ossVoList));
    }

    // 查询关联的大事记信息
    private List<ProjectMilestone> fetchProjectMilestones(ProjectMilestoneBo projectMilestoneBo) {
        LambdaQueryWrapper<ProjectMilestone> milestoneLambdaQueryWrapper = new LambdaQueryWrapper<>();
        milestoneLambdaQueryWrapper.eq(projectMilestoneBo.getProjectId() != null, ProjectMilestone::getProjectId, projectMilestoneBo.getProjectId());
        return projectMilestoneMapper.selectList(milestoneLambdaQueryWrapper);
    }

    // 构建大事记 ID 到名称的映射
    private Map<Long, String> buildMilestoneIdToNameMap(List<ProjectMilestone> milestones) {
        return milestones.stream()
            .collect(Collectors.toMap(ProjectMilestone::getMilestoneId, ProjectMilestone::getMilestoneTitle));
    }

    // 获取与大事记相关的 OSS ID 和对应的大事记 ID
    private List<ProjectMilestoneOss> fetchMilestoneOssList(List<ProjectMilestone> milestones) {
        List<Long> milestoneIds = milestones.stream()
            .map(ProjectMilestone::getMilestoneId)
            .collect(Collectors.toList());
        LambdaQueryWrapper<ProjectMilestoneOss> milestoneOssLambdaQueryWrapper = new LambdaQueryWrapper<>();
        milestoneOssLambdaQueryWrapper.in(!milestoneIds.isEmpty(), ProjectMilestoneOss::getMilestoneId, milestoneIds);
        return projectMilestoneOssMapper.selectList(milestoneOssLambdaQueryWrapper);
    }

    // 构建 OSS ID 到大事记名称的映射
    private Map<Long, String> buildOssIdToMilestoneNameMap(List<ProjectMilestoneOss> milestoneOssList, Map<Long, String> milestoneIdToNameMap) {
        return milestoneOssList.stream()
            .collect(Collectors.toMap(
                ProjectMilestoneOss::getOssId,
                o -> {
                    Long milestoneId = o.getMilestoneId();
                    return milestoneIdToNameMap.getOrDefault(milestoneId, ""); // 检查键是否存在，如果不存在返回空字符串
                },
                (existing, replacement) -> existing)
            );
    }

    // 分页查询 OSS 对象
    private Page<SysOssVo> fetchOssPage(Map<Long, String> ossIdToMilestoneNameMap, PageQuery pageQuery) {
        List<Long> ossIds = new ArrayList<>(ossIdToMilestoneNameMap.keySet());
        LambdaQueryWrapper<SysOss> ossLambdaQueryWrapper = new LambdaQueryWrapper<>();
        ossLambdaQueryWrapper.in(SysOss::getOssId, ossIds)
            .orderByDesc(SysOss::getCreateTime);
        return sysOssMapper.selectVoPage(pageQuery.build(), ossLambdaQueryWrapper);
    }

    // 填充 SysOssVo 列表
    private List<SysOssVo> fillSysOssVoList(List<SysOssVo> sysOssVoList, Map<Long, String> ossIdToMilestoneNameMap) {
        return sysOssVoList.stream().map(sysOssVo -> {
            String milestoneName = ossIdToMilestoneNameMap.get(sysOssVo.getOssId());
            sysOssVo.setMilestoneTitle(milestoneName);
            return sysOssVo;
        }).collect(Collectors.toList());
    }

}
