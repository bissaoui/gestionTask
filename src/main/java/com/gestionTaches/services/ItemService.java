package com.gestionTaches.services;

import java.util.List;

import com.gestionTaches.dto.ItemDto;


public interface ItemService {
    
    ItemDto createItem(ItemDto itemDto);
    
    List<ItemDto> getAllItems();
    
    ItemDto getItemById(Long id);
    
    ItemDto updateItem(Long id, ItemDto itemDto);
    
    void deleteItem(Long id);
}