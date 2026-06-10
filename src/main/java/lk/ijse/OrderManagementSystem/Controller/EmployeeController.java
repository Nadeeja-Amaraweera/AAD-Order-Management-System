package lk.ijse.OrderManagementSystem.Controller;

import lk.ijse.OrderManagementSystem.Constant.CommonResponse;
import lk.ijse.OrderManagementSystem.DTO.EmployeeDTO;
import lk.ijse.OrderManagementSystem.Service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lk.ijse.OrderManagementSystem.Constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.OrderManagementSystem.Constant.ResponseStatusCode.OPERATION_SUCCESS;

@Slf4j
@RestController
@RequestMapping("v1/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        log.info("EmployeeController - saveEmployee() called");
        EmployeeDTO employeeDTO1 = employeeService.saveEmployee(employeeDTO);
        return new CommonResponse(OPERATION_SUCCESS,employeeDTO1,SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/get-all",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllEmployees() {
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
        log.info("EmployeeController - getAllEmployees() called");
        return new CommonResponse(OPERATION_SUCCESS, employeeDTOList, SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/get-employee-details/{employeeId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getEmployeeDetails(@PathVariable long employeeId) {
        log.info("EmployeeController - getEmployeeDetails() called with employeeId: {}", employeeId);
        EmployeeDTO employeeDTO = employeeService.getEmployeeDetails(employeeId);
        return new CommonResponse(OPERATION_SUCCESS, employeeDTO, SUCCESS_MESSAGE);
    }
}
