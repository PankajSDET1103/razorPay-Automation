package Api.Utils;

import java.util.Random;
import java.util.UUID;

public class RandomDataUtil {

    private static final Random random = new Random();

    public static String randomName() {
        return "User_" + UUID.randomUUID().toString().substring(0, 6);
    }

    public static String randomEmail() {
        return "user" + UUID.randomUUID().toString().substring(0, 6)
                + "@test.com";
    }

    public static String randomContact() {
        return "9" + (100000000 + random.nextInt(900000000));
    }

}