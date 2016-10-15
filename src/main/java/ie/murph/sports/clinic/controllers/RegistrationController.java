package ie.murph.sports.clinic.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.murph.sports.clinic.domain.Person;

@Controller
@RequestMapping("/person")
public class RegistrationController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	private static final String personRegisterUrl = "person/register";

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String allowAccessToRegisterPersonDetailsPage(Model model) 
    {
    	LOGGER.info("+registerForm()");
    	passPersonObjectToRegisterPage(model);
        return personRegisterUrl;
    }
    
    private void passPersonObjectToRegisterPage(Model model)
    {
    	 model.addAttribute("person", new Person());
    }

}
