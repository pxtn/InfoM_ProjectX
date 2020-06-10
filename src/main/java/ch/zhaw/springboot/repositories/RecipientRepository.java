package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Sender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Sender, Long> {

}
