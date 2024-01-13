package macv.ghactions.cicd.service;

import macv.ghactions.cicd.entity.UserEntity;
import macv.ghactions.cicd.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to retrieve all UserEntities
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }
}
