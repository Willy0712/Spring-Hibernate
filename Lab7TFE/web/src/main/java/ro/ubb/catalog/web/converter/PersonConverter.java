package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Person;
import ro.ubb.catalog.web.dto.PersonDTO;

@Component
public class PersonConverter extends BaseConverter<Person, PersonDTO>{
    @Override
    public Person convertDtoToModel(PersonDTO dto) {
        Person person = Person.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .technicalLevel(dto.getTechnicalLevel())
                .weight(dto.getWeight())
                .build();
        person.setId(dto.getId());
        return person;
    }

    @Override
    public PersonDTO convertModelToDto(Person person) {
        PersonDTO personDTO = PersonDTO.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .age(person.getAge())
                .email(person.getEmail())
                .phoneNumber(person.getPhoneNumber())
                .technicalLevel(person.getTechnicalLevel())
                .weight(person.getWeight())
                .build();
        personDTO.setId(person.getId());
        return personDTO;
    }
}
