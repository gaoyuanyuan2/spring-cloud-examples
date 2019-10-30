package com.yan.kafka.stream.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by yan on  08/10/2018.
 */
public interface MySource {
    String OUTPUT2 = "output2";

    @Output("output2")
    MessageChannel output2();
}
