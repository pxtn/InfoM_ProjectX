package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface SenderRepository extends JpaRepository<Sender, Long> {

    @Query("SELECT send.name FROM Sender send, Message msg WHERE send.id = msg.sender.id AND msg.date = ?1")
    public List<String> getNameOfSenderOfMessageFromDate(Date date);
}
