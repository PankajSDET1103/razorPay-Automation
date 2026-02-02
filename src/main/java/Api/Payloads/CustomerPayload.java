package Api.Payloads;

import Api.Utils.JsonUtil;
import Api.Utils.RandomDataUtil;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CustomerPayload {

    public static String CustomerName= RandomDataUtil.randomName();
    public static String CustomerEmail = RandomDataUtil.randomEmail();
    public static String CustomerContact = RandomDataUtil.randomContact();


    private static final String CUSTOMER_PAYLOAD_PATH = "testData/CreateCustomerPayload.json";

    public static ObjectNode createCustomer() {

        ObjectNode payload = JsonUtil.readJson(CUSTOMER_PAYLOAD_PATH);


        payload.put("name", CustomerName);
        payload.put("email", CustomerEmail);
        payload.put("contact", CustomerContact);

        return payload;

    }

}
