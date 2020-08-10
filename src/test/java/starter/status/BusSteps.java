package starter.status;

import static starter.WebServiceEndPoints.LOGIN;

import io.restassured.http.ContentType;
import model.BusType;
import model.ServiceProvider;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Step;
import starter.stepdefinitions.UserLogin;

public class BusSteps {

	@Shared
	UserLoginSteps userlogin;
	@Step("Board user to bus")
	public void BoardUsertoBus(int Busserviceid,int busstopid, String card)
	{
		String authurl=LOGIN.getUrl()+"/api/bus/Tapin/"+Busserviceid+"/"+busstopid+"/"+ card;
		SerenityRest
		.given().header("Authorization", "Bearer " + userlogin.Jwttoken).contentType(ContentType.JSON)
		.post(authurl);
	}
	@Step("Alight user from bus")
	public void AlightUsertoBus(int Busserviceid,int busstopid, String card)
	{
		String authurl=LOGIN.getUrl()+"/api/bus/Tapout/"+Busserviceid+"/"+busstopid+"/"+ card;
		SerenityRest
		.given().header("Authorization", "Bearer " + userlogin.Jwttoken).contentType(ContentType.JSON)
		.post(authurl);
	}
	@Step("Create new Bus service")
	public void CreateBusservice(ServiceProvider serviceProvider)
	{
		String authurl=LOGIN.getUrl()+"/api/bus/CreatebusserviceProvider";
		SerenityRest
		.given().header("Authorization", "Bearer " + userlogin.Jwttoken).contentType(ContentType.JSON).body(serviceProvider)
		.post(authurl);
	}
	@Step("Create new Bus Type")
	public void CreateBusType(BusType busType)
	{
		String authurl=LOGIN.getUrl()+"/api/bus/Createbustype";
		SerenityRest
		.given().header("Authorization", "Bearer " + userlogin.Jwttoken).contentType(ContentType.JSON).body(busType)
		.post(authurl);
	}
}
