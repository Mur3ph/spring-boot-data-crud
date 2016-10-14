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

@Controller
@RequestMapping("/person")
public class LoginController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	private static final String urlPersonHome = "person/home";
	private static final String urlPersonLogin = "person/login";
	
	@Autowired
	private LoginService personService;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String allowAccessToLoginPage(Model model) 
    {
    	LOGGER.info("+allowAccessToLoginPage()");
    	saveUsersDetailsToSession(model, new Person());
        return urlPersonLogin;
    }
    
    //Where to go after the login success page
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String submitLoginUsernameAndPassword(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "password", required = false) String password, Model model) 
    {
    	LOGGER.info("+submitLoginUsernameAndPassword()");
    	Person person = personService.login(username, password);
    	saveUsersDetailsToSession(model, person);
        return url(person);
    }
    
    private String url(Person person)
    {
    	String url = "";
    	if(person.getUsername() == null)
    	{
    		url = "exceptions/login-unsuccessful";
    	}
    	else
    	{
    		url = urlPersonHome;
    	}
    	return url;
    }
    
    private void saveUsersDetailsToSession(Model model, Person person)
    {
    	 model.addAttribute("person", person);
    }
    
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String homePage(Model model) 
    {
    	LOGGER.info("+homePage()");
        model.addAttribute("person", new Person());
        return urlPersonHome;
    }

}
