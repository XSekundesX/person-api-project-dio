package one.innovation.digital.personapiproject.service;

import one.innovation.digital.personapiproject.dto.request.PersonDTO;
import one.innovation.digital.personapiproject.dto.response.MessageResponseDTO;
import one.innovation.digital.personapiproject.entity.Person;
import one.innovation.digital.personapiproject.infrastructure.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.innovation.digital.personapiproject.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnsSavedMessage (){
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
        MessageResponseDTO successMessage = personService.createPerson(personDTO);
        assertEquals(expectedSuccessMessage,successMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created Person with ID: " + id)
                .build();
    }
}
