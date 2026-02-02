package Api.Utils;

import CommonUtil.configManager;

import java.util.Base64;


public class AuthUtil {

    public static String EncodeUserCredential()
    {
        String KeyId = configManager.get("razorPayKeyId");
        String KeySecret= configManager.get("razorPayKeySecret");

        String auth = KeyId+":"+KeySecret;
         return Base64.getEncoder().encodeToString(auth.getBytes());
    }
}
