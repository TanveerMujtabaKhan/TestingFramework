package utilities;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Configuration {

    private static PropertiesConfiguration configuration;

    public static String MidtranURL = "midtransurl";
    public static String EXECUTIONPLATFORM =  "executionplatform";
    public static String QUANTITIES =  "quantity";
    public static String CUSTOMERNNAME =  "customerName";
    public static String EMAIL =  "email";
    public static String PHONENUMBER =  "phoneNumber";
    public static String CUSTOMERCITY =  "customerCity";
    public static String CUSADDRESS =  "cusAddress";
    public static String POSTALCODE =  "postalCode";
    public static String EXPIRYDATE ="expiryDate";
    public static String CVV ="CVV";
    public static String OTP="otp";



    static
    {
        try {
            configuration = new PropertiesConfiguration("src/main/java/configurations/config.properties");
        } catch (ConfigurationException e)
        {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return configuration.getString(key);

    }

}