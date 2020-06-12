package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SenderRepository extends JpaRepository<Sender, Long> {

    /**
     * 2.)
     * It returns the values of the Name attribute of Supertype instances that are also
     * instances of PType
     *
     * @return A list of the name of every Sender (PType)
     */
    @Query("SELECT sender.name as NamesOfPType FROM Sender sender")
    public List<String> getNamesOfPtype();

}
