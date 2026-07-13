package lk.ijse.OrderManagementSystem.DTO;

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

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
