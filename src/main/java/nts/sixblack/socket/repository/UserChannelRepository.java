package nts.sixblack.socket.repository;

import nts.sixblack.socket.model.Channel;
import nts.sixblack.socket.model.UserChannel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserChannelRepository extends JpaRepository<UserChannel, Long> {
    List<UserChannel> findUserChannelByChannel(Channel channel);
    UserChannel findUserChannelById(long id);
}