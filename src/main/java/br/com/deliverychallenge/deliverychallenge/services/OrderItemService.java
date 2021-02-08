package br.com.deliverychallenge.deliverychallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deliverychallenge.deliverychallenge.model.OrderItemEntity;
import br.com.deliverychallenge.deliverychallenge.repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	public List<OrderItemEntity> list() {
		return orderItemRepository.findAll();
	}

	public OrderItemEntity create(OrderItemEntity orderItem) {
		return orderItemRepository.save(orderItem);
	}
}
