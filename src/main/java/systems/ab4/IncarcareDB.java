package systems.ab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import systems.ab4.model.Location;
import systems.ab4.model.Role;
import systems.ab4.model.Sport;
import systems.ab4.model.User;
import systems.ab4.repository.LocationRepository;
import systems.ab4.repository.SportRepository;
import systems.ab4.service.RoleService;
import systems.ab4.service.UserService;

/**
 * Created by Radu on 4/21/2017.
 */
@Component
public class IncarcareDB implements ApplicationRunner {
    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    SportRepository sportRepository;
    @Autowired
    public IncarcareDB(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }


    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        roleService.save(new Role("ROLE_ADMIN"));
        User user = userService.findByUsername("admin");
        if (user == null){
            user = new User("admin","admin",roleService.findByRoleName("ROLE_ADMIN"));
            userService.save(user);
        }
        locationRepository.save(new Location("Test1"));
        sportRepository.save(new Sport("Sport1"));
    }
}
