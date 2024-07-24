package br.com.eguadorodrigo.service;

import br.com.eguadorodrigo.service.dto.FlightDTO;

import java.util.List;

public interface AbstractResourceClient<T>{
    List<T> findAll();

    T findById(Long id);

    void create(T dto);
}
