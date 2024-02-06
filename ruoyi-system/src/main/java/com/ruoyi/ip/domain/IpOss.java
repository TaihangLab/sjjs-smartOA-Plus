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
 * 知识产权和存储对象关联表
 *
 * @author bailingnan
 * @TableName ip_oss
 * @date 2024/02/06
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@TableName(value = "ip_oss")
public class IpOss implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 知识产权id
     */
    private Long ipId;

    /**
     * 存储对象id
     */
    private Long ossId;

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ipId).append(ossId).toHashCode();
    }

    /**
     * id
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IpOss that = (IpOss) o;
        return new EqualsBuilder().append(ipId, that.ipId).append(ossId, that.ossId).isEquals();
    }
}
