package lk.ijse.OrderManagementSystem.Service;

import lk.ijse.OrderManagementSystem.DTO.ItemDTO;

import java.util.List;

public interface ItemService {

    ItemDTO saveItem(ItemDTO itemDTO);

    List<ItemDTO> getAllItems();

    ItemDTO getItemDetails(long id);

    ItemDTO updateItem(ItemDTO itemDTO);
}
