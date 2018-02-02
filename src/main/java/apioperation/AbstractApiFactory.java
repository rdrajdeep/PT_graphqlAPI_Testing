package apioperation;


import apioperation.httpspecs.Specification;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AbstractApiFactory implements ApiFactories {

    String url="http://34.227.27.131/api/graphql/";

    @Override
    public Response post ( String json) {

        Response r;
        r = given ( )
                .request ( )
                .header("Content-Type","application/json")
                .spec ( Specification.setupRequestSpecBuilder ( ) )
                .body ( json )
                .post ( url );

        return r;
    }


    @Override
    public Response post ( String json, String token ) {
        Response r;
        Header header = new Header ( "authorization", "token " + token );
        r = given ( )
                .request ( )
                .cookie("sessionid",token)
              //  .header ( header )
                .spec ( Specification.setupRequestSpecBuilder ( ) )
                .body ( json )
                .post ( url );

        return r;
    }



}
