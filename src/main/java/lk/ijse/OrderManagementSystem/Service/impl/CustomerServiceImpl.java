package lk.ijse.OrderManagementSystem.Service.impl;

import lk.ijse.OrderManagementSystem.DTO.CustomerDTO;
import lk.ijse.OrderManagementSystem.DTO.FilterOrderDTO;
import lk.ijse.OrderManagementSystem.DTO.ItemDTO;
import lk.ijse.OrderManagementSystem.Entity.Customer;
import lk.ijse.OrderManagementSystem.Entity.Item;
import lk.ijse.OrderManagementSystem.Entity.Order;
import lk.ijse.OrderManagementSystem.Entity.OrderItem;
import lk.ijse.OrderManagementSystem.Repository.CustomerRepository;
import lk.ijse.OrderManagementSystem.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        log.info("CustomerServiceImpl - saveCustomer() called");
        try {
        Customer customer = new Customer();
        customer.setCustomerName(customerDTO.getCustomerName());

        Customer saveCustomer = customerRepository.save(customer);
        CustomerDTO responseDTO = new CustomerDTO();
        responseDTO.setCustomerId(saveCustomer.getCustomerId());
        responseDTO.setCustomerName(saveCustomer.getCustomerName());

        return responseDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        log.info("CustomerServiceImpl - getAllCustomers() called");
        try {
            List<CustomerDTO> customerDTOList = new ArrayList<>();
            List<Customer> customers = customerRepository.findAll();

            for (Customer customer : customers){
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setCustomerId(customer.getCustomerId());
                customerDTO.setCustomerName(customer.getCustomerName());
                customerDTOList.add(customerDTO);
            }
            return customerDTOList;

        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public CustomerDTO getCustomerById(long id) {
        log.info("CustomerServiceImpl - getCustomerById() called with ID: {}", id);
        try {

            Optional<Customer> customerOptional = customerRepository.findById(id);
            if (!customerOptional.isPresent()){
                throw new RuntimeException("Customer not found with ID: " + id);
            }
            Customer customer = customerOptional.get();
            CustomerDTO responseDTO = new CustomerDTO();
            responseDTO.setCustomerId(customer.getCustomerId());
            responseDTO.setCustomerName(customer.getCustomerName());

            return responseDTO;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        log.info("CustomerServiceImpl - updateCustomer() called with ID: {}", customerDTO.getCustomerId());
        try {

            Optional<Customer> customerOptional = customerRepository.findById(customerDTO.getCustomerId());
            if (!customerOptional.isPresent()){
                throw new RuntimeException("Customer not found with ID: " + customerDTO.getCustomerId());
            }
            Customer customer = customerOptional.get();
            customer.setCustomerId(customerDTO.getCustomerId());
            customer.setCustomerName(customerDTO.getCustomerName());
            Customer updateCustomer = customerRepository.save(customer);
            log.info("Customer updated successfully with ID: {}", updateCustomer.getCustomerId());

            CustomerDTO responseDTO = new CustomerDTO();
            responseDTO.setCustomerId(updateCustomer.getCustomerId());
            responseDTO.setCustomerName(updateCustomer.getCustomerName());
            return responseDTO;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<FilterOrderDTO> getCustomerOrders(long customerId) {
        try {

            Optional<Customer> customerOptional = customerRepository.findById(customerId);
            if (!customerOptional.isPresent()) {
                throw new RuntimeException("Customer not found with ID: " + customerId);
            }
            Customer customer = customerOptional.get();

            List<FilterOrderDTO> responseList = new ArrayList<>();

            List<Order> orderList = customer.getOrdersList();

            for (Order order : orderList) {
                FilterOrderDTO filterOrderDTO = new FilterOrderDTO();
                filterOrderDTO.setOrderId(order.getOrderId());

                List<ItemDTO> itemDTOList = new ArrayList<>();

                List<OrderItem> orderItemList = order.getOrderItems();

                for (OrderItem orderItem : orderItemList) {
                    Item item = orderItem.getItems();

                    ItemDTO itemDTO = new ItemDTO();
                    itemDTO.setItemId(item.getItemId());
                    itemDTO.setItemName(item.getItemName());
                    item.setUnitPrice(item.getUnitPrice());

                    itemDTOList.add(itemDTO);
                }
                filterOrderDTO.setItemDTOList(itemDTOList);
                responseList.add(filterOrderDTO);
            }
            return responseList;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
