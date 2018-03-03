package net.cc.springboot.demo.ativemq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author zhonghua.zhi
 * Created by 2018/3/1 - 上午12:24
 * ************************************
 * 消费者类
 * Project Name springboot-demo
 * Package Name net.cc.springboot.demo.ativemq.consumer
 */
@Component
public class MyConsumer {

    private Logger logger = LoggerFactory.getLogger(MyConsumer.class);

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String textMsg) {
        logger.debug("接收到消息 textMsg :{}", textMsg);
    }
}