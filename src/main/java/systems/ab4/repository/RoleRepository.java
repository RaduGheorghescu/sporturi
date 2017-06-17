package systems.ab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import systems.ab4.model.Role;

/**
 * Created by radug on 6/17/2017.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByRoleName(String roleName);
}
