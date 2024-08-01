package com.tencent.wxcloudrun.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Amount implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal amount;

    private String product;

    private Long count;
}
