package br.com.eguadorodrigo.service.dto;

import br.com.eguadorodrigo.HotelDTO;

public record OrderDTO(Long id, FlightDTO flight, HotelDTO hotel){}
