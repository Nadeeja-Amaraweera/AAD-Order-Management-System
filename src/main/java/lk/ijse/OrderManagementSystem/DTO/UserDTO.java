package lk.ijse.OrderManagementSystem.DTO;

import lk.ijse.OrderManagementSystem.Enumaration.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long userId;
    private String userName;
    private String password;
    private String userRoles;
    private UserStatus userStatus;

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserDTO(long userId, String userName, String userRoles, UserStatus userStatus) {
        this.userId = userId;
        this.userName = userName;
        this.userRoles = userRoles;
        this.userStatus = userStatus;
    }
}
