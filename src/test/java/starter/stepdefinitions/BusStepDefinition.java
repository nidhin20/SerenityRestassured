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
import model.BusType;
import model.ServiceProvider;
import model.UserSignInDto;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Steps;
import starter.status.BusSteps;
import starter.status.CardSteps;
import starter.status.UserLoginSteps;
import static org.hamcrest.Matchers.*;
public class BusStepDefinition {
	@Shared
	UserLoginSteps userLogin;
	public int busserviceid;
	public int busStopid;
	public String cardnumber;
	ServiceProvider service;
	@Shared
	BusSteps busSteps;
	
	BusType busType;
	
	@Given("bus service name {string}")
	public void LoadnewBusserviceprovider(String servicename) {
		service=new ServiceProvider(servicename);
	}
	@When("Create new bus service")
	public void CreateBusserviceprovider() {
		busSteps.CreateBusservice(service);
	}
	@Given("user boards in bus with service id {int} from stop id {int} with card {string}")
	 public void LoadBusservice(int Busserviceid,int Stopid, String cardno) {
		busserviceid= Busserviceid;
		busStopid=Stopid;
		cardnumber=cardno;
   	
   }
	@When("user tap the card to board")
	public void Boardusertobus() {
		busSteps.BoardUsertoBus(busserviceid, busStopid, cardnumber);
	}
	@When("user tap the card to alight")
	public void Alightuserfrombus() {
		busSteps.AlightUsertoBus(busserviceid, busStopid, cardnumber);
	}
	@Given("bus type name {string} , seating capacity: {int} , standing capacity: {int}")
	public void Loadbustype(String Busname, int seatno, int standno) {
		busType=new BusType(Busname,seatno,standno);
	}
	@Given("Create new bus type")
	public void Createnewbustype() {
		busSteps.CreateBusType(busType);
	}
}
