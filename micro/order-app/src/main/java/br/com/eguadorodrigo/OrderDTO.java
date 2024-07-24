package br.com.eguadorodrigo;

import br.com.eguadorodrigo.service.dto.FlightDTO;
import br.com.eguadorodrigo.service.dto.HotelDTO;

public record OrderDTO(Long id, FlightDTO flight, HotelDTO hotel){}
