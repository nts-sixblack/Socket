package nts.sixblack.socket.repository;

import nts.sixblack.socket.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}