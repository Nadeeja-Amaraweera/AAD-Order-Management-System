package lk.ijse.OrderManagementSystem.DTO;

import lk.ijse.OrderManagementSystem.Enumaration.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private long employeeId;
    private String employeeName;
    private Role employeeRole;

    public EmployeeDTO(String employeeName, Role employeeRole) {
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
    }
}
