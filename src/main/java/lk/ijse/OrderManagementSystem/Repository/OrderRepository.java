package lk.ijse.OrderManagementSystem.Repository;

import lk.ijse.OrderManagementSystem.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(value = "SELECT  * FROM orders o "+
            "JOIN customer c ON o.customer_customer_id = c.customer_id  WHERE c.customer_name = :customerName", nativeQuery = true)
    List<Order> filterOrders(String customerName);
}
