package lk.ijse.OrderManagementSystem.Service;

import lk.ijse.OrderManagementSystem.DTO.UserDTO;

import java.util.List;


public interface UserService {

    UserDTO saveUser(UserDTO userDTO);

    UserDTO getUserDetails(String username, String password);

    List<UserDTO> getAllUsers();
}
