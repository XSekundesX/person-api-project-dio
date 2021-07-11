package one.innovation.digital.personapiproject.service;

import lombok.AllArgsConstructor;
import one.innovation.digital.personapiproject.dto.request.PersonDTO;
import one.innovation.digital.personapiproject.dto.response.MessageResponseDTO;
import one.innovation.digital.personapiproject.entity.Person;
import one.innovation.digital.personapiproject.exception.PersonNotFoundException;
import one.innovation.digital.personapiproject.infrastructure.PersonRepository;
import one.innovation.digital.personapiproject.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = PersonMapper.INSTANCE.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponseDTO(personToSave.getId(), "Created person with ID: ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException{
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = PersonMapper.INSTANCE.toModel(personDTO);

        Person savedPerson = personRepository.save(personToUpdate);
        return createMessageResponseDTO(savedPerson.getId(),"Updated Person with ID: ");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));
    }
    
    private MessageResponseDTO createMessageResponseDTO(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message+ id)
                .build();
    }


}
