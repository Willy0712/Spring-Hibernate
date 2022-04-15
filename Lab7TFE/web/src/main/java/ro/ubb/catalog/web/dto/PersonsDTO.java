package ro.ubb.catalog.web.dto;

import lombok.*;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonsDTO {

    private Set<PersonDTO> persons;
}
