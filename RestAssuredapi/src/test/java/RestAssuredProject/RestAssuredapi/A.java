package RestAssuredProject.RestAssuredapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class A {
	@Test
	void weatherdetails() {
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"?page=2");
		String body = response.getBody().asString();
		System.out.println("Body is :"+body);
		int s = response.getStatusCode();
		System.out.println(s);
		Assert.assertEquals(s,200 );
		String sl = response.getStatusLine();
		System.out.println(sl);
	}

}