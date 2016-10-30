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
	private static final String urlUnsuccessfulLogin = "exceptions/login-unsuccessful";
	private static Person person;
	
	@Autowired
	private LoginService loginService;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String allowAccessToLoginPage(Model model) 
    {
    	LOGGER.info("+allowAccessToLoginPage()");
    	passPersonObjectToLoginPage(model);
        return urlPersonLogin;
    }
    
    private void passPersonObjectToLoginPage(Model model)
    {
    	 model.addAttribute("person", new Person());
    }
    
    //Where to go after the login success page
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String submitLoginUsernameAndPassword(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "password", required = false) String password, Model model) 
    {
    	LOGGER.info("+submitLoginUsernameAndPassword()");
    	person = loginService.doesPersonExist(username, password);
    	saveUsersPersonalDetailsForHomePage(model, person);
        return url();
    }
    
    private void saveUsersPersonalDetailsForHomePage(Model model, Person person)
    {
    	 model.addAttribute("person", person);
    }
    
    private String url()
    {
    	String url = "";
    	if(pesonIsNull())
    	{
    		url = urlUnsuccessfulLogin;
    	}
    	else
    	{
    		url = urlPersonHome;
    	}
    	return url;
    }
    
    private boolean pesonIsNull()
    {
    	return person == null;
    }
    
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String homePage(Model model) 
    {
    	LOGGER.info("+homePage()");
        model.addAttribute("person", new Person());
        return urlPersonHome;
    }

}
