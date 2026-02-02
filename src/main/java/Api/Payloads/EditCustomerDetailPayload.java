package Api.Payloads;

import Api.Utils.JsonUtil;
import Api.Utils.RandomDataUtil;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EditCustomerDetailPayload {

    public static String EditCustomerName = RandomDataUtil.randomName();
    public static String EditCustomerEmail = RandomDataUtil.randomEmail();
    public static String EditCustomerContact = RandomDataUtil.randomContact();

    private static final String EditCustomerPayload ="testData/EditCustomerPayload.json";


    public static ObjectNode EditCustomer()
    {
        ObjectNode objectNode = JsonUtil.readJson(EditCustomerPayload);

        objectNode.put("name",EditCustomerName);
        objectNode.put("email",EditCustomerEmail);
        objectNode.put("contact",EditCustomerContact);

        return objectNode;
    }
}
