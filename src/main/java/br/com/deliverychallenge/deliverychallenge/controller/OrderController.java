package br.com.deliverychallenge.deliverychallenge.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliverychallenge.deliverychallenge.dto.CreateOrderDto;
import br.com.deliverychallenge.deliverychallenge.model.OrderEntity;
import br.com.deliverychallenge.deliverychallenge.services.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;
	
	@GetMapping
	public List<OrderEntity> list(){
		return orderService.list();
	}
	
	@PostMapping
	public OrderEntity create(@RequestBody CreateOrderDto dto) {
		return orderService.create(dto);
	}
}
