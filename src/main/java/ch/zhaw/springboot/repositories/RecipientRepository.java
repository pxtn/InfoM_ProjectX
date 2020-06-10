package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {

}
