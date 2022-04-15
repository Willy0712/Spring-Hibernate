package ro.ubb.catalog.web.dto;



import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class PersonDTO extends BaseDTO{
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer technicalLevel;
    private Integer weight;
    private String email;
    private String phoneNumber;



}
