package one.innovation.digital.personapiproject.service;

import one.innovation.digital.personapiproject.dto.MessageResponseDTO;
import one.innovation.digital.personapiproject.entity.Person;
import one.innovation.digital.personapiproject.infrastructure.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created Person with id: " + savedPerson.getId())
                .build();
    }
}
