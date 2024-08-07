package com.tencent.wxcloudrun.utils;

import com.tencent.wxcloudrun.vo.BusinessEventVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 监听器，用于发送微信通知
 */
@Component
@Slf4j
public class BusinessMessagePushListener {

    @EventListener(classes = BusinessEventVo.class)
    public void sendMessage(BusinessEventVo businessEventVo){

    }

}
