package ie.murph.sports.clinic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.murph.sports.clinic.domain.Person;
import ie.murph.sports.clinic.repository.LoginRepository;

@Service
public class LoginService 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

	@Autowired
    private LoginRepository repository;
	
	public Person login(String username, String password)
	{
		LOGGER.info("+login()");
		Person person = repository.findPersonByUsername(username, password);
		return person;
	}
}
