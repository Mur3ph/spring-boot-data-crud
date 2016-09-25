package ie.murph.sports.clinic.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ie.murph.sports.clinic.domain.Person;
import ie.murph.sports.clinic.repository.PersonRepository;

@Controller
@RequestMapping("/person")
public class PersonController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
    private PersonRepository repository;

	//Allows access to the Login page
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String loginForm(Model model) 
    {
    	LOGGER.info("+login()");
        model.addAttribute("person", new Person());
        return "person/login";
    }
    
    //Where to go after the login success page
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginSubmit(@RequestParam(value = "username", required = false) String username, Model model) 
    {
    	LOGGER.info("+login()");
    	Person person = repository.findOneByUsername(username);
        model.addAttribute("person", person);
        return "person/home";
    }

}
