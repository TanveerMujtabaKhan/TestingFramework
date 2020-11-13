package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import base.Base;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Products extends Base {

    /****************************************
     * Method To Buy product with the input product name
     *****************************************/
    public void BuyProduct(String ProductName) {

        try {
            getDriver().findElement(By.xpath("//div[contains(@class, 'title') and (text() = '" + ProductName + "')]//following::a[contains(@class, 'btn buy') and (text() = 'BUY NOW')]")).click();
            System.out.println("Product "+ProductName+" is purchased and proceed to address page");
            Assert.assertTrue(true);

        }
        catch(Exception e){
            System.out.println("Failed !! Check product name");
            Assert.assertTrue(false);
        }
    }
}