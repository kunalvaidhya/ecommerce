package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.repository.ItemRepository;

import com.example.entity.*;
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    
    // Constructor Injection
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    public Item createItem(Item newItem) {
        return itemRepository.save(newItem);
    }
    
    public Item updateItem(Long itemId, Item updatedItem) {
        Item item = itemRepository.findById(itemId).orElse(null);
        if (item != null) {
            // Update item properties based on updatedItem
            // For example:
            // item.setName(updatedItem.getName());
            // item.setPrice(updatedItem.getPrice());
            // Save the updated item
            return itemRepository.save(item);
        }
        return null;
    }
    
    public boolean deleteItem(Long itemId) {
        if (itemRepository.existsById(itemId)) {
            itemRepository.deleteById(itemId);
            return true;
        }
        return false;
    }



    // Implement CRUD operations for items
}
