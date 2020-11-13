package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Configuration;
import java.util.List;
import static utilities.Configuration.*;

public class PaymentService extends Base {

    private By creditCardLink = By.xpath("//div[@class='page-container scroll'] //a[@href='#/credit-card']");
    private By ccNumber = By.name("cardnumber");
    private By expiry_Date = By.xpath("//input[@placeholder='MM / YY']");
    private By cvv = By.xpath("//div[@class='input-group col-xs-5'] //input");
    private By payClick = By.xpath("//div[@id='application'] //a[@class='button-main-content']");
    private By password = By.name("PaRes");
    private By submitOtp = By.xpath("//button[@name='ok']");
    private By paymentconfirm = By.xpath("//div[@id='application'] //div[@class='card-container full']");
    private By errormessage = By.xpath("//div[@class='pop-wrapper has-close danger show'] //Span[@class='pop']");
    Configuration configuration = new Configuration();

    public void clickCreditCardOption(){
        explicitWaitvisibility(creditCardLink);
        getDriver().findElement(creditCardLink).click();
        System.out.println("Customer has choose credit/debit card as payment option");
    }

    public void enterCreditCardDetails(String creditCardNumber){
        getDriver().findElement(ccNumber).sendKeys(creditCardNumber);
        getDriver().findElement(expiry_Date).sendKeys(configuration.getProperty(EXPIRYDATE));
        getDriver().findElement(cvv).sendKeys(configuration.getProperty(CVV));

    }

    public boolean creditPayClick(){
        boolean ccflag = false;
        getDriver().findElement(payClick).click();
        elementWait(5000);
        List<WebElement> error = getDriver().findElements(errormessage);

        if(error.size()>0){
            String errormessage = error.get(0).getText();
            System.out.println(errormessage);
            ccflag = false;
            System.out.println("Customer has added credit Card details but seems credit card details needs a check");
            Assert.assertTrue(false);
        }
        else{
            ccflag = true;
            System.out.println("Customer has added credit Card details and proceed to Authentication page");
            Assert.assertTrue(true);
        }
        return ccflag;
    }

    public void providePassword(){
        elementWait(8000);
        getDriver().switchTo().frame(0);
        explicitWaitvisibility(password);
        getDriver().findElement(password).sendKeys(configuration.getProperty(OTP));
    }


    public void clickSubmitOtp(){
        getDriver().findElement(submitOtp).click();
        System.out.println("Authentication password is added , Moving to order confirmation page");

    }

    public String verifyPayment(){
        elementWait(3000);
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame("snap-midtrans");
        String paymentconfirmation = getDriver().findElement(paymentconfirm).getText();

        return paymentconfirmation;
    }
}
