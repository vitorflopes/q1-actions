package com.example.q6.repository;

import com.example.q6.model.Item;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ItemRepository extends R2dbcRepository<Item, Long> {
}
