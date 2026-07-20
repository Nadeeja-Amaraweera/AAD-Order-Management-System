package lk.ijse.OrderManagementSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDataDTO {
    private long userId;
    private String token;

}
