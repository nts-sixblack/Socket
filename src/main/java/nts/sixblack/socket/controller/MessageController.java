package nts.sixblack.socket.controller;

import nts.sixblack.socket.form.MessageForm;
import nts.sixblack.socket.modelResponse.MessageResponse;
import nts.sixblack.socket.service.MessageService;
import nts.sixblack.socket.service.UserChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    MessageService messageService;

    @Autowired
    UserChannelService userChannelService;

    @MessageMapping("/chat")
    public void send(MessageForm messageForm) throws Exception {
        MessageResponse message = messageService.newMessage(messageForm);

        List<Long> list = userChannelService.listUserInChannel(messageForm.getChannelId());
        for (Long l:list){
            template.convertAndSend("/topic/messages/"+l, message);
        }

    }
}
