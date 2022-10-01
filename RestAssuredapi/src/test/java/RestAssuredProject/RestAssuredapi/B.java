package RestAssuredProject.RestAssuredapi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class B {
	@Test
	void weatherdetails() {
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpRequest=RestAssured.given();
		JSONObject  reqParams=new JSONObject();
		reqParams.put("name", "morpheus");
		reqParams.put("job", "leader");
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(reqParams.toJSONString());
		Response response=httpRequest.request(Method.POST,"/");
		String body = response.getBody().asString();
		System.out.println("Body is :"+body);
		int s = response.getStatusCode();
		System.out.println(s);
		Assert.assertEquals(s, 201);
		String sucesscode = response.jsonPath().get("SuccessCode");
		System.out.println("successcode");
		
	}
}


