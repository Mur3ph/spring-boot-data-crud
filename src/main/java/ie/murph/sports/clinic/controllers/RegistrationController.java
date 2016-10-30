package ie.murph.sports.clinic.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.murph.sports.clinic.domain.Person;
import ie.murph.sports.clinic.service.RegistrationService;

@Controller
@RequestMapping("/person")
public class RegistrationController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);
	private static final String redirectToPersonRegisterUrl = "person/register";
	private static final String redirectToPersonalLoginPageUrl = "person/login";
	
	@Autowired
	private RegistrationService registerService;

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String allowAccessToRegisterPersonDetailsPage(Model model) 
    {
    	LOGGER.info("+allowAccessToRegisterPersonDetailsPage()");
    	passPersonObjectToRegisterPage(model);
        return redirectToPersonRegisterUrl;
    }
    
    private void passPersonObjectToRegisterPage(Model model)
    {
    	 model.addAttribute("person", new Person());
    }
    
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String submitPersonalDetailsForRegistration(Person person, Model model) 
    {
    	LOGGER.info("+submitPersonalDetailsForRegistration()");
    	registerService.savePersonDetails(person);
        return redirectToPersonalLoginPageUrl;
    }
    
}
