package one.innovation.digital.personapiproject.controller;

import one.innovation.digital.personapiproject.dto.MessageResponseDTO;
import one.innovation.digital.personapiproject.entity.Person;
import one.innovation.digital.personapiproject.infrastructure.PersonRepository;
import one.innovation.digital.personapiproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController (PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
}
