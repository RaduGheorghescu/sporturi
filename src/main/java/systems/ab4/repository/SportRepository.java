package systems.ab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import systems.ab4.model.Sport;

/**
 * Created by radug on 6/17/2017.
 */
public interface SportRepository extends JpaRepository<Sport, Long>{
    Sport findBySportName(String sportName);
}
