package systems.ab4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import systems.ab4.model.Role;
import systems.ab4.repository.RoleRepository;

/**
 * Created by radug on 6/17/2017.
 */
@Service
public class RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public void save(Role role){
        roleRepository.save(role);
    }

    public Role findByRoleName(String roleName){
        return roleRepository.findByRoleName(roleName);
    }
}
