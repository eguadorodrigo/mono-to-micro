package br.com.github.eguadorodrigo.repository;

import br.com.github.eguadorodrigo.flight.FlightEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FlightRepository implements PanacheRepository<FlightEntity> {}
