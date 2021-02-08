package br.com.deliverychallenge.deliverychallenge.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliverychallenge.deliverychallenge.model.DeliveryEntity;
import br.com.deliverychallenge.deliverychallenge.services.DeliveryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

	private final DeliveryService deliveryService;

	@GetMapping
	public List<DeliveryEntity> list() {
		return deliveryService.list();
	}

	@PostMapping
	public DeliveryEntity create(@RequestBody DeliveryEntity delivery) {
		return deliveryService.create(delivery);
	}

}
