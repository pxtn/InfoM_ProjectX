package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface SenderRepository extends JpaRepository<Sender, Long> {

    @Query("SELECT pers.name FROM Person pers, Sender send, Message msg WHERE pers.id = send.id AND send.id = msg.sender.id AND msg.date = ?1")
    public List<String> getNameOfSenderOfMessageFromDate(Date date);
}
