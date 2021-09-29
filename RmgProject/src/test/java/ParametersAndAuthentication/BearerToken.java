package ParametersAndAuthentication;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {
	
	@Test
	public void bearerTokern() {
		
		HashMap map=new HashMap();
		map.put("name","MyReposiotory");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		
		.when()
		.post("https://api.github.com/user/repos")
		
		.then()
		.log().all();
	}

}
