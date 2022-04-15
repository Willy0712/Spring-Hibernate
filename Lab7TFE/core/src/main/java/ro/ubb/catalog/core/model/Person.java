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
public class Person extends BaseEntity<Long>{

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="age")
    private Integer age;

    @Column(name="technicalLevel")
    private Integer technicalLevel;

    @Column(name="weight")
    private Integer weight;

    @Column(name="email")
    private String email;

    @Column(name="phoneNumber")
    private String phoneNumber;
}
