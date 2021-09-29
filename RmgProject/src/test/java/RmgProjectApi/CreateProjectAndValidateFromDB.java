package RmgProjectApi;

import org.testng.annotations.Test;

import GenericUtils.BaseApiClass;
import GenericUtils.EndPoints;
import PojoClass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
public class CreateProjectAndValidateFromDB extends BaseApiClass{

	@Test
	public void createProjectAndValidateFromDBTest() throws Throwable {
		ProjectLibrary pLib=new ProjectLibrary("Rahul", "Created", "ConCrew"+jLib.getRandomNumber(),20);
		
		Response resp=given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		.when()
		.post(EndPoints.addProject);
		
		String expdata=rLib.getjsonpath(resp, "projectId");
		System.out.println("Expected data:"+expdata);
		
		String query="select * from project;";
		String actData=dLib.executeQuery(query, 1, expdata);
		System.out.println("Actual Data from database:"+actData);
		
		Assert.assertEquals(actData, expdata);
		System.out.println("Data Verified succesfully");
		
				
		
	}
}
