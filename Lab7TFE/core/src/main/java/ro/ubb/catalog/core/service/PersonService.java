package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Location;
import ro.ubb.catalog.core.model.Person;

import java.util.List;

public interface PersonService {
    Person savePerson(Person entity);

    List<Person> getAllPerson();

    Person updatePerson(Long id, Person newPerson);

    void deletePerson(Long id);


}
