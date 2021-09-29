package GenericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseApiClass {
	
	
	public DatabaseConnectionUtility dLib=new DatabaseConnectionUtility();
	public JavaUtility jLib=new JavaUtility();
	public RestAssuredUtils rLib=new RestAssuredUtils();
	@BeforeSuite
	public void bsConfig() throws Throwable {
		baseURI="http://localhost";
		port=8084;
		System.out.println("----------DB Connect-------");
		dLib.registerDriver();
		
	}
	@AfterSuite
	public void asConfig() throws Throwable {
		
		System.out.println("---------- DB Close Connection-------");
		dLib.dbClose();
	}

}
