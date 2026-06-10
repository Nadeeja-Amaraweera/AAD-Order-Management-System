package lk.ijse.OrderManagementSystem.Repository;

import lk.ijse.OrderManagementSystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
