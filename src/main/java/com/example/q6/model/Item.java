package com.example.q6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("itens")
@Data@AllArgsConstructor@NoArgsConstructor
public class Item {
    @Id
    private Long id;
    private String name;
    private String description;
}
