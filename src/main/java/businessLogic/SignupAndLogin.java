package businessLogic;

import apioperation.AbstractApiFactory;
import apioperation.apiresponse.ApiResponse;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import utility.SessionManagement;


public class SignupAndLogin extends AbstractApiFactory{

     SessionManagement session= SessionManagement.getInstance();
     ApiResponse apiResponse= ApiResponse.getObject();

    public void loginUser(String username, String password) {

        Response response;
        String session_id=null;

        String query= "{\"query\":\"mutation login{\\n" +
                "loginUser(loginData: {username: "+"\\\""+username+"\\\""+", " +
                "password: "+"\\\""+password+"\\\""+"}) {\\n" +
                "  user {\\n" +
                "    username\\n" +
                "    firstName\\n" +
                "    lastName\\n" +
                "    userId\\n" +
                "    clientId\\n" +
                "  email\\n" +
                "    shareRateCards\\n" +
                "    freeTrial\\n" +
                "    termsOfAgreement\\n" +
                "  }\\n" +
                "}\\n" +
                "}\"}";

         apiResponse.setResponse(
                this.post(query)
        );

        Headers allHeaders = apiResponse.getResponse().headers();

        // Iterate over all the Headers
        for(Header header : allHeaders)
        {
            if (header.getValue().contains("sessionid")){
                session_id= header.getValue().substring(10,header.getValue().indexOf(";"));
                System.out.println(" SESSION ID: "+session_id);
            }
        }

        SessionManagement.getInstance().setSession(session_id);

        //System.out.println("Login response: "+apiResponse.getResponse().prettyPrint());


    }

    public void signUp(String json) {

    }

    public void logoutUser(){

        String query= "{ \"query\" : \"mutation logout{logoutUser{ok}}\"}";
        Response response= this.post(query);
        System.out.println("Logout Response: "+response.prettyPrint());
        SessionManagement.getInstance().setSession(null);

    }

    public void rateCard(){
        String query= String.format("{\"query\":\"query rateCard{\\n" +
                "  viewer{\\n" +
                "    allRateCards(filters:{nameIContains:\\\"Rate\\\"}){\\n" +
                "      edges{\\n" +
                "        node{\\n" +
                "          name\\n" +
                "        }\\n" +
                "      }\\n" +
                "    }\\n" +
                "  }\\n" +
                "}\"}");


        Response response= this.post(query,session.getSession());

        System.out.println("Rate Card Respons: "+response.prettyPrint());

    }


}
