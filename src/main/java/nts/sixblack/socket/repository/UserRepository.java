package nts.sixblack.socket.repository;

import nts.sixblack.socket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}