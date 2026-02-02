package Api.Builders;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilderUtil {


    public static ResponseSpecification SuccessResponse()
    {
        return  new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType("application/json")
                .build();
    }

    public static ResponseSpecification errorResponse(int StatusCode)
    {
        return new ResponseSpecBuilder().expectStatusCode(StatusCode)
                .expectContentType("application/json").build();

    }
}
