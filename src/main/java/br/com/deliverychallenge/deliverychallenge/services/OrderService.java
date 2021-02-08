package br.com.deliverychallenge.deliverychallenge.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deliverychallenge.deliverychallenge.dto.CreateOrderDto;
import br.com.deliverychallenge.deliverychallenge.enums.OrderStatus;
import br.com.deliverychallenge.deliverychallenge.enums.PaymentStatus;
import br.com.deliverychallenge.deliverychallenge.enums.ProductType;
import br.com.deliverychallenge.deliverychallenge.exceptions.DeliveryNotFoundException;
import br.com.deliverychallenge.deliverychallenge.exceptions.OrderNotFoundException;
import br.com.deliverychallenge.deliverychallenge.model.DeliveryEntity;
import br.com.deliverychallenge.deliverychallenge.model.OrderEntity;
import br.com.deliverychallenge.deliverychallenge.model.OrderItemEntity;
import br.com.deliverychallenge.deliverychallenge.model.ProductEntity;
import br.com.deliverychallenge.deliverychallenge.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private DeliveryService deliveryService;
	@Autowired
	private ProductService productService;

	public List<OrderEntity> list() {
		return orderRepository.findAll();
	}

	public OrderEntity create(CreateOrderDto dto) throws DeliveryNotFoundException {
		DeliveryEntity delivery = deliveryService.findById(dto.getDeliveryId());
		OrderEntity orders = OrderEntity.builder()
				.delivery(delivery)
				.orderStatus(OrderStatus.WAITING)
				.payStatus(PaymentStatus.PENDING)
				.build();

		List<OrderItemEntity> items = dto.getItems().stream().map(item -> {
			try {
				ProductEntity product = productService.findById(item.getProductId());
				return OrderItemEntity.builder()
						.orders(orders)
						.product(product)
						.itemDescription(product.getDescription())
						.price(product.getPrice())
						.quantity(item.getQuantity())
						.type(ProductType.MEAL)
						.build();
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList());

		double total = 0.0;

		for (OrderItemEntity orderItemEntity : items) {
			total = total + (orderItemEntity.getPrice() * orderItemEntity.getQuantity());
		}
		orders.setTotal(total);
		orders.setItems(items);
		return orderRepository.save(orders);
	}
	
	public OrderEntity findById(Long id) throws OrderNotFoundException {
		return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found."));
	}

}
