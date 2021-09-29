package ComplexRequestResponse;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtils.EndPoints;
import io.restassured.response.Response;
import junit.framework.Assert;

public class ValidateDynamicResponse {
	
	@Test
	public void validateDynamicResponse() {
		baseURI="http://localhost";
		port=8084;
		
		String expdata="MAT";
		
		Response resp = when()
		.get(EndPoints.getAllProjects);
		resp.then().log().all();
		
		
		
		List <String> projname=resp.jsonPath().get("projectName");
		
		for (String str : projname) 
		{
			System.out.println(str);
			if(str.equals(expdata))
			{
				System.out.println("ProjectName "+ str +" is validated successfully");
				break;
			}
			
		}
		resp.then().log().all();


		
		
	}

}
