package Api.Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.InputStream;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static ObjectNode readJson(String path) {
        try {
            InputStream is = JsonUtil.class
                    .getClassLoader()
                    .getResourceAsStream(path);

            if (is == null) {
                throw new RuntimeException("JSON file not found: " + path);
            }

            JsonNode node = mapper.readTree(is);
            return (ObjectNode) node;

        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }
}
