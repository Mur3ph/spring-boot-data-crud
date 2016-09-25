package ie.murph.sports.clinic.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ie.murph.sports.clinic.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long> 
{
//	Optional<Person> findOneByUsername(String username);
	Person findOneByUsername(String username);

}
