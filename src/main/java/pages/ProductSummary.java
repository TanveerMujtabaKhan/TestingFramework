package pages;

import base.Base;
import org.openqa.selenium.By;

public class ProductSummary extends Base {
    private By continuebutton = By.xpath("//div[@id='application'] //a[@class='button-main-content']");

    public void productContinue(){
        getDriver().switchTo().frame("snap-midtrans");
        explicitWaitvisibility(continuebutton);
        getDriver().findElement(continuebutton).click();
        System.out.println("proceeded to select payment option");
    }

}