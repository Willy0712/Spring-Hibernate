package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class Location extends BaseEntity<Long>{
    @Column(name="name")
    private String name;

    @Column(name="altitude")
    private int altitude;

    @Column(name="typeOfHike")
    private String typeOfHike;

    @Column(name="coordinates")
    private String coordinates;

    @Column(name="city")
    private String city;

}
