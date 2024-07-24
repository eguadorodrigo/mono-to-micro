package br.com.eguadorodrigo.service;

import java.util.List;

public interface AbstractResourceClient<T>{
    List<T> findAll();

    T findById(Long id);

    void create(T dto);
}
