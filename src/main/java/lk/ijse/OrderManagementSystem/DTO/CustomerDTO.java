package lk.ijse.OrderManagementSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private long customerId;
    private String customerName;

    public CustomerDTO(String customerName) {
        this.customerName = customerName;
    }
}
