package lk.ijse.OrderManagementSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private long itemId;
    private String itemName;
    private double unitPrice;

    public ItemDTO(String itemName, double unitPrice) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }
}
