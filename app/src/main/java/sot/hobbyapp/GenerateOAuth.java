package sot.hobbyapp;

/**
 * Created by David on 08-08-2015.
 */
public class GenerateOAuth {
    private String consumerKey = "CE371CEC569880E6413594C1E27B6ADA";
    private String consumerSecret = "38F2375F4D3324E9AFAE548603341F26";
    private String oAuthToken = "0864CD4E398B9DF678DE3D8B9326634E";
    private String oAuthTokenSecret = "170FF87036717594B437DAB86009C710";

    private String oauth_callback = "http://www.website-tm-access.co.nz/trademe-callback";
    private String oauthVersion = "1.0";
    private int oauthTimestamp = 0; //the number of seconds since January 1, 1970, 0:00 GMT
    private String oauthNonce = "7O3kEe";
    private String oauth_signature_method="HMAC-SHA1";
    private String oauth_signature = "";

    public String generateOauthSignature() {
        return "hello";
    }
}
