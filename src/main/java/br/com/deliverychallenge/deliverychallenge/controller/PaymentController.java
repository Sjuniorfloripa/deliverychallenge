package br.com.deliverychallenge.deliverychallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliverychallenge.deliverychallenge.exceptions.OrderNotFoundException;
import br.com.deliverychallenge.deliverychallenge.model.PaymentEntity;
import br.com.deliverychallenge.deliverychallenge.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	public List<PaymentEntity> list(){
		return paymentService.list();
	}
	
	@PostMapping
	public PaymentEntity create(@RequestBody PaymentEntity payment) throws OrderNotFoundException {
		return paymentService.create(payment);
	}
}
