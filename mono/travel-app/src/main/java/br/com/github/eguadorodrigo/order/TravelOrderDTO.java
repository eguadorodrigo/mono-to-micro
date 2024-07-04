package br.com.github.eguadorodrigo.order;

import br.com.github.eguadorodrigo.flight.FlightDTO;
import br.com.github.eguadorodrigo.hotel.HotelDTO;

public record TravelOrderDTO(Long id, FlightDTO flight, HotelDTO hotel){}
