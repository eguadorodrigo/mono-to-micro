package br.com.github.eguadorodrigo.hotel;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class HotelEntity extends PanacheEntity {
    public Long travelOrderId;
    public Integer nights;
}
