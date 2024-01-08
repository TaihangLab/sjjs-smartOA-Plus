package com.ruoyi.ip.domain;

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
    @TableId
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
        return Objects.equals(this.ipId, that.ipId) && Objects.equals(this.userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ipId, this.userId);
    }
}
