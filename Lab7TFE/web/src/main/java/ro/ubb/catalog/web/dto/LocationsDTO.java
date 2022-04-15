package ro.ubb.catalog.web.dto;

import lombok.*;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LocationsDTO {

    private Set<LocationDTO> locations;
}
