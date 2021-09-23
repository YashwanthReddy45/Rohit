package contactlist;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class NewTest{
	String id;
 /* @Test(description="getting All Contact info")
  public void gettingAllContact(){
	  given()
	  .when()
	      .get("http://3.13.86.142:3000/contacts")
	  .then()
	       .log()
	       .body()
	       .statusCode(200);
  }*/
	@Test(enabled=true,description=" Add Specific Contact")       
  public void Addcontact() {
	  JSONObject data=new JSONObject();
	  JSONObject loc=new JSONObject();
	  JSONObject emp=new JSONObject();
	  loc.put("city", "Hyd");
	  loc.put("country", "Ind");
	  emp.put("jobTitle","HR");
	  emp.put("company","LTI");
	  data.put("firstName", "Yashu");
	  data.put("lastName","Reddy");
	  data.put("email","123@lnttech.com");
	  data.put("location",loc);
	  data.put("employer",emp);
	  
	        id = given()
			        .header("Content-Type","application/json")
			        .body(data.toJSONString())
			     .when()
			        .post("http://3.13.86.142:3000/contacts")
			     .then()
			        .log()
			        .body()
			        .statusCode(200)
			        .extract().path("_id");
	        System.out.println("Id is"+id);
  
			  
  }
	@Test(enabled=true,dependsOnMethods="Addcontact",description="Display")
  public void gettingspecificcont()
  {
	  given()
	  .when()
	      .get("http://3.13.86.142:3000/contacts/"+id)
	   .then()
	       .log()
	       .body()
	       .statusCode(200);
  }
	@Test(enabled=true,dependsOnMethods="gettingspecificc	ont",description="delete")
	public void deletecontact()
	{
		given()
		.when()
		   .delete("http://3.13.86.142:3000/contacts/"+id)
		 .then()
		   .log()
		   .body()
		   .statusCode(204);
		    
	}
	       
	  
  }


