package com.ex.demo.controller

import com.ex.demo.dto.Message
import com.ex.demo.dto.OutputMessage
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import java.text.SimpleDateFormat
import java.util.*

@Controller
class MessageController {

    @MessageMapping("/chat") // /app/chat client send SUBSCRIBE Frame
    @SendTo("/topic/messages")
    fun send(message: Message): OutputMessage {
        val time = SimpleDateFormat("HH:mm").format(Date())

        return OutputMessage(message.from, message.text, time)
    }
}