package com.ex.demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConf : AbstractWebSocketMessageBrokerConfigurer() {
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
//        super.configureMessageBroker(registry)
        registry.enableSimpleBroker("/topic")
        registry.setApplicationDestinationPrefixes("/app")
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
//        super.registerStompEndpoints(registry)
        registry.addEndpoint("/chat")
        registry.addEndpoint("/chat").withSockJS()
    }
}