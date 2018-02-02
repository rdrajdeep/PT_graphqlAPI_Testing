package runner;

import apioperation.AbstractApiFactory;
import apioperation.apiresponse.ApiResponse;
import apioperation.apiresponse.ParseResponse;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.ConfigUtil;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;


//import java.util.logging.Logger;

public class TestRunner  extends AbstractApiFactory{

    private Logger logger = Logger.getLogger(TestRunner.class);
    private ConfigUtil util= new ConfigUtil();
    private ApiResponse response= ApiResponse.getObject();
    private ParseResponse jsonResponse = new ParseResponse(response);

    @BeforeClass
    public void configuration(){

      util.configureLogger();


    }


    @Test
    public void LogingTestCases(){



       /* RestAssured.baseURI = "http://34.227.27.131/api/graphql/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("http://34.227.27.131/api/graphql/");

        // Reader header of a give name. In this line we will get
        // Header named Content-Type
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);

        // Reader header of a give name. In this line we will get
        // Header named Server
        String cookies =  response.header("Set-Cookie: sessionid");
        System.out.println("Cookies:@@@@== " + cookies);

        // Reader header of a give name. In this line we will get
        // Header named Content-Encoding
        String acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content-Encoding: " + acceptLanguage);

*/

    }

    /*@Test
    public void loggerTest(){
        logger.info("This test is for logger method name check");
    }*/

     /* public static  void main(String[]for Hypertext Transfer Protocol daemon (i. args){

          Logger logger = Logger.getLogger(TestRunner.class);
          logger.warn("log in failure");
          logger.warn("log in failure");

          *//*configBrowser.getInstance().initiateBrowser();
            TestRunner run= new TestRunner();

            WebDriver driver = configBrowser.getInstance().getDriver();
            driver.get("http://34.227.27.131");

              String loginWindow= "http://34.227.27.131/embed/menu";
              run.login();

              String currentwindow= driver.getCurrentUrl();

              if (!currentwindow.equals(loginWindow)){
                  logger.info("Logged in successfully");
              }else{
                  logger.warn("log in failure");
              }
*//*

    *//*      logger.debug("this is a debug log message");
          logger.info("this is a information log message");
          logger.warn("this is a warning log message");*//*

    }*/

}
