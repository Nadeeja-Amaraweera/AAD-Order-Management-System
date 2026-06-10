package lk.ijse.OrderManagementSystem.Entity;

import jakarta.persistence.*;
import lk.ijse.OrderManagementSystem.Enumaration.Role;
import lk.ijse.OrderManagementSystem.Enumaration.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    private String employeeName;

    @Enumerated(EnumType.STRING)
    private Role employeeRole;
}
