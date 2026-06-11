package lk.ijse.OrderManagementSystem.Repository;

import lk.ijse.OrderManagementSystem.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
