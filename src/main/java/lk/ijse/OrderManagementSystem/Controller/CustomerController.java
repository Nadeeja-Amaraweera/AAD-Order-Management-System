package lk.ijse.OrderManagementSystem.Controller;

import lk.ijse.OrderManagementSystem.Constant.CommonResponse;
import lk.ijse.OrderManagementSystem.DTO.CustomerDTO;
import lk.ijse.OrderManagementSystem.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lk.ijse.OrderManagementSystem.Constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.OrderManagementSystem.Constant.ResponseStatusCode.OPERATION_SUCCESS;

@Slf4j
@RestController
@RequestMapping("v1/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveCustomer(@RequestBody CustomerDTO customerDTO){
        log.info("CustomerController - saveCustomer() called");
        CustomerDTO customerDTO1 = customerService.saveCustomer(customerDTO);
        return new CommonResponse(OPERATION_SUCCESS, customerDTO1, SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllCustomers() {
        log.info("CustomerController - getAllCustomers() called");
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        return new CommonResponse(OPERATION_SUCCESS, customerDTOList, SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/getById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getCustomerById(@PathVariable long id) {
        log.info("CustomerController - getCustomerById() called with ID: {}", id);
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return new CommonResponse(OPERATION_SUCCESS, customerDTO, SUCCESS_MESSAGE);
    }

    @PostMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateCustomer(@RequestBody CustomerDTO customerDTO){
        log.info("CustomerController - updateCustomer() called");
        CustomerDTO customerDTO1 = customerService.updateCustomer(customerDTO);
        return new CommonResponse(OPERATION_SUCCESS, customerDTO1, SUCCESS_MESSAGE);
    }
}
