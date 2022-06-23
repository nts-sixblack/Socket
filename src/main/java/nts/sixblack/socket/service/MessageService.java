package nts.sixblack.socket.service;

import nts.sixblack.socket.form.MessageForm;
import nts.sixblack.socket.model.Channel;
import nts.sixblack.socket.model.Message;
import nts.sixblack.socket.model.UserChannel;
import nts.sixblack.socket.modelResponse.MessageResponse;
import nts.sixblack.socket.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserChannelService userChannelService;

    public MessageResponse newMessage(MessageForm messageForm){
        MessageResponse messageResponse = new MessageResponse();

        UserChannel userChannel = new UserChannel();
        userChannel.setId(messageForm.getUserSenderId());
        Channel channel = new Channel();
        channel.setId(messageForm.getChannelId());
        Message message = new Message();
        message.setMessage(messageForm.getContent());
        message.setChannel(channel);
        message.setUserChannel(userChannel);

        messageRepository.save(message);

        userChannel = userChannelService.findById(messageForm.getChannelId());

        messageResponse.setMessage(messageForm.getContent());
        messageResponse.setChannelId(messageForm.getChannelId());
        messageResponse.setName(userChannel.getUser().getName());

        return messageResponse;
    }
}
