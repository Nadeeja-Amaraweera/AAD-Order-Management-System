package lk.ijse.OrderManagementSystem.Service;

import lk.ijse.OrderManagementSystem.DTO.PlaceOrderDTO;

import java.util.List;

public interface OrderItemService {
    void placeOrder(PlaceOrderDTO placeOrderDTO);

    List<PlaceOrderDTO> filterOrders(String customerName);
}
