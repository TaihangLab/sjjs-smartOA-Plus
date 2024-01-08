package com.ruoyi.ip.domain.vo;

import com.ruoyi.common.enums.DiplomaTypeEnum;
import com.ruoyi.common.enums.JobTitleEnum;
import lombok.Data;

/**
 * @author bailingnan
 * @date 2024/1/3
 */
@Data
public class IpUserVO {
    /**
     * ID
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String nickName;

    /**
     * 用户职称
     */
    private JobTitleEnum jobTitle;

    /**
     * 用户学历
     */
    private DiplomaTypeEnum diploma;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phonenumber;

    /**
     * 部门名称
     */
    private String deptName;
}
