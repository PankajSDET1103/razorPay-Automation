package Tests;

import Api.Payloads.CustomerPayload;
import Api.Services.CustomerService;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerApiTest {

    CustomerService customerService = new CustomerService();


    @Test(description = "Create ,Fetch and Edit customer Details")
    public void verifyCreateOrderFlow() {
/*
    Line 28-46 are Responsible for Creating new Customer
    And
    Fetching and Asserting the Customer creation

 */
        Response response = customerService.createOrder();
        response.then().statusCode(HttpStatus.SC_OK);
        String CustomerId = response.jsonPath().getString("id");

        Response FetchOrderResponse =
                customerService.FetchOrders(CustomerId);

        JsonPath createJson = response.jsonPath();

        String Name = createJson.getString("name");
        String Email = createJson.getString("email");
        String Contact =createJson.getString("contact");

        Assert.assertEquals(
                FetchOrderResponse.jsonPath().getString("name")
                , CustomerPayload.CustomerName);

        Assert.assertEquals(FetchOrderResponse.jsonPath().getString("email"),
                CustomerPayload.CustomerEmail);
/*
        Line 48-54 are Responsible for Modify the customer Details
 */
        Response EditCustomerDetailResponse = customerService.EditOrder(CustomerId);

        JsonPath EditDetailJson = EditCustomerDetailResponse.jsonPath();

        String EditCustomerName = EditDetailJson.getString("name");
        String EditCustomerEmail = EditDetailJson.getString("email");
        String EditCustomerContact = EditDetailJson.getString("contact");
/*
Assertion on before and after values of Customer Details
 */
        Assert.assertNotEquals(Name, EditCustomerName);
        Assert.assertNotEquals(Email, EditCustomerEmail);
        Assert.assertNotEquals(Contact, EditCustomerContact);


    }
}
