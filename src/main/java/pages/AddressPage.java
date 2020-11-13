package pages;

import base.Base;
import org.openqa.selenium.By;
import utilities.Configuration;
import java.util.Properties;
import static utilities.Configuration.*;

public class AddressPage extends Base {
    Configuration configuration = new Configuration();
    private By quantity = By.xpath("//td[contains(text(),'Midtrans Pillow')]//following::input[1]");
    private By name = By.xpath("//td[contains(text(),'Name')]//following::input[1]");
    private By email = By .xpath("//td[contains(text(),'Email')]//following::input[1]");
    private By phoneNumber = By .xpath("//td[contains(text(),'Phone no')]//following::input[1]");
    private By city = By.xpath("//td[contains(text(),'City')]//following::input[1]");
    private By address = By .xpath("//td[contains(text(),'Address')]//following::input[1]");
    private By postalCode = By .xpath("//td[contains(text(),'Postal Code')]//following::input[1]");
    private By checkout = By .xpath("//div[contains(@class, 'cart-checkout') and (text() = 'CHECKOUT')]");

    /****************************************
     * Method To Add adress information ---- Usually we do it through Excel Test Data But just for Demo , passing from properties file
     *****************************************/
    public void addAddressData(String productName){
        prop = new Properties();
        getDriver().findElement(By.xpath("//td[contains(text(),'"+productName+"')]//following::input[1]")).clear();
        getDriver().findElement(quantity).sendKeys(configuration.getProperty(QUANTITIES));
        getDriver().findElement(name).clear();
        getDriver().findElement(name).sendKeys(configuration.getProperty(CUSTOMERNNAME));
        getDriver().findElement(email).clear();
        getDriver().findElement(email).sendKeys(configuration.getProperty(EMAIL));
        getDriver().findElement(phoneNumber).clear();
        getDriver().findElement(phoneNumber).sendKeys(configuration.getProperty(PHONENUMBER));
        getDriver().findElement(city).clear();
        getDriver().findElement(city).sendKeys(configuration.getProperty(CUSTOMERCITY));
        getDriver().findElement(address).clear();
        getDriver().findElement(address).sendKeys(configuration.getProperty(CUSADDRESS));
        getDriver().findElement(postalCode).clear();
        getDriver().findElement(postalCode).sendKeys(configuration.getProperty(POSTALCODE));
    }


    public void clickCheckout(){
        getDriver().findElement(checkout).click();
        System.out.println("Customer Address is added successfully ");
    }
}
