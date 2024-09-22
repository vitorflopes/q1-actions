package com.example.q6;

import com.example.q6.model.Item;
import com.example.q6.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureWebTestClient
class ItemControllerTests {

	@Autowired
	private WebTestClient webTestClient;

	@MockBean
	private ItemService itemService;

	@Test
	void testGetAllItems() {
		List<Item> itemList = List.of(
				new Item(1L, "Item1", "Descricao 1"),
				new Item(2L, "Item2", "Descricao 2")
		);

		when(itemService.findAll()).thenReturn(Flux.fromIterable(itemList));

		webTestClient.get()
				.uri("/api/item")
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(Item.class)
				.hasSize(2)
				.contains(
						new Item(1L, "Item1", "Descricao 1"),
						new Item(2L, "Item2", "Descricao 2")
				);
	}

	/*
	@Test
	void testGetItemById() {
		Item item = new Item(1, "Item1");

		// Mockando o comportamento do serviço
		when(itemService.findById(1L)).thenReturn(Mono.just(item));

		// Testando o endpoint GET /api/item/{id}
		webTestClient.get()
				.uri("/api/item/1")
				.exchange()
				.expectStatus().isOk()
				.expectBody(Item.class)
				.isEqualTo(item);
	}

	@Test
	void testAddItem() {
		Item newItem = new Item(null, "NewItem");
		Item savedItem = new Item(3L, "NewItem");

		// Mockando o comportamento do serviço
		when(itemService.save(newItem)).thenReturn(Mono.just(savedItem));

		// Testando o endpoint POST /api/item
		webTestClient.post()
				.uri("/api/item")
				.bodyValue(newItem)
				.exchange()
				.expectStatus().isOk()
				.expectBody(Item.class)
				.isEqualTo(savedItem);
	}

	@Test
	void testDeleteItemById() {
		// Mockando o comportamento do serviço
		when(itemService.deleteById(1L)).thenReturn(Mono.empty());

		// Testando o endpoint DELETE /api/item/{id}
		webTestClient.delete()
				.uri("/api/item/1")
				.exchange()
				.expectStatus().isOk();
	}
	 */
}

