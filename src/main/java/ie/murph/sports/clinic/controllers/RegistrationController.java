package ie.murph.sports.clinic.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ie.murph.sports.clinic.domain.Person;
import ie.murph.sports.clinic.service.LoginService;
import ie.murph.sports.clinic.service.RegistrationService;

@Controller
@RequestMapping("/person")
public class RegistrationController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	private static final String personRegisterUrl = "person/register";
	
	@Autowired
	private RegistrationService registerService;

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String allowAccessToRegisterPersonDetailsPage(Model model) 
    {
    	LOGGER.info("+allowAccessToRegisterPersonDetailsPage()");
    	passPersonObjectToRegisterPage(model);
        return personRegisterUrl;
    }
    
    private void passPersonObjectToRegisterPage(Model model)
    {
    	 model.addAttribute("person", new Person());
    }
    
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String submitPersonalDetailsForRegistration(Person person, Model model) 
    {
    	LOGGER.info("+submitLoginUsernameAndPassword()");
    	registerService.savePersonDetails(person);
        return "person/login";
    }
    
}
