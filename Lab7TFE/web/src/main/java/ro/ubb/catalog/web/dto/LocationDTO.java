package ro.ubb.catalog.web.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LocationDTO extends  BaseDTO {
    private String name;
    private int altitude;
    private String typeOfHike;
    private String coordinates;
    private String city;

}
