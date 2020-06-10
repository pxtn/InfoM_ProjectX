package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
