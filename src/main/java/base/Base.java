package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class Base {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public Properties prop;
    public String midtrans;
    public static WebDriverWait wait;
    public static PropertiesConfiguration configuration;

    public WebDriver getDriver() {

        return driver.get();
    }

    public WebDriver LaunchBrowserAndGetDomainUrl() {
        prop = new Properties();
        String path = System.getProperty("user.dir") + "//src//main//java//configurations//config.properties";

        FileInputStream fis;
        try {
            fis = new FileInputStream(path);
            prop.load(fis);
            String executionplatform = prop.getProperty("executionplatform");
            String browser = prop.getProperty("browser");
            char EXECUTIONPLATFORM = executionplatform.charAt(0);

                if(browser.contains("chrome")) {
                    ChromeOptions options = new ChromeOptions();
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(options));
                }
                else if (browser.contains("firefox")){
                    FirefoxOptions options = new FirefoxOptions();
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver(options));

                }
                getDriver().manage().window().maximize();
                getDriver().manage().deleteAllCookies();
                midtrans = prop.getProperty("Dkatalisurl");
                System.out.println(midtrans);
                getDriver().get(midtrans);


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return getDriver();
    }

    /****************************************
     * Method To Launch The Browser Before Each Test With @Before Test Annotation
     *****************************************/
    @BeforeClass
    public void launchBrowserAndSSO() throws IOException {

        // Launching The Browser
        LaunchBrowserAndGetDomainUrl();

        // Maximizing the Browser
        getDriver().manage().window().maximize();
    }



    /****************************************
     * Method To Delete The Cookies
     *****************************************/
    public void pageLoad(String url) {
        getDriver().manage().deleteAllCookies();

        getDriver().get(url);

    }

    /****************************************
     * Method To PageLoad Timeout
     *****************************************/

    public void waitstime(long pageload, TimeUnit seconds) {

        getDriver().manage().timeouts().pageLoadTimeout(pageload, TimeUnit.SECONDS);
    }


    /****************************************
     * Method To Wait For PageLoad if All Elements Present
     *****************************************/
    public WebDriver explicitwait(By elementBy) {
        wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        Wait wait1 = new FluentWait<WebDriver>(getDriver())
                .withTimeout(50, TimeUnit.SECONDS).pollingEvery(3,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);



        return getDriver();

    }

    /****************************************
     * Method To Wait For Thread
     *
     * @throws InterruptedException
     *****************************************/
    public void elementWait(long thread) {

        try {
            Thread.sleep(thread);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /****************************************
     * Method To Wait For PageLoad if All Elements Present
     *****************************************/
    public WebDriver explicitWaitInvisibility(By elementBy) {
        wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
        return getDriver();

    }


    /****************************************
     * Method To Wait For PageLoad if All Elements Present
     *****************************************/
    public WebDriver explicitWaitvisibility(By elementBy) {
        wait = new WebDriverWait(getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));

        return getDriver();

    }

    /****************************************
     * Method To Closing The Current Browser
     *****************************************/

    public void closeBrowser() {
        getDriver().close();
    }

    /****************************************
     * Method To Closing All Browser
     *****************************************/
    @AfterMethod
    public void closeAllBrowser() {

        getDriver().quit();

    }
}
