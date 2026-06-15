package lk.ijse.OrderManagementSystem.Repository;

import lk.ijse.OrderManagementSystem.Entity.Order;
import lk.ijse.OrderManagementSystem.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
