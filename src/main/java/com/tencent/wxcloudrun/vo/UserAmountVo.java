package com.tencent.wxcloudrun.vo;

import com.tencent.wxcloudrun.dto.Amount;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserAmountVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;

    private String remark;

    private List<Amount> amountList;

}
