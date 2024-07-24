package br.com.eguadorodrigo;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="flight")
public class FlightEntity extends PanacheEntityBase {

        @Id
        @SequenceGenerator(
                name = "flightSequence",
                sequenceName = "flight_id_seq",
                allocationSize = 1,
                initialValue = 2)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flightSequence")
        public Long id;
        public Long travelOrderId;
        public String fromAirport;
        public String toAirport;

}
