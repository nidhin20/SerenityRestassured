package starter.stepdefinitions;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static starter.WebServiceEndPoints.LOGIN;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.restassured.http.ContentType;
import model.Authreponse;
import model.UserSignInDto;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Steps;
import starter.status.CardSteps;
import starter.status.UserLoginSteps;
import static org.hamcrest.Matchers.*;
public class CardStepDefinitions {
	UserSignInDto user;
	String cardno;
	String BearerToken;
	@Shared
	CardSteps cardstep;
	
	@Shared
	UserLoginSteps userLogin;
	@Given("user login with {string} as username , {string} as password")
	public void Authenticateuser(String username, String password) {
		Claims claim=Jwts.parser().parseClaimsJws(userLogin.Jwttoken).getBody();
		assertThat(BearerToken,not(isEmptyString()));
		cardstep.actor=username;
	}
	@Given("card {string}")
    public void Loadcard(String cardnumber) {
		cardno=cardnumber;
		
		assertThat(cardno, not(isEmptyString()));
    }

    @When("user adds card to the his account")
    public void Submitlinkcard() {
    	cardstep.AddCardtoUserAccount(cardno);
    	
    }
    @When("user delink card from his account")
    public void Delinkthecard() {
    	cardstep.DelinkCard(cardno);
    	
    }
    @When("user want to see his linked cards")
    public void GetListofLinkedcards() {
    	cardstep.GetLinkedCards();
    	
    }
  
}
