package starter.status;

import static starter.WebServiceEndPoints.LOGIN;

import io.restassured.http.ContentType;
import model.Linkcard;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Step;

public class CardSteps {

	public String actor;
	
	@Shared
	UserLoginSteps userlogin;
	@Step("Add card to the user account")
	public void AddCardtoUserAccount(String card)
	{
		Linkcard payload=new Linkcard(userlogin.userid,card);
		String authurl=LOGIN.getUrl()+"/api/card/Linkcard";
		SerenityRest
		.given().header("Authorization", "Bearer "+userlogin.Jwttoken).contentType(ContentType.JSON).body(payload)
		.post(authurl);
	}
	
	@Step("DeLink the card from user")
	public void DelinkCard(String card)
	{
		String authurl=LOGIN.getUrl()+"/api/card/DeLinkcard/"+ card;
		SerenityRest
		.given().header("Authorization", "Bearer " + userlogin.Jwttoken).contentType(ContentType.JSON)
		.post(authurl);
	}
	
	@Step("Get list of Linked card for user")
	public void GetLinkedCards()
	{
		String authurl=LOGIN.getUrl()+"/api/card/GetLinkcards/"+ userlogin.userid;
		SerenityRest
		.given().header("Authorization", "Bearer " + userlogin.Jwttoken).contentType(ContentType.JSON)
		.get(authurl);
	}
}
