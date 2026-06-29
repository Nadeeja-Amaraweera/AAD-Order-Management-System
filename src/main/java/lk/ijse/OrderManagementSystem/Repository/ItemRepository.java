package lk.ijse.OrderManagementSystem.Repository;

import lk.ijse.OrderManagementSystem.DTO.ItemDTO;
import lk.ijse.OrderManagementSystem.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query(value = "SELECT * FROM item "+
    "WHERE (?1 IS NULL OR item_name LIKE %?1%)",nativeQuery = true)
    List<Item> filterItemsNative(String itemName);

    @Query(value = "SELECT "+
    "new lk.ijse.OrderManagementSystem.DTO.ItemDTO(i.itemId,i.itemName,i.unitPrice) "+
    "FROM Item i WHERE (?1 IS NULL OR i.itemName LIKE %?1%)")
    List<ItemDTO> filterItemsJPQL(String itemName);

    @Query(value = "SELECT i FROM OrderItem io "+
    "JOIN Item i ON io.items = i "+
    "JOIN Order o ON io.orders = o "+
    "WHERE o.orderId = ?1")
    List<Item> getItemsByOrder(long orderId);
}
