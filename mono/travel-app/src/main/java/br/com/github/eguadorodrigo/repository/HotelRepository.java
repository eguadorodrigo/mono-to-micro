package br.com.github.eguadorodrigo.repository;

import br.com.github.eguadorodrigo.hotel.HotelEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HotelRepository implements PanacheRepository<HotelEntity> {}
