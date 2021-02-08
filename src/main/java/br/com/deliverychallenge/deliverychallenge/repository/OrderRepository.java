package br.com.deliverychallenge.deliverychallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.deliverychallenge.deliverychallenge.model.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
