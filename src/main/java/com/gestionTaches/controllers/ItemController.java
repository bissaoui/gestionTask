package com.gestionTaches.controllers;

import com.gestionTaches.dto.ItemDto;
import com.gestionTaches.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Créer un nouvel item
    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        ItemDto newItem = itemService.createItem(itemDto);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    // Obtenir tous les items
    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Obtenir un item par ID
    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable Long id) {
        ItemDto item = itemService.getItemById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    // Mettre à jour un item existant
    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        ItemDto updatedItem = itemService.updateItem(id, itemDto);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    // Supprimer un item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
