package lk.ijse.OrderManagementSystem.Service.impl;

import lk.ijse.OrderManagementSystem.DTO.ItemDTO;
import lk.ijse.OrderManagementSystem.Entity.Item;
import lk.ijse.OrderManagementSystem.Repository.ItemRepository;
import lk.ijse.OrderManagementSystem.Service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        log.info("ItemServiceImpl - saveItem() called");
        try {
            Item item = new Item();
            item.setItemName(itemDTO.getItemName());
            item.setUnitPrice(itemDTO.getUnitPrice());

            Item saveItem = itemRepository.save(item);
            log.info("Item saved with ID: {}", saveItem.getItemId());

            ItemDTO responseDto = new ItemDTO();
            responseDto.setItemId(saveItem.getItemId());
            responseDto.setItemName(saveItem.getItemName());
            responseDto.setUnitPrice(saveItem.getUnitPrice());

            return responseDto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        log.info("ItemServiceImpl - getAllItems() called");
        try {
            List<ItemDTO> itemDTOList = new ArrayList<>();

            List<Item> items = itemRepository.findAll();
            log.info("Total items found: {}", items.size());

            for (Item item: items){
                ItemDTO itemDTO = new ItemDTO();
                itemDTO.setItemId(item.getItemId());
                itemDTO.setItemName(item.getItemName());
                itemDTO.setUnitPrice(item.getUnitPrice());
                itemDTOList.add(itemDTO);
            }
            return itemDTOList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ItemDTO getItemDetails(long id) {
        log.info("ItemServiceImpl - getItemDetails() called with ID: {}", id);
        try {
            Optional<Item> optionalItem = itemRepository.findById(id);
            if (!optionalItem.isPresent()) {
                throw new RuntimeException("Item not found with ID: " + id);
            }
            Item item = optionalItem.get();
            log.info("Item found: {}", item.getItemName());

            ItemDTO responseDTO = new ItemDTO();
            responseDTO.setItemId(item.getItemId());
            responseDTO.setItemName(item.getItemName());
            responseDTO.setUnitPrice(item.getUnitPrice());
            return responseDTO;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ItemDTO updateItem(ItemDTO itemDTO) {

        log.info("ItemServiceImpl - updateItem() called with ID: {}", itemDTO.getItemId());
        try {
            Optional<Item> optionalItem = itemRepository.findById(itemDTO.getItemId());
            if (!optionalItem.isPresent()) {
                throw new RuntimeException("Item not found with ID: " + itemDTO.getItemId());
            }
            Item item = optionalItem.get();
            item.setItemName(itemDTO.getItemName());
            item.setUnitPrice(itemDTO.getUnitPrice());
            Item updateItem = itemRepository.save(item);
            log.info("Item updated with ID: {}", item.getItemId());

            ItemDTO responseDTO = new ItemDTO();
            responseDTO.setItemId(updateItem.getItemId());
            responseDTO.setItemName(updateItem.getItemName());
            responseDTO.setUnitPrice(updateItem.getUnitPrice());
            return responseDTO;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
