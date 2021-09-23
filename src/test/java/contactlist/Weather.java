package contactlist;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Weather {
  @Test(enabled=true,description="Getting weather of a city")
  public void gettingweather() {
	  RestAssured.given()
	             .when()
	                 .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=981d0095475c811603828a5cfd5f9f2b")
	             .then()
	                 .log()
	                 .body()
	                 .statusCode(200);
  
	 }
  
  @Test(enabled=true,description="Getting weather of a city")
  public void gettingweather2() {
	  Response res=RestAssured.given()
	             .when()
	                 .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=981d0095475c811603828a5cfd5f9f2b");
System.out.println(res.prettyPrint());
System.out.println(res.getTime());
System.out.println(res.getStatusCode());
System.out.println(res.getContentType());

}
  @Test(enabled=true,description="Getting weather of a city")
  public void gettingweather3() {
                  RestAssured.given()
			           .queryParams("q","Pune")
			            .queryParams("appid","981d0095475c811603828a5cfd5f9f2b")
			  		
	             .when()
	                 .get("http://api.openweathermap.org/data/2.5/weather")
	             .then()
      .log()
      .body()
      .statusCode(200);
}
}
