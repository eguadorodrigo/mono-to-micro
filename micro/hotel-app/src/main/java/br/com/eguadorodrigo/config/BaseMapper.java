package br.com.eguadorodrigo.config;

public interface BaseMapper<E,D> {
    D toDTO(E entity);
    E toEntity(D dto);
}
