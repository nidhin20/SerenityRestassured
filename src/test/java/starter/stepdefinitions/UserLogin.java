package starter.stepdefinitions;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.UserSignInDto;
import model.UserSignup;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Steps;

import starter.status.UserLoginSteps;
import static org.hamcrest.Matchers.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class UserLogin {
	@Shared
    UserLoginSteps theApplication;
	UserSignInDto user;
	UserSignup Loaduser;
	
	@Given("user loggedin")
	public void CheckUserLoginStatus() {
		theApplication.Loggedinuser();
	}

	@Given("with {string} and {string}")
    public void Loginuser(String username,String password) {
    	 user = new UserSignInDto(username,password);
    	
    }
	
	@Given("login")
	 public void Logintheuser() {
		theApplication.Loginuser(user);
		theApplication.Loggedinuser();
   	
   }

    @When(": I click enter")
    public void Checkuserstatus() {
    	theApplication.Loginuser(user);
    }

    @Then(": user should be able to login successfully.")
    public void CheckUserLoginResponse() {
        restAssuredThat(lastResponse -> lastResponse.body("key", not(isEmptyString())));
    }
    @Then(": Response {int} , {string} , {string}")
    public void checkuserapiresponse(int statuscode, String elename, String message) {
        restAssuredThat(lastResponse -> lastResponse.assertThat()
        		.statusCode(statuscode).body(elename, containsString(message)));
    }
    
    @When(": Valid emailid: {string} , password: {string} ,name: {string} ,phonenumber: {string} , Date {string}")
    public void LoadUserForRegistration(String email,String password,String name, String phonenumber, String dob) {
    	SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
    	Date dobset = null;
		try {
			dobset = (Date) format.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Loaduser = new UserSignup(name,email,phonenumber,dobset,password);
    	
    }

    @When(": User click register button")
    public void RegistertheUser() {
    	theApplication.RegisterUser(Loaduser);
    }

    @Then("response should be {int} as status and {string} as message")
    public void CheckUserRegistration(int statuscode,String message) {
        restAssuredThat(lastResponse ->  lastResponse.statusCode(statuscode).body(containsString(message)));
    }
    
   
}
