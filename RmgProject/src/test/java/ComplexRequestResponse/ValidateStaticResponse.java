package ComplexRequestResponse;

import org.testng.annotations.Test;

import GenericUtils.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class ValidateStaticResponse {
	@Test
	public void validateStaticResponse() {
		
		baseURI="http://localhost";
		port=8084;
		
		String expdata="TY_PROJ_004";
		
		Response resp = when()
		.get(EndPoints.getAllProjects);
		
		String actdata=resp.jsonPath().get("[1].projectId");
		System.out.println("Actual data: "+actdata);
		
		//assertion of test Ng to check exp and actual string value
		Assert.assertEquals(expdata, actdata);
		
		
			
	}

}
