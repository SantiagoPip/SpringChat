package com.santiago.chat.config;

import com.santiago.chat.chat.ChatMessage;
import com.santiago.chat.chat.MessageType;
import org.apache.catalina.SessionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Optional;

@Component

public class WebSocketEventListener {
    private static final Logger log = LoggerFactory.getLogger(WebSocketEventListener.class);
    private final SimpMessageSendingOperations messagingTemplate;

    public WebSocketEventListener(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @EventListener
public void handleWebSocketDisconnectListener(
        SessionDisconnectEvent event
){
    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
    String username = (String) headerAccessor.getSessionAttributes().get("username");
    if(username != null){
        log.info("User disconnected: {}",username);
        var chatMessage = new ChatMessage.Builder()
                .type(MessageType.LEAVER)
                .sender(username).
                build();
        messagingTemplate.convertAndSend("/topic/public", Optional.ofNullable(chatMessage));
    }
}
}
