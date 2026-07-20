package lk.ijse.OrderManagementSystem.Service.impl;

import lk.ijse.OrderManagementSystem.DTO.UserDTO;
import lk.ijse.OrderManagementSystem.Entity.User;
import lk.ijse.OrderManagementSystem.Repository.UserRepository;
import lk.ijse.OrderManagementSystem.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        log.info("Saving user: {}", userDTO);
        try {
            User user = new User();
            user.setUserName(userDTO.getUserName());
            user.setPassword(userDTO.getPassword());
            user.setUserRoles(userDTO.getUserRoles());

            User saveUser = userRepository.save(user);
            log.info("User saved successfully: {}", saveUser);
            return new UserDTO(saveUser.getUserId(), saveUser.getUserName(), saveUser.getPassword(),saveUser.getUserRoles());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDTO getUserDetails(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUserNameAndPassword(username,password);
        if(optionalUser.isEmpty())
            throw new RuntimeException("Sorry no user");

        User user = optionalUser.get();
        return new UserDTO(user.getUserId(),user.getUserName(),user.getUserRoles(),user.getPassword());
    }
}
