package ie.murph.sports.clinic.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ie.murph.sports.clinic.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long> 
{
//	Optional<Person> findOneByUsername(String username);
	Person findPersonByUsername(String username);
	
	@Query("SELECT p FROM Person p WHERE p.username = :username AND p.password = :password")
	Person findPersonByUsername(@Param("username") String username, @Param("password")String password);
//	
//	@Query("SELECT COUNT(*) FROM person p WHERE p.username = :username AND p.password = :password")
//	int findUserByUsernameAndPasswordForLogin2(@Param("username") String username, @Param("password")String password);
//	
//	@Query("")
//	Person findUserByUsernameAndPassword(String username, String password);
}
