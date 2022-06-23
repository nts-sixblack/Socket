package nts.sixblack.socket.service;

import nts.sixblack.socket.model.Channel;
import nts.sixblack.socket.model.UserChannel;
import nts.sixblack.socket.repository.UserChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserChannelService {

    @Autowired
    UserChannelRepository userChannelRepository;
    public List<Long> listUserInChannel(long channelId){
        List<Long> list = new ArrayList<Long>();
        Channel channel = new Channel();
        channel.setId(channelId);

        List<UserChannel> userChannelList = userChannelRepository.findUserChannelByChannel(channel);
        for (UserChannel userChannel : userChannelList){
            list.add(userChannel.getUser().getId());
        }

        return list;
    }

    public UserChannel findById(long channelId){
        UserChannel userChannel = userChannelRepository.findUserChannelById(channelId);
        return userChannel;
    }
}
