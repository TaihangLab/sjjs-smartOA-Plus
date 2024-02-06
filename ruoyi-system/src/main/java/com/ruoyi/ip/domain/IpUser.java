package com.ruoyi.ip.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * 知识产权和用户关联表
 *
 * @author bailingnan
 * @TableName ip_user
 * @date 2024/02/06
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@TableName(value = "ip_user")
public class IpUser implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 成员id
     */
    private Long userId;
    /**
     * 知识产权id
     */
    private Long ipId;

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ipId).append(userId).toHashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IpUser that = (IpUser) o;
        return new EqualsBuilder().append(ipId, that.ipId).append(userId, that.userId).isEquals();
    }
}
