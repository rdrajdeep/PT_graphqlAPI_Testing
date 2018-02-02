import apioperation.apiresponse.ApiResponse;
import apioperation.apiresponse.ParseResponse;
import apioperation.apiresponse.ResponseDataType;
import businessLogic.SignupAndLogin;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.ConfigUtil;

public class TestCases {

    ApiResponse response= ApiResponse.getObject();
    ParseResponse jsonResponse= new ParseResponse(response);

    Logger logger = Logger.getLogger(SignupAndLogin.class);

    SignupAndLogin signupAndLogin= new SignupAndLogin();

    private ConfigUtil util= new ConfigUtil();

    @BeforeClass
    public void configuration(){

        util.configureLogger();

    }

    @Test(priority = 1,description = "This is Login module")
    public  void login(){

        logger.info("Login module");
        signupAndLogin.loginUser("rajdeep","rajdeep123");

        String error=jsonResponse.getJsonData("errors.message", ResponseDataType.STRING);

        System.out.println(  response.getResponse().prettyPrint());


        try {

            JSONObject jsonObject = new JSONObject(String.format(response.getResponse().asString()));

           if (jsonObject.has("errors")){

                System.out.println("checked");

           }else{

                System.out.println("failed");

            }

        } catch (JSONException ex) {
            ex.printStackTrace();
        }



        /*if (!error.equalsIgnoreCase(null)){
            System.out.println("login failed due to: "+error);
            System.out.println(response.getResponse().prettyPrint());
        }
        */




        //   signupAndLogin.logoutUser();

    }

    @Test(priority = 2,description = "This is Signup module")
    public void rateCard(){
        logger.info("Module Logout");
        signupAndLogin.rateCard();
    }

}
