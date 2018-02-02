package apioperation.httpspecs;

// Created by Rajdeep on 16 Jan 2018.

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utility.ConfigUtil;

public class Specification {


    public static RequestSpecBuilder builder;
    private static RequestSpecification requestSpec;

    public static RequestSpecification setupRequestSpecBuilder ( ) {

        builder = new RequestSpecBuilder ( );

        builder.setBaseUri ( ConfigUtil.getProperties("URL"));
        builder.setContentType ( ContentType.JSON );
        //builder.setContentType ( "application/json" );

        requestSpec = builder.build ( );

        return requestSpec;

    }


}
