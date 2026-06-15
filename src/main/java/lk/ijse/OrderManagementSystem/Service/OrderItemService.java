package lk.ijse.OrderManagementSystem.Service;

import lk.ijse.OrderManagementSystem.DTO.FilterOrderDTO;
import lk.ijse.OrderManagementSystem.DTO.PlaceOrderDTO;

import java.util.List;

public interface OrderItemService {
    void placeOrder(PlaceOrderDTO placeOrderDTO);

    List<FilterOrderDTO> filterOrders(String customerName);
}
