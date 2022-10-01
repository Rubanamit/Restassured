package RestAssuredProject.RestAssuredapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class C {
  
	@Test
	void weatherdetails() {
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"?page=2");
		String body = response.getBody().asString();
		System.out.println("Body is :"+body);
		Headers headers = response.headers();
		for(Header h:headers) {
			System.out.println(h.getName());
			System.out.println(h.getValue());
		}
		//Assert.assertEquals(body.contains("30"), false);
		
}
}
