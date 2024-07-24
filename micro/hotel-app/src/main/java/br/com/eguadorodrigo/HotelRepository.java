package br.com.eguadorodrigo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HotelRepository implements PanacheRepository<HotelEntity> {}
