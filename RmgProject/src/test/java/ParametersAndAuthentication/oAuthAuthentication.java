package ParametersAndAuthentication;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class oAuthAuthentication {

	@Test
	public void oauthAuthentication() {
		//this entire api chaining is done on THE COOP application http://coop.apps.symfonycasts.com/
		
		//request 1
		Response resp=given()
		.formParam("client_id", "SDET20Project")
		.formParam("client_secret", "c24fb1f059b69a65321745e559597892")
		.formParam("grant_type","client_credentials")//here grant_type and client_credentials are from coop application http://coop.apps.symfonycasts.com/api
		.formParam("redirect_uri", "http://example.com")//  redirect_uri is your application that u have created in coop application
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(resp.asString());
		
		String token=resp.jsonPath().getString("access_token");//getting token and storing in variable
		System.out.println(token);
		//request 2-will take response from request 1 as type RESPONSE
		given()
		.auth()
		.oauth2(token)//passing already received token to request2 for oauth
		.pathParam("USER_ID","2285")//once you create project in the coop application u will get a USER_ID generated.
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")//{USER_ID} is given as Path Parameter within {}
		
		.then()
		.log().all();
		
		
	}
}
