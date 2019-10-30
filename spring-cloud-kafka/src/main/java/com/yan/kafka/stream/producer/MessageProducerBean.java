package com.yan.kafka.stream.producer;

import com.yan.kafka.stream.messaging.MySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by yan on  08/10/2018.
 */
@Component
@EnableBinding({Source.class, MySource.class})
public class MessageProducerBean {

    @Autowired
    public Source source;

    @Autowired
    public MySource mySource;

    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel messageChannel;

    @Autowired
    @Qualifier(MySource.OUTPUT2)
    private MessageChannel myMessageChannel;

    public void send(String message) {
        //通过消息管道发送消息
//        messageChannel.send(MessageBuilder.withPayload(message).build());
        source.output().send(MessageBuilder.withPayload(message).build()); //方式2
    }

    public void mySend(String message) {
        myMessageChannel.send(MessageBuilder.withPayload(message).build());
    }
}
