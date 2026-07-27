package lk.ijse.OrderManagementSystem.Service.impl;

import lk.ijse.OrderManagementSystem.DTO.UserDTO;
import lk.ijse.OrderManagementSystem.Entity.User;
import lk.ijse.OrderManagementSystem.Exception.CustomeException;
import lk.ijse.OrderManagementSystem.Repository.UserRepository;
import lk.ijse.OrderManagementSystem.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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

        if (userDTO.getUserRoles().equals("")) {
            throw new CustomeException(404,"Cannot create user with ADMIN role");
        }
            User user = new User();
            user.setUserName(userDTO.getUserName());
            user.setPassword(userDTO.getPassword());
            user.setUserRoles(userDTO.getUserRoles());

            User saveUser = userRepository.save(user);
            log.info("User saved successfully: {}", saveUser);
            return new UserDTO(saveUser.getUserId(), saveUser.getUserName(), saveUser.getPassword(),saveUser.getUserRoles());

    }

    @Override
    public UserDTO editUser(UserDTO userDTO) {
        log.info("Editing user: {}", userDTO);
        try {
            Optional<User> optionalUser = userRepository.findById(userDTO.getUserId());
            if (!optionalUser.isPresent()) {
                throw new RuntimeException("User not found");
            }
            User user = optionalUser.get();
            user.setUserId(userDTO.getUserId());
            user.setUserName(userDTO.getUserName());
            user.setUserRoles(userDTO.getUserRoles());

            User updatedUser = userRepository.save(user);
            log.info("User updated successfully: {}", updatedUser);
            return new UserDTO(updatedUser.getUserId(), updatedUser.getUserName(), updatedUser.getUserRoles());
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

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> allUsers = userRepository.getAllUsers();
        return allUsers;
    }

    @Override
    public void deleteUser(long userId) {
        log.info("Deleting user: {}", userId);
        try {

            Optional<User> optionalUser = userRepository.findById(userId);
            if (!optionalUser.isPresent()) {
                throw new RuntimeException("User not found");
            }
            userRepository.delete(optionalUser.get());

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
