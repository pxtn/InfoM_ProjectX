package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Sender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Sender, Long> {

}
