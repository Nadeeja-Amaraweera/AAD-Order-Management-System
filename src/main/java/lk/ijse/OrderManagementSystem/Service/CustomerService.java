package lk.ijse.OrderManagementSystem.Service;

import lk.ijse.OrderManagementSystem.DTO.CustomerDTO;
import lk.ijse.OrderManagementSystem.DTO.FilterOrderDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(long id);

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    List<FilterOrderDTO> getCustomerOrders(long customerId);
}
