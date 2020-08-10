package starter.status;


import static starter.WebServiceEndPoints.LOGIN;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Authreponse;
import model.UserSignInDto;
import model.UserSignup;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
public class UserLoginSteps {

	public Response Loggeedinuser;
	public Integer userid;
	public String Jwttoken;
	@Step("Login the user")
    public void Loginuser(UserSignInDto user) {
		String authurl=LOGIN.getUrl()+"/authenticate";
		Loggeedinuser=SerenityRest
				.given().contentType(ContentType.JSON).body(user)
				.post(authurl);
				
		}
	@Step("Sign up the user")
    public void RegisterUser(UserSignup user) {
		String authurl=LOGIN.getUrl()+"/api/user/signup";
		SerenityRest
				.given().contentType(ContentType.JSON).body(user)
				.post(authurl);
				
		}
	@Step("Check user logged in status")
    public void Loggedinuser() {
		if( Jwttoken == null) {
			Jwttoken=Loggeedinuser.then().extract().body().as(Authreponse.class).getKey();
		}
			userid=extractClaims(Jwttoken);
			assertThat(Jwttoken,not(isEmptyString()));		
		}

	public Integer extractClaims(String token) {
		final Claims claims = extractAllClaims(token);
		return (Integer) claims.get("userid");
	}
	public Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey("onthego").parseClaimsJws(token).getBody();
	}
}
