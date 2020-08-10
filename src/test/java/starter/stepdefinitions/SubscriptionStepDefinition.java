package starter.stepdefinitions;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import model.UserSubscription;
import model.subscription;
import net.thucydides.core.annotations.Shared;
import starter.status.SubscriptionSteps;
import starter.status.UserLoginSteps;

public class SubscriptionStepDefinition {
	@Shared
	UserLoginSteps userLogin;
	
	subscription sub;
	
	String cardnumber;
	
	UserSubscription usersub;
	@Shared
	SubscriptionSteps substeps;
	@Given("Add subscribtion with plan name {string} , car category {string} , default plan : {int} ,Subciption period {int} , discount rate {int}")
	public void Addnewsubscription(String Plan_Nm, String Card_Category, Integer Default_plan,Integer Sub_Period,Integer Discount_rate) {
		boolean isplandefault=false;
		if(Default_plan!=0) {
			isplandefault=true;
		}
		float rate=(float)Discount_rate;
		sub=new subscription(0,Plan_Nm,Card_Category,isplandefault,Sub_Period,rate);
		
	}
	@Given("Modify subscribtion of plan id {int} , plan name {string} , car category {string} , default plan : {int} ,Subciption period {int} , discount rate {int}")
	public void Modifysubscription(int Planid,String Plan_Nm, String Card_Category, boolean Default_plan,int Sub_Period,float Discount_rate) {
		sub=new subscription(Planid,Plan_Nm,Card_Category,Default_plan,Sub_Period,Discount_rate);
	}
	@Given("Add plan id {int} for card {string} , payment ref no {string}")
	public void Modifysubscription(int Planid, String card, String payref) {
		usersub= new UserSubscription(Planid,card,payref);
	}
	@Given("user submit the subscription")
	public void subscriptionsubmit() {
		substeps.SubmitSubscription(sub);
	}
	@When("user add subscribtion to card")
	public void user_add_subscribtion_to_card() {
	   substeps.Addsubscriptiontousercard(usersub);
	}
}
