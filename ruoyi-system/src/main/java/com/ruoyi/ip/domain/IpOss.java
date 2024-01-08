package com.ruoyi.ip.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

/**
 * 知识产权和存储对象关联表
 * @TableName ip_oss
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@TableName(value = "ip_oss")
public class IpOss implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 知识产权id
     */
    private Long ipId;

    /**
     * 存储对象id
     */
    private Long ossId;
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IpOss that = (IpOss) o;
        return Objects.equals(this.ipId, that.ipId) && Objects.equals(this.ossId, that.ossId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ipId, this.ossId);
    }
}
