package com.ecommerce.catalog.service;

import com.ecommerce.catalog.model.Item;
import com.ecommerce.catalog.repository.ItemRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> {
            log.error("Item with id {} not found", id);
            return new NoSuchElementException("Item not found with id: " + id);
        });
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Transactional
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Transactional
    public Item updateItem(Long id, Item updatedItem) {
        Item existingItem = getItemById(id);

        existingItem.setName(updatedItem.getName());
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setType(updatedItem.getType());
        existingItem.setUpdateDate(updatedItem.getUpdateDate());

        return itemRepository.save(existingItem);
    }

    @Transactional
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
