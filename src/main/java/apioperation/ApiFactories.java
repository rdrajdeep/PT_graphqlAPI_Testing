package apioperation;



import io.restassured.response.Response;

public interface ApiFactories {

    Response post(String json);
    Response post(String json, String token);


}
