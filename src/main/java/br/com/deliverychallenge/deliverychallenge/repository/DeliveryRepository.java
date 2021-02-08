package br.com.deliverychallenge.deliverychallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.deliverychallenge.deliverychallenge.model.DeliveryEntity;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long> {

}
