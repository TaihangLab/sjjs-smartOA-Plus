package com.ruoyi.ip.domain.vo;

import com.ruoyi.common.enums.DiplomaType;
import com.ruoyi.common.enums.JobTitle;
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
    private JobTitle jobTitle;

    /**
     * 用户学历
     */
    private DiplomaType diploma;

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
