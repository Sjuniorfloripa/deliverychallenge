package br.com.deliverychallenge.deliverychallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.deliverychallenge.deliverychallenge.model.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long>{

}
