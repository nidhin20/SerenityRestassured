package starter.status;

import static starter.WebServiceEndPoints.LOGIN;

import io.restassured.http.ContentType;
import model.Linkcard;
import model.UserSubscription;
import model.subscription;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Step;

public class SubscriptionSteps {

	@Shared
	UserLoginSteps userlogin;
	@Step("Subsciption saved to database")
	public void SubmitSubscription(subscription payload)
	{
		String authurl=LOGIN.getUrl()+"/api/Subscrption/Addsubscription";
		SerenityRest
		.given().header("Authorization", "Bearer "+userlogin.Jwttoken).contentType(ContentType.JSON).body(payload)
		.post(authurl);
	}
	
	@Step("Add subscription to user card")
	public void Addsubscriptiontousercard(UserSubscription payload)
	{
		String authurl=LOGIN.getUrl()+"/api/UserSubscrption/Addsubscription";
		SerenityRest
		.given().header("Authorization", "Bearer "+userlogin.Jwttoken).contentType(ContentType.JSON).body(payload)
		.post(authurl);
	}
}

