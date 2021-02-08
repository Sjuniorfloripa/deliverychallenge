package br.com.deliverychallenge.deliverychallenge.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderDto {

	private Long deliveryId;
	private List<CreateOrderItemDto> items;

}
