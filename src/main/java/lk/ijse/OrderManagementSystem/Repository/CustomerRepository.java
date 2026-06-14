package lk.ijse.OrderManagementSystem.Repository;

import lk.ijse.OrderManagementSystem.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
