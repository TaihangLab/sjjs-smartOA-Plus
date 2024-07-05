package com.ruoyi.project.service;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.domain.ProjectExpenditure;
import com.ruoyi.project.domain.bo.ProjectExpenditureBO;
import com.ruoyi.project.domain.vo.ProjectExpenditureVO;

import java.util.List;

/**
 * 项目支出Service
 *
 * @author bailingnan
 * @date 2024/03/01
 */
public interface ProjectExpenditureService {

    /**
     * 根据项目id查询项目支出信息
     * @param ExpenditureIdList
     * @return
     */
    List<ProjectExpenditure> getProjectExpenditureByExpId(List<Long> ExpenditureIdList);

    /**
     * 批量插入项目支出信息
     *
     * @param projectExpenditureBOList
     */
    void addProjectExpenditureList(List<ProjectExpenditureBO> projectExpenditureBOList);

    /**
     * 回滚支出记录
     *
     * @param expenditureId
     */
    void rollBackProjectExpenditureById(Long expenditureId) throws IllegalAccessException;

    /**
     * 查询项目支出明细
     *
     * @param projectExpenditureBO
     * @param pageQuery
     *
     * @return
     */
    TableDataInfo<ProjectExpenditureVO> getProjectExpenditureByProId(ProjectExpenditureBO projectExpenditureBO,
        PageQuery pageQuery);

    /**
     * 查询项目支出明细
     *
     * @param projectExpenditureBO
     *
     * @return
     */
    List<ProjectExpenditure> getProjectExpenditureByProId(ProjectExpenditureBO projectExpenditureBO);
}
