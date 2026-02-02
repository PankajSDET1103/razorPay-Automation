package CommonUtil;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.Logger;

public class LoggingFilters implements Filter {

    private static final Logger log=
            LoggerUtil.getLogger(LoggingFilters.class);


    @Override
    public Response filter(FilterableRequestSpecification requestSpecification,
                           FilterableResponseSpecification responseSpecification,
                           FilterContext context)
    {
        log.info("REQUEST METHOD : {}", requestSpecification.getMethod());
        log.info("REQUEST URL    : {}", requestSpecification.getURI());
        log.info("REQUEST HEADERS: {}", requestSpecification.getHeaders());


        Response response = context.next(requestSpecification,responseSpecification);
        log.info("RESPONSE STATUS  :  {}",response.getStatusCode());
        log.info("RESPONSE BODY  :  {}",response.getBody().asPrettyString());

        return response;
    }



}
