package com.ecommerce.catalog.controller.item;

import com.ecommerce.catalog.model.Item;
import com.ecommerce.catalog.service.ItemService;
import com.ecommerce.common.item.ItemCreateDto;
import com.ecommerce.common.item.ItemDTO;
import com.ecommerce.common.item.ItemUpdateDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/items")
@RestController
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        ItemDTO itemDTO = new ItemDTO(item.getId(), item.getName(), item.getDescription(), item.getPrice(), item.getType());

        return ResponseEntity.ok(itemDTO);
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        List<ItemDTO> itemsResponse = items.stream().map(i -> new ItemDTO(i.getId(), i.getName(), i.getDescription(), i.getPrice(), i.getType())).toList();

        return ResponseEntity.ok(itemsResponse);
    }

    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemCreateDto itemCreateDto) {
        Item item = new Item();
        item.setName(itemCreateDto.name());
        item.setDescription(itemCreateDto.description());
        item.setPrice(itemCreateDto.price());
        item.setType(itemCreateDto.type());
        item.setCreationDate(java.time.LocalDateTime.now());

        Item createdItem = itemService.createItem(item);
        ItemDTO itemDTO = new ItemDTO(createdItem.getId(), createdItem.getName(), createdItem.getDescription(), createdItem.getPrice(), createdItem.getType());

        return ResponseEntity.status(HttpStatus.CREATED).body(itemDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable Long id, @RequestBody ItemUpdateDto itemUpdateDto) {
        Item updatedItem = new Item();
        updatedItem.setName(itemUpdateDto.name());
        updatedItem.setDescription(itemUpdateDto.description());
        updatedItem.setPrice(itemUpdateDto.price());
        updatedItem.setType(itemUpdateDto.type());
        updatedItem.setUpdateDate(java.time.LocalDateTime.now());

        Item savedItem = itemService.updateItem(id, updatedItem);
        ItemDTO itemDTO = new ItemDTO(savedItem.getId(), savedItem.getName(), savedItem.getDescription(), savedItem.getPrice(), savedItem.getType());

        return ResponseEntity.ok(itemDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
