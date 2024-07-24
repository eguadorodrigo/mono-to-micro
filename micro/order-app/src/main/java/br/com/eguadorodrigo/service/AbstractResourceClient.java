package br.com.eguadorodrigo.service;

public interface AbstractResourceClient<T>{
    List<T> findAll(){
        return null;
    }

    T findById(Long id){
        return null;
    }
}
