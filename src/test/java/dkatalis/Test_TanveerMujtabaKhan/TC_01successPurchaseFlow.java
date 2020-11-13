package dkatalis.Test_TanveerMujtabaKhan;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.Base;
import pages.AddressPage;
import pages.PaymentService;
import pages.ProductSummary;
import pages.Products;
import utilities.Configuration;
import static utilities.Configuration.PRODUCTNAME;

public class TC_01successPurchaseFlow extends Base {
    Products products = new Products();
    AddressPage address = new AddressPage();
    ProductSummary summary = new ProductSummary();
    PaymentService payment = new PaymentService();
    Configuration configuration = new Configuration();

    @Test(description = "Success Scennario : end to end checkout flow for purchasing “Pillow” using Credit Card as payment method")
    public void E2ESuccessFlow() {

        products.BuyProduct(configuration.getProperty(PRODUCTNAME));
        address.addAddressData(configuration.getProperty(PRODUCTNAME));
        address.clickCheckout();
        summary.productContinue();
        payment.clickCreditCardOption();
        payment.enterCreditCardDetails("4811 1111 1111 1114");
        payment.creditPayClick();
        payment.providePassword();
        payment.clickSubmitOtp();
        String paymentconfirmation= payment.verifyPayment();
        if(paymentconfirmation.contains("Failed")){

            System.out.println("Please check the payment detail and retry");
            Assert.assertTrue(false);

        }
        else if(paymentconfirmation.contains("successful")){
            System.out.println("Congratulation! you order is placed successfully");
            Assert.assertTrue(true);

        }
    }
}
