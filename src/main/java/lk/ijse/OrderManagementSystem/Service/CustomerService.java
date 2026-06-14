package lk.ijse.OrderManagementSystem.Service;

import lk.ijse.OrderManagementSystem.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(long id);

    CustomerDTO updateCustomer(CustomerDTO customerDTO);
}
