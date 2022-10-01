package RestAssuredProject.RestAssuredapi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Datadriventesting {
	@Test(dataProvider="dataprovider")
	void postEmployee(String ename,String esal ) {
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpRequest=RestAssured.given();
		JSONObject  reqParams=new JSONObject();
		reqParams.put("name", ename);
		reqParams.put("job", esal);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(reqParams.toJSONString());
		Response response=httpRequest.request(Method.POST,"/");
		String body = response.getBody().asString();
		System.out.println("Response body is:"+body);
		Assert.assertEquals(body.contains(ename),true);
		Assert.assertEquals(body.contains(esal),true);
		int s = response.getStatusCode();
		Assert.assertEquals(s,201);
		
		
	}
	@DataProvider(name="dataprovider")
	String[][] data() {
	
		String data[][]= {{"ab","100"},{"rp","200"}};
		return (data);
	}

}
