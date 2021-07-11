package one.innovation.digital.personapiproject.controller;

import one.innovation.digital.personapiproject.dto.request.PersonDTO;
import one.innovation.digital.personapiproject.dto.response.MessageResponseDTO;
import one.innovation.digital.personapiproject.entity.Person;
import one.innovation.digital.personapiproject.exception.PersonNotFoundException;
import one.innovation.digital.personapiproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController (PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }
}
