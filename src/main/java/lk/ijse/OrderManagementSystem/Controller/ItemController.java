package lk.ijse.OrderManagementSystem.Controller;

import lk.ijse.OrderManagementSystem.Constant.CommonResponse;
import lk.ijse.OrderManagementSystem.DTO.ItemDTO;
import lk.ijse.OrderManagementSystem.Service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lk.ijse.OrderManagementSystem.Constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.OrderManagementSystem.Constant.ResponseStatusCode.OPERATION_SUCCESS;

@Slf4j
@RestController
@RequestMapping("v1/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveItem(@RequestBody ItemDTO itemDTO) {
        log.info("ItemController - saveItem() called");
        ItemDTO itemDTO1 = itemService.saveItem(itemDTO);
        return new CommonResponse(OPERATION_SUCCESS, itemDTO1, SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllItems() {
        log.info("ItemController - getAllItems() called");
        List<ItemDTO> itemDTOList = itemService.getAllItems();
        return new CommonResponse(OPERATION_SUCCESS, itemDTOList, SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/getById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getItemById(@PathVariable long id){
        log.info("ItemController - getItemById() called with ID: {}", id);
        ItemDTO itemDTO = itemService.getItemDetails(id);
        return new CommonResponse(OPERATION_SUCCESS, itemDTO, SUCCESS_MESSAGE);
    }

    @PostMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateItem(@RequestBody ItemDTO itemDTO) {
        log.info("ItemController - updateItem() called with ID: {}", itemDTO.getItemId());
        ItemDTO updatedItemDTO = itemService.updateItem(itemDTO);
        return new CommonResponse(OPERATION_SUCCESS, updatedItemDTO, SUCCESS_MESSAGE);
    }

}
