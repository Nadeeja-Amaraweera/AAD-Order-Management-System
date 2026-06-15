package lk.ijse.OrderManagementSystem.Service.impl;

import lk.ijse.OrderManagementSystem.DTO.PlaceOrderDTO;
import lk.ijse.OrderManagementSystem.Entity.Customer;
import lk.ijse.OrderManagementSystem.Entity.Item;
import lk.ijse.OrderManagementSystem.Entity.Order;
import lk.ijse.OrderManagementSystem.Entity.OrderItem;
import lk.ijse.OrderManagementSystem.Repository.CustomerRepository;
import lk.ijse.OrderManagementSystem.Repository.ItemRepository;
import lk.ijse.OrderManagementSystem.Repository.OrderItemRepository;
import lk.ijse.OrderManagementSystem.Repository.OrderRepository;
import lk.ijse.OrderManagementSystem.Service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderItemImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    public OrderItemImpl(OrderItemRepository orderItemRepository, CustomerRepository customerRepository, ItemRepository itemRepository, OrderRepository orderRepository) {
        this.orderItemRepository = orderItemRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }





    @Override
    public void placeOrder(PlaceOrderDTO placeOrderDTO) {
        log.info("OrderItemImpl - placeOrder() called with order details: {}", placeOrderDTO);
        try {

            Order order = new Order();
            order.setTotalAmount(placeOrderDTO.getTotal());

            Optional<Customer> optionalCustomer = customerRepository.findById(placeOrderDTO.getCustomerId());
            if (!optionalCustomer.isEmpty()) {
                throw new RuntimeException("Customer not found with ID: " + placeOrderDTO.getCustomerId());
            }

            Customer customer = optionalCustomer.get();
            order.setCustomer(customer);

            Order saveOrder = orderRepository.save(order);
            log.info("Order saved with ID: {}", saveOrder.getOrderId());

            for (Long itemId : placeOrderDTO.getItemIdList()){
                OrderItem orderItem = new OrderItem();

                Optional<Item> optionalItem = itemRepository.findById(itemId);
                if (!optionalCustomer.isPresent()) {
                    throw new RuntimeException("Item not found with ID: " + itemId);
                }

                Item item = optionalItem.get();
                orderItem.setOrders(saveOrder);
                orderItem.setItems(item);

                orderItemRepository.save(orderItem);
                log.info("OrderItem saved for Order ID: {} and Item ID: {}", saveOrder.getOrderId(), itemId);
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PlaceOrderDTO> filterOrders(String customerName) {

        return List.of();
    }
}
