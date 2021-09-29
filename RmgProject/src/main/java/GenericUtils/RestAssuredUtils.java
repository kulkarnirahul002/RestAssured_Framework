package GenericUtils;

import io.restassured.response.Response.*;

import io.restassured.response.Response;

public class RestAssuredUtils {
	/**
	 * Below method used for returning json Path
	 * @param resp
	 * @param value
	 * @return
	 */
	public  String getjsonpath(Response resp,String value) {
		
		String data=resp.jsonPath().get(value);
		return data;
		
	}

}
