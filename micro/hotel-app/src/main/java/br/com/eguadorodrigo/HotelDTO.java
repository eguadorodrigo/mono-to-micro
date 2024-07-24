package br.com.eguadorodrigo;

import br.com.eguadorodrigo.service.dto.OrderDTO;

public record HotelDTO(Long id, OrderDTO oder, Integer nights) {
}
