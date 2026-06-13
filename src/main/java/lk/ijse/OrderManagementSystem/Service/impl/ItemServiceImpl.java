package lk.ijse.OrderManagementSystem.Service.impl;

import lk.ijse.OrderManagementSystem.DTO.ItemDTO;
import lk.ijse.OrderManagementSystem.Entity.Item;
import lk.ijse.OrderManagementSystem.Repository.ItemRepository;
import lk.ijse.OrderManagementSystem.Service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setItemName(itemDTO.getItemName());
        item.setUnitPrice(itemDTO.getUnitPrice());

        Item saveItem = itemRepository.save(item);

        ItemDTO responseDto = new ItemDTO();
        responseDto.setItemId(saveItem.getItemId());
        responseDto.setItemName(saveItem.getItemName());
        responseDto.setUnitPrice(saveItem.getUnitPrice());

        return responseDto;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return List.of();
    }

    @Override
    public ItemDTO getItemDetails(long id) {
        return null;
    }

    @Override
    public ItemDTO updateItem(ItemDTO itemDTO) {
        return null;
    }
}
