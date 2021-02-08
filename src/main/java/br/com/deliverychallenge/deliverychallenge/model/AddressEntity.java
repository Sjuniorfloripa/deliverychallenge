package br.com.deliverychallenge.deliverychallenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "street_name")
	private String street;
	
	@Column(name = "number")
	private int number;
	
	@Column(name = "complement")
	private String complement;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "zip")
	private String zip;
	
}
