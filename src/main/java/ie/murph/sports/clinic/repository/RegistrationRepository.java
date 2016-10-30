package ie.murph.sports.clinic.repository;

import org.springframework.data.repository.CrudRepository;

import ie.murph.sports.clinic.domain.Person;

public interface RegistrationRepository extends CrudRepository<Person, Long> 
{
	
}
