package com.ruoyi.project.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ruoyi.project.domain.ProjectBalance;
import com.ruoyi.project.domain.ProjectFunds;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author 范佳兴
 * @date 2024/3/5 16:17
 */
@Data
public class ProjectBalanceVO {

    private ProjectFunds projectFunds;

    private ProjectBalance projectBalance;

}
