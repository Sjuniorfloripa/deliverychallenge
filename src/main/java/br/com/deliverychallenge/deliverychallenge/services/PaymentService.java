package br.com.deliverychallenge.deliverychallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deliverychallenge.deliverychallenge.enums.PaymentStatus;
import br.com.deliverychallenge.deliverychallenge.exceptions.OrderNotFoundException;
import br.com.deliverychallenge.deliverychallenge.model.OrderEntity;
import br.com.deliverychallenge.deliverychallenge.model.PaymentEntity;
import br.com.deliverychallenge.deliverychallenge.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderService orderService;
	
	public List<PaymentEntity> list(){
		return paymentRepository.findAll();
	}
	
	public PaymentEntity create(PaymentEntity payment) throws OrderNotFoundException {
		OrderEntity orders = orderService.findById(payment.getOrders().getId());
		orders.setPayStatus(PaymentStatus.PAID);
		payment.setOrders(orders);
		
		return paymentRepository.save(payment);
	}
	
}
