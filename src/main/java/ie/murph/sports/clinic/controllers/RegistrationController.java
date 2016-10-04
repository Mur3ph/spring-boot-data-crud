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

	//Allows access to the Registration page
    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String registerForm(Model model) 
    {
    	LOGGER.info("+registerForm()");
        model.addAttribute("person", new Person());
        return "person/register";
    }

}
