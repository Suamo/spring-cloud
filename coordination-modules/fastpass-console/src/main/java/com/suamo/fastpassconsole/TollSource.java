package com.suamo.fastpassconsole;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TollSource {

    @Output("fastpassTollChannel")
    MessageChannel fastpassToll();

    @Output("standardTollChannel")
    MessageChannel standardToll();

}
