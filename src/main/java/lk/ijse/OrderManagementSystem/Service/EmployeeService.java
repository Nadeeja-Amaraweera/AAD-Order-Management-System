package lk.ijse.OrderManagementSystem.Service;

import lk.ijse.OrderManagementSystem.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeDetails(long employeeId);

    EmployeeDTO updateEmployeeDetails(EmployeeDTO employeeDTO);
}
