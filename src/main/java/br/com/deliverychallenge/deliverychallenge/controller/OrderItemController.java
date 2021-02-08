package br.com.deliverychallenge.deliverychallenge.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliverychallenge.deliverychallenge.model.OrderItemEntity;
import br.com.deliverychallenge.deliverychallenge.services.OrderItemService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order_items")
@RequiredArgsConstructor
public class OrderItemController {
	
	private final OrderItemService orderItemService;
	
	@GetMapping
	public List<OrderItemEntity> list(){
		return orderItemService.list();
	}
	
	@PostMapping
	private OrderItemEntity create(@RequestBody OrderItemEntity orderItem) {
		return orderItemService.create(orderItem);
	}
}
