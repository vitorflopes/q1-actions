package com.example.q6.service;

import com.example.q6.model.Item;
import com.example.q6.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Flux<Item> findAll() {
        return itemRepository.findAll();
    }

    public Mono<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public Mono<Item> save(Item item) {
        return itemRepository.save(item);
    }

    public Mono<Void> deleteById(Long id) {
        return itemRepository.deleteById(id);
    }
}
