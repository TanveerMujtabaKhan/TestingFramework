package dkatalis.Test_TanveerMujtabaKhan;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddressPage;
import pages.PaymentService;
import pages.ProductSummary;
import pages.Products;
import utilities.Configuration;

import static utilities.Configuration.PRODUCTNAME;

public class TC_02failedPurchaseFlow extends Base {
	Products products = new Products();
	AddressPage address = new AddressPage();
	ProductSummary summary = new ProductSummary();
	PaymentService payment = new PaymentService();
	Configuration configuration = new Configuration();

	@Test(description = "Failed Scennario : end to end checkout flow for purchasing “Pillow” using Credit Card as payment method")
	public void E2EFailedFlow() {

		products.BuyProduct(configuration.getProperty(PRODUCTNAME));
		address.addAddressData(configuration.getProperty(PRODUCTNAME));
		address.clickCheckout();
		summary.productContinue();
		payment.clickCreditCardOption();
		payment.enterCreditCardDetails("4911 1111 1111 1113");
		payment.creditPayClick();
		payment.providePassword();
		payment.clickSubmitOtp();
		String paymentconfirmation= payment.verifyPayment();
		if(paymentconfirmation.contains("failed")){

			System.out.println("Please check the payment detail and retry!!");
			Assert.assertTrue(true);
		}
		else if(paymentconfirmation.contains("successful")){

			System.out.println("Congratulation! you order is placed successfully");
			Assert.assertTrue(false);
		}
	}
}
