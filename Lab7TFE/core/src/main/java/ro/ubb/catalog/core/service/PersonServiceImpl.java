package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.catalog.core.model.Location;
import ro.ubb.catalog.core.model.Person;
import ro.ubb.catalog.core.repository.IPersonRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private IPersonRepository iPersonRepository;

    @Override
    public Person savePerson(Person entity) {
        log.trace("save person: ", entity);

        Person result = iPersonRepository.save(entity);

        log.trace("result Person: ", result);

        return result;
    }

    @Override
    public List<Person> getAllPerson() {

        List<Person> result = iPersonRepository.findAll();

        log.trace("result find ALL person: " , result);

        return result;
    }

    @Override
    public Person updatePerson(Long id, Person newPerson) {

        Person update = iPersonRepository.findById(id).orElseThrow();
        update.setFirstName(newPerson.getFirstName());
        update.setLastName(newPerson.getLastName());
        update.setAge(newPerson.getAge());
        update.setEmail(newPerson.getEmail());
        update.setWeight(newPerson.getWeight());
        update.setPhoneNumber(newPerson.getPhoneNumber());
        update.setTechnicalLevel(newPerson.getTechnicalLevel());
        return update;
    }

    @Override
    public void deletePerson(Long id) {
        log.trace("delete: id={}", id);
        iPersonRepository.deleteById(id);
        log.trace("delete --- method finished");
    }
}
