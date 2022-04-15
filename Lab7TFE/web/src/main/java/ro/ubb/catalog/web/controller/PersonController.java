package ro.ubb.catalog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Location;
import ro.ubb.catalog.core.model.Person;
import ro.ubb.catalog.core.service.PersonService;
import ro.ubb.catalog.web.converter.PersonConverter;
import ro.ubb.catalog.web.dto.LocationDTO;
import ro.ubb.catalog.web.dto.LocationsDTO;
import ro.ubb.catalog.web.dto.PersonDTO;
import ro.ubb.catalog.web.dto.PersonsDTO;

import java.util.List;
import java.util.Set;


@RestController
public class PersonController {
    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @Autowired
    PersonConverter personConverter;

    @RequestMapping(value = "/persons")
    PersonsDTO getAllPersons() {
        //todo: logs
        List<Person> persons = personService.getAllPerson();
        Set<PersonDTO> dtos = personConverter.convertModelsToDtos(persons);
        return new PersonsDTO(dtos);
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    PersonDTO savePerson(@RequestBody PersonDTO dto) {
        log.trace("savePerson: dto={}", dto);
        return personConverter.convertModelToDto(personService.savePerson(
                personConverter.convertDtoToModel(dto)
        ));
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.PUT)
    PersonDTO updatePerson(@PathVariable Long id, @RequestBody PersonDTO dto) {
        //todo: logs
        return personConverter.convertModelToDto(
                personService.updatePerson(
                        id,
                        personConverter.convertDtoToModel(dto)));
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
