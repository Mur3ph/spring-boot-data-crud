package ie.murph.sports.clinic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.murph.sports.clinic.domain.Person;
import ie.murph.sports.clinic.repository.RegistrationRepository;

@Service
public class RegistrationService 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationService.class);

	@Autowired
    private RegistrationRepository repository;
	
	public void savePersonDetails(Person person)
	{
		LOGGER.info("+savePersonDetails()");
		repository.save(person);
	}
}
