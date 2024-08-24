package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.tencent.wxcloudrun.aop.BooleanToSmallintTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenh
 * @since 2024-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Business implements Serializable {

    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /*货物品名*/
    @TableField("business_name")
    private String businessName;
    /*货物件数*/
    @TableField("count")
    private Integer count;
    /*创建时间*/
    @TableField("create_time")
    private Date createTime;
    /*创建时间*/
    @TableField("time")
    private Date time;
    /*修改时间*/
    @TableField("modify_time")
    private Date modifyTime;

    @TableField("user_id")
    private String userId;

    @TableField("create_user_id")
    private Integer createUserId;

    @TableField(value = "enable",typeHandler = BooleanToSmallintTypeHandler.class)
    private Boolean enable;

    @TableField("modify_user_id")
    private Integer updateUserId;

    @TableField("amount")
    private BigDecimal amount;

    @TableField(exist = false)
    private Integer userName;


    public void setCreateTime(String createTime) throws ParseException {
        Date parse = sDateFormat.parse(createTime);
        this.createTime = parse;
    }

    public void setTime(String time)  throws ParseException {
        Date parse = sDateFormat.parse(time);
        this.time = parse;
    }

    public void setModifyTime(String modifyTime)  throws ParseException {
        Date parse = sDateFormat.parse(modifyTime);
        this.modifyTime = parse;
    }
}
