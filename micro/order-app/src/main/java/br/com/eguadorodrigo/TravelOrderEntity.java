package br.com.eguadorodrigo;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="travel_order")
public class TravelOrderEntity extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name = "travelOrderSequence",
            sequenceName = "travel_order_id_seq",
            allocationSize = 1,
            initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "travelOrderSequence")
    public Long id;
}
