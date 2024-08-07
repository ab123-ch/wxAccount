package com.tencent.wxcloudrun.vo;

import com.tencent.wxcloudrun.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.util.Date;

@Setter
@Getter
@Accessors(chain = true)
public class BusinessEventVo extends ApplicationEvent {

    private String businessName;

    private Date date;

    private User user;

    public BusinessEventVo(Object source) {
        super(source);
    }

    public BusinessEventVo(Object source, Clock clock) {
        super(source, clock);
    }
}
