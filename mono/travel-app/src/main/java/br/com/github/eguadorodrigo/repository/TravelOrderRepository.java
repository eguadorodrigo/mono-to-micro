package br.com.github.eguadorodrigo.repository;

import br.com.github.eguadorodrigo.order.TravelOrderEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class TravelOrderRepository implements PanacheRepository<TravelOrderEntity> {
}
