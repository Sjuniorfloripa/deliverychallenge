package br.com.deliverychallenge.deliverychallenge.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.deliverychallenge.deliverychallenge.enums.OrderStatus;
import br.com.deliverychallenge.deliverychallenge.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@OneToMany(mappedBy = "orders", cascade = CascadeType.PERSIST)
	private List<OrderItemEntity> items;
	
	@OneToOne
	@JoinColumn(name = "delivery_id")
	private DeliveryEntity delivery;
	
	@Column(name = "total")
	private Double total;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus payStatus;
}
