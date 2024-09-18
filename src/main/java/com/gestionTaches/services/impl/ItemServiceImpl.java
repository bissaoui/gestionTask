package com.gestionTaches.services.impl;


import com.gestionTaches.entities.Item;
import com.gestionTaches.exceptions.ResourceNotFoundException;
import com.gestionTaches.repositories.ItemRepository;
import com.gestionTaches.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestionTaches.dto.ItemDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemDto createItem(ItemDto itemDto) {
        Item item = mapToEntity(itemDto);
        Item savedItem = itemRepository.save(item);
        return mapToDto(savedItem);
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public ItemDto getItemById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));
        return mapToDto(item);
    }

    @Override
    public ItemDto updateItem(Long id, ItemDto itemDto) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));
        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
        Item updatedItem = itemRepository.save(item);
        return mapToDto(updatedItem);
    }

    @Override
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));
        itemRepository.delete(item);
    }

    // Mapper pour convertir Entity en DTO
    private ItemDto mapToDto(Item item) {
        return new ItemDto(item.getId(), item.getName(), item.getDescription());
    }

    // Mapper pour convertir DTO en Entity
    private Item mapToEntity(ItemDto itemDto) {
        return new Item(itemDto.getId(), itemDto.getName(), itemDto.getDescription());
    }
}
