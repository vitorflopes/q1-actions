package com.example.q6.controller;

import com.example.q6.model.Item;
import com.example.q6.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public Flux<Item> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("/rota-nova")
    public String getRotaNova() {
        return "Eu sou a rota nova.";
    }

    @GetMapping("/{id}")
    public Mono<Item> getItemById(@PathVariable long id) {
        return itemService.findById(id);
    }

    @PostMapping
    public Mono<Item> addItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteItemById(@PathVariable long id) {
        return itemService.deleteById(id);
    }
}
