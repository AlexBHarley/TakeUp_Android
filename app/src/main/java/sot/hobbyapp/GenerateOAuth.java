package sot.hobbyapp;

/**
 * Created by David on 08-08-2015.
 */
public class GenerateOAuth {
    private static String consumerKey = "CE371CEC569880E6413594C1E27B6ADA";
    private static String consumerSecret = "38F2375F4D3324E9AFAE548603341F26";

    public static String generateAuthorization() {
        String s = "Authorization: OAuth oauth_consumer_key=\"" + consumerKey +"\"";
        s += ", oauth_signature_method=\"PLAINTEXT\"";
        s += ", oauth_signature=\"" + consumerSecret + "\"&";
        return s;
    }
}
