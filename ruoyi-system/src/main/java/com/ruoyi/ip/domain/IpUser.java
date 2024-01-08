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
 * @TableName ip_user
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IpUser that = (IpUser) o;
        return new EqualsBuilder().append(this.ipId, that.ipId).append(this.userId, that.userId).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.ipId).append(this.userId).toHashCode();
    }
}
