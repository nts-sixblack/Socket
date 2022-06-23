package nts.sixblack.socket.repository;

import nts.sixblack.socket.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}