package Api.Services;

import Api.Builders.RequestSpecBuilderUtil;
import Api.Builders.ResponseSpecBuilderUtil;
import Api.Constants.Endpoints;
import Api.Payloads.CustomerPayload;
import Api.Payloads.EditCustomerDetailPayload;
import io.qameta.allure.Step;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class CustomerService {
    @Step("Create new customer")
    public Response createOrder()
    {
        return given().spec(RequestSpecBuilderUtil.getRequestSpec())
                .body(CustomerPayload.createCustomer()).when()
                .post(Endpoints.CREATE_CUSTOMER)
                .then().spec(ResponseSpecBuilderUtil.SuccessResponse())
                .extract().response();

    }
    @Step("Fetch customer with id: {CustomerId}")
    public Response FetchOrders(String CustomerId)
    {
        return given().spec(RequestSpecBuilderUtil.getRequestSpec())
                .when().get(Endpoints.CREATE_CUSTOMER +"/"+CustomerId)
                .then().spec(ResponseSpecBuilderUtil.SuccessResponse())
                .extract().response();
    }

    @Step("Edit customer with id: {CustomerId}")
    public Response EditOrder(String CustomerId)
    {
        return given().spec(RequestSpecBuilderUtil.getRequestSpec())
                .when().body(EditCustomerDetailPayload.EditCustomer()).put(Endpoints.CREATE_CUSTOMER+"/"+CustomerId)
                .then().spec(ResponseSpecBuilderUtil.SuccessResponse())
                .extract().response();
    }
}
