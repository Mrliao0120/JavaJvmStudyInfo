package com.liao.bean;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/7/7 10:11
 * @Version 1.0
 * @Description
 */
@Component
public class MyApplicationEventListener  implements ApplicationListener<ApplicationEvent> {
    /**
     * take in
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("接受:"+event);
    }

}
