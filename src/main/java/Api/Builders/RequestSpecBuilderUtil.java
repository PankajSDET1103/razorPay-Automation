package Api.Builders;

import CommonUtil.configManager;
import Api.Utils.AuthUtil;
import CommonUtil.LoggingFilters;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderUtil {

    private RequestSpecBuilderUtil()
    {

    }
    public static RequestSpecification getRequestSpec()
    {
        return new RequestSpecBuilder().setBaseUri(configManager.get("base.url"))
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Basic "+ AuthUtil.EncodeUserCredential())
                .addFilter(new LoggingFilters()).build();
    }
}
