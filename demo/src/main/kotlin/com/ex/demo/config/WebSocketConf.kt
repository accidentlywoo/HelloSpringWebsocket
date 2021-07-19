package com.ex.demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConf : WebSocketMessageBrokerConfigurer {
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
//        super.configureMessageBroker(registry)
        registry.enableSimpleBroker("/topic")
        /*
         built-in mwssage broker for subscription and broadcasting,
         route "/topic" destination header's message to broker
         */
        registry.setApplicationDestinationPrefixes("/app")// route to @MessagingMapping
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
//      핸드쉐이크할 endpoint
        registry.addEndpoint("/chat")
        registry.addEndpoint("/chat").withSockJS()
    }
}