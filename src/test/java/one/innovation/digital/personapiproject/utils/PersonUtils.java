package one.innovation.digital.personapiproject.utils;

import one.innovation.digital.personapiproject.dto.request.PersonDTO;
import one.innovation.digital.personapiproject.entity.Person;
import one.innovation.digital.personapiproject.service.PhoneUtils;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstname(FIRST_NAME)
                .lastname(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthdate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstname(FIRST_NAME)
                .lastname(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthdate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }




}