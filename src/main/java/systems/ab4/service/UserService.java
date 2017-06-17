package systems.ab4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import systems.ab4.model.User;
import systems.ab4.repository.UserRepository;

/**
 * Created by radug on 6/17/2017.
 */
@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository =  userRepository;
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User findByUsername(String username){
        return userRepository.findByUserName(username);
    }

}
