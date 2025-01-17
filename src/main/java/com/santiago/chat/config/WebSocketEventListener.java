package com.santiago.chat.config;

import org.apache.catalina.SessionEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component

public class WebSocketEventListener {
@EventListener
public void handleWebSocketDisconnectListener(
        SessionEvent event
){
    //TODO
}
}
