package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Intent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntentRepository extends JpaRepository<Intent, Long> {

}
