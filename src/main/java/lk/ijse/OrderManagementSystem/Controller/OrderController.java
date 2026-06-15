package lk.ijse.OrderManagementSystem.Controller;

import lk.ijse.OrderManagementSystem.Constant.CommonResponse;
import lk.ijse.OrderManagementSystem.DTO.FilterOrderDTO;
import lk.ijse.OrderManagementSystem.DTO.PlaceOrderDTO;
import lk.ijse.OrderManagementSystem.Service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lk.ijse.OrderManagementSystem.Constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.OrderManagementSystem.Constant.ResponseStatusCode.OPERATION_SUCCESS;

@RestController
@RequestMapping("/v1/api/orders")
@Slf4j
public class OrderController {

    private final OrderItemService orderItemService;

    public OrderController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping(value = "/place",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveOrder(@RequestBody PlaceOrderDTO placeOrderDTO){
        orderItemService.placeOrder(placeOrderDTO);
        return new CommonResponse(OPERATION_SUCCESS,SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/filter",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse filterOrders(@RequestParam (value = "customerName",required = false) String customerName){
        List<FilterOrderDTO> filterOrderDTOS = orderItemService.filterOrders(customerName);
        return new CommonResponse(OPERATION_SUCCESS,filterOrderDTOS,SUCCESS_MESSAGE);
    }
}
