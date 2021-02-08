package br.com.deliverychallenge.deliverychallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deliverychallenge.deliverychallenge.exceptions.DeliveryNotFoundException;
import br.com.deliverychallenge.deliverychallenge.model.DeliveryEntity;
import br.com.deliverychallenge.deliverychallenge.repository.DeliveryRepository;

@Service
public class DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	public List<DeliveryEntity> list(){
		return deliveryRepository.findAll();
	}
	
	public DeliveryEntity create(DeliveryEntity delivery) {
		return deliveryRepository.save(delivery);
	}
	
	public DeliveryEntity findById(Long id) {
		return deliveryRepository.findById(id).orElseThrow(() -> new DeliveryNotFoundException("Error, delivery not found. Registration required"));
	}

}
