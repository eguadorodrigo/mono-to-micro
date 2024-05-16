package br.com.github.eguadorodrigo.mapper;

public interface BaseMapper<E,D> {
    D toDTO(E entity);
    E toEntity(D dto);
}
