package net.cc.springboot.demo.ativemq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

/**
 * @author zhonghua.zhi
 * Created by 2018/3/2 - 下午5:51
 * ************************************
 * 生产者类
 * Project Name springboot-demo
 * Package Name net.cc.springboot.demo.ativemq.producer
 */
@Component
public class MyProducer implements CommandLineRunner {

    /**
     * 实现 CommandLineRunner 接口 ,重写run方法.
     * 当SpringBoot启动完成后,就会执行 CommandLineRunner 子类.
     */

    private Logger logger = LoggerFactory.getLogger(MyProducer.class);

    @Autowired
    private Queue queue;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    private String msg = "<msgBody><id>$ID</id><title>测试信息</title></msgBody>";

    @Override
    public void run(String... strings) throws Exception {

        /**
         * 模拟生产者5条消息
         */
        for (int i = 0; i < 5; i++) {

            send();
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 构造消息,写入ActiveMQ
     */
    private void send() {

        String str = msg.replace("$ID", UUID.randomUUID().toString());
        logger.debug("str :{}", str);

        this.jmsMessagingTemplate.convertAndSend(this.queue, str);
    }
}