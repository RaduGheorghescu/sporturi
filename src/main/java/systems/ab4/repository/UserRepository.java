package systems.ab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import systems.ab4.model.User;

/**
 * Created by radug on 6/17/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User  findByUserName(String userName);
}
