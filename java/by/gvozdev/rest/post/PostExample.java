/**
 * 
 */
package by.gvozdev.rest.post;

import java.util.Date;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author Gvozdev Alexsander Apr 26, 2018
 */
public class PostExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String randomNameEmail = String.format("%1$TH%1$TM%1$TS", new Date());

		JSONObject requestBody = new JSONObject();
		requestBody.put("FirstName", randomNameEmail);
		requestBody.put("LastName", randomNameEmail);
		requestBody.put("UserName", randomNameEmail);
		requestBody.put("Password", randomNameEmail);
		requestBody.put("Email", randomNameEmail + "@gmail.com");

		//RequestSpecification request = RestAssured.given();
		//request.header("Content-Type", "application/json");
		//request.body(requestBody.toString());
		//Response response = request.post("http://restapi.demoqa.com/customer/register");

		System.out.println(requestBody);

	}

}
