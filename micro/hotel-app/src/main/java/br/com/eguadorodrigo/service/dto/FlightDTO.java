package br.com.eguadorodrigo.service.dto;

public record FlightDTO(Long id, OrderDTO order, String fromAirport, String toAirport){}
