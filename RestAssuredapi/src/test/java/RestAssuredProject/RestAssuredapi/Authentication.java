package RestAssuredProject.RestAssuredapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authentication {
	@Test
	void weatherdetails() {
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"?page=2");
		PreemptiveBasicAuthScheme pm=new PreemptiveBasicAuthScheme();
		pm.setUserName(null);
		pm.setPassword(null);
		RestAssured.authentication=pm;
		String body = response.getBody().asString();
		System.out.println("Body is :"+body);
		int s = response.getStatusCode();
		System.out.println(s);

}
}
