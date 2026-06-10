package lk.ijse.OrderManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    private String itemName;
    private double unitPrice;

    @OneToMany(mappedBy = "items",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<OrderItem> orderItems;
}
