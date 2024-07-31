package com.tencent.wxcloudrun.model;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenh
 * @since 2024-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QuerySqlConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * sql
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String sql;

    /**
     * sql备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;


}
