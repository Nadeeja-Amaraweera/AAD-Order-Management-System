package lk.ijse.OrderManagementSystem.Repository;

import lk.ijse.OrderManagementSystem.DTO.UserDTO;
import lk.ijse.OrderManagementSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);

    Optional<User> findByUserNameAndPassword(String username, String password);
}
