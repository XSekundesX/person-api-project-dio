package one.innovation.digital.personapiproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstname;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastname;

    @NotEmpty
    @CPF
    private String cpf;

    private String birthdate;

    @NotEmpty
    @Valid
    private List<PhoneDTO> phones;
}
