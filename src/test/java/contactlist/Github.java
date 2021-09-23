package contactlist;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Github {
  @Test(description="get all repository for Authentic user")
  public void getAllrepository() {
	  given()
	      .auth()
	      .oauth2("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")
	  .when()
	       .get("https://api.github.com/user/repos")
         .then()
	      .log()
	      .body()
	      .statusCode(200);
	  
  }
  @Test(description="get all repository for Authentic user")
  public void createRepository()
  {
	  JSONObject para=new JSONObject();
	  para.put("name","RestAssuredToolyashu");
	  para.put("description","Sample for Post Request");
	  para.put("homepage", "https://github.com/YashwanthReddy45");
	  given()
	        .auth()
	        .oauth2("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")
	        .header("Content-Type","application/json")
	        .body(para.toJSONString())
	 .when()
	     .post("https://api.github.com/user/repos")
	  .then()
	     .log()
	     .body()
	     .statusCode(201);
  }
  
}
