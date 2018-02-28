package net.cc.springboot.demo.ativemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author zhonghua.zhi
 * Created by 2018/3/1 - 上午12:24
 * ************************************
 * Project Name springboot-demo
 * Package Name net.cc.springboot.demo.ativemq.consumer
 */
@Component
public class MyConsumer {

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String textMsg) {
        System.out.println(textMsg);
    }
}