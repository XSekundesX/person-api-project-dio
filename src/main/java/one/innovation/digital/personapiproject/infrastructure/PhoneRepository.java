package one.innovation.digital.personapiproject.infrastructure;

import one.innovation.digital.personapiproject.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
}
