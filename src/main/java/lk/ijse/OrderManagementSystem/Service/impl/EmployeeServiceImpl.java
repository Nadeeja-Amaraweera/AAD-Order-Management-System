package lk.ijse.OrderManagementSystem.Service.impl;

import lk.ijse.OrderManagementSystem.DTO.EmployeeDTO;
import lk.ijse.OrderManagementSystem.Entity.Employee;
import lk.ijse.OrderManagementSystem.Repository.EmployeeRepository;
import lk.ijse.OrderManagementSystem.Service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        log.info("EmployeeServiceImpl - saveEmployee() called");
        try {

            Employee employee = new Employee();
            employee.setEmployeeName(employeeDTO.getEmployeeName());
            employee.setEmployeeRole(employeeDTO.getEmployeeRole());

             Employee saveEmployee = employeeRepository.save(employee);
             log.info("Employee saved with ID: {}", employee.getEmployeeId());

            EmployeeDTO responseDto = new EmployeeDTO();
            responseDto.setEmployeeId(saveEmployee.getEmployeeId());
            responseDto.setEmployeeName(saveEmployee.getEmployeeName());
            responseDto.setEmployeeRole(saveEmployee.getEmployeeRole());

            return responseDto;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        log.info("EmployeeServiceImpl - getAllEmployees() called");
        try {

            List<EmployeeDTO> employeeDTOList = new ArrayList<>();

            List<Employee> employees = employeeRepository.findAll();

            for (Employee employee : employees){
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.setEmployeeId(employee.getEmployeeId());
                employeeDTO.setEmployeeName(employee.getEmployeeName());
                employeeDTO.setEmployeeRole(employee.getEmployeeRole());

                employeeDTOList.add(employeeDTO);

            }
            return employeeDTOList;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public EmployeeDTO getEmployeeDetails(long employeeId) {
        log.info("EmployeeServiceImpl - getEmployeeDetails() called");
        try {

            Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
                if (!optionalEmployee.isPresent()){
                    throw new RuntimeException("Employee not found with ID: " + employeeId);
                }

            Employee employee = optionalEmployee.get();
                EmployeeDTO employeeDTO = new EmployeeDTO();

                employeeDTO.setEmployeeId(employee.getEmployeeId());
                employeeDTO.setEmployeeName(employee.getEmployeeName());
                employeeDTO.setEmployeeRole(employee.getEmployeeRole());

                return employeeDTO;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public EmployeeDTO updateEmployeeDetails(EmployeeDTO employeeDTO) {
        log.info("EmployeeServiceImpl - updateEmployeeDetails() called");
        try {

            Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDTO.getEmployeeId());
            if (!optionalEmployee.isPresent()){
                throw new RuntimeException("Employee not found with ID: " + employeeDTO.getEmployeeId());
            }

            Employee employee = optionalEmployee.get();
            employee.setEmployeeId(employeeDTO.getEmployeeId());
            employee.setEmployeeName(employeeDTO.getEmployeeName());
            employee.setEmployeeRole(employeeDTO.getEmployeeRole());

              Employee saveEmployee =  employeeRepository.save(employee);

              EmployeeDTO responseDTO = new EmployeeDTO();
              responseDTO.setEmployeeId(saveEmployee.getEmployeeId());
              responseDTO.setEmployeeName(saveEmployee.getEmployeeName());
              responseDTO.setEmployeeRole(saveEmployee.getEmployeeRole());

              return responseDTO;

        } catch (Exception e) {
            throw e;
        }
    }
}
