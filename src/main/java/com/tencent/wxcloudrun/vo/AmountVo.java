package com.tencent.wxcloudrun.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class AmountVo implements Serializable {

    private String username;

    private BigDecimal amountSummary;

    private Date time;

    private BigDecimal amount;

    private String productName;

    private List<AmountVo> amountVos;

}
