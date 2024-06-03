package computer;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {
    String baseUrl ="https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByValueFromDropDown(By.id("products-orderby"), "6");
        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> beforeFilterProductNames = driver.findElements(By.cssSelector(".product-title"));
        List<String> beforeFilterProductNamesList = new ArrayList<>();
        for (WebElement p : beforeFilterProductNames) {
            beforeFilterProductNamesList.add(p.getText());
        }
        Collections.sort(beforeFilterProductNamesList);
        Collections.reverse(beforeFilterProductNamesList);
        selectByValueFromDropDown(By.id("products-orderby"), "6");
        Thread.sleep(2000);
        List<WebElement> afterFilterProductNames = getMultipleElements(By.className("product-title"));
        List<String> afterFilterProductNamesList = new ArrayList<>();
        for (WebElement s : afterFilterProductNames) {
            afterFilterProductNamesList.add(s.getText());
        }
        Assert.assertEquals("Products are not sorted in descending order", afterFilterProductNamesList, beforeFilterProductNamesList);
    }
        @Test
       public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
            //2.1 Click on Computer Menu.
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
            //2.2 Click on Desktop
            clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
            //2.3 Select Sort By position "Name: A to Z"
            selectByValueFromDropDown(By.id("products-orderby"),"5");
            //2.4 Click on "Add To Cart"
            Thread.sleep(2000);
            clickOnElement(By.xpath("//button[text()='Add to cart']"));
            //2.5 Verify the Text "Build your own computer"

            Assert.assertEquals("Build your own computer", getTextFromElement(By.xpath("//h1[text()='Build your own computer']")));
             //          2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
                 selectByValueFromDropDown(By.id("product_attribute_1"),"1");
             //            2.7.Select "8GB [+$60.00]" using Select class.//            2.8 Select HDD radio "400 GB [+$100.00]"
                    selectByValueFromDropDown(By.id("product_attribute_2"),"5");
                    clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
             //            2.9 Select OS radio "Vista Premium [+$60.00]"
            Thread.sleep(3000);
                    clickOnElement(By.id("product_attribute_4_9"));
            //            2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
                        clickOnElement(By.id("product_attribute_5_12"));
                        //2.11 Verify the price "$1,475.00"
            Thread.sleep(3000);
            Assert.assertEquals("$1,475.00",getTextFromElement(By.id("price-value-1")));
            //2.12 Click on "ADD TO CARD" Button.
            clickOnElement(By.id("add-to-cart-button-1"));
            //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
            Assert.assertEquals("The product has been added to your shopping cart",getTextFromElement(By.xpath("//p[text()='The product has been added to your ']")));
            //After that close the bar clicking on the cross button.
            clickOnElement(By.xpath("//span[@class='close']"));
            //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
            mouseHoverToElement(By.xpath("//span[text()='Shopping cart']"));
            Thread.sleep(3000);
            clickOnElement(By.xpath("//span[@class='cart-label']"));
            Thread.sleep(2000);
            //2.15 Verify the message "Shopping cart"
            Assert.assertEquals("Shopping cart",getTextFromElement(By.xpath("//span[@class='cart-label']")));
//            2.16 Change the Qty to "2" and Click on "Update shopping cart"
            clickOnElement(By.xpath("//div[@class='quantity up']"));
//            2.17 Verify the Total"$2,950.00"
            Assert.assertEquals("$2,950.00",getTextFromElement(By.xpath("//span[@class='value-summary']//strong[text()='$2,950.00']")));
//            2.18 click on checkbox “I agree with the terms of service”
            clickOnElement(By.id("termsofservice"));
//            2.19 Click on “CHECKOUT”
            clickOnElement(By.xpath("//button[@id='checkout']"));

//            2.20 Verify the Text “Welcome, Please Sign In!”
            Assert.assertEquals("Welcome, Please Sign In!",getTextFromElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")));
            Thread.sleep(2000);
            //2.21Click on “CHECKOUT AS GUEST” Tab
            clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));

            //2.22 Fill the all mandatory field
            sendTextToElement(By.id("BillingNewAddress_FirstName"),"Shubham");   //insert username
            sendTextToElement(By.id("BillingNewAddress_LastName"),"Lohar");         //insert lastname
            sendTextToElement(By.id("BillingNewAddress_Email"),"shubham123@gmail.com");    //insert random email id
            selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"),"233");   //select your country
            Thread.sleep(1000);
            sendTextToElement(By.id("BillingNewAddress_City"),"London");   //insert city name
            sendTextToElement(By.id("BillingNewAddress_Address1"),"123 Thronbridge Avenue");   //insert address
            sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"EL202QL");           //insert postcode
            sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"09828127782");     //enter user phone number
            Thread.sleep(2000);
            //2.23 Click on “CONTINUE”
            clickOnElement(By.xpath("//button[@class='button-1 new-address-next-step-button']"));

            //2.24 Click on Radio Button “Next Day Air($0.00)”
            clickOnElement(By.id("shippingoption_1"));
            //2.25 Click on “CONTINUE”
            clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
            Thread.sleep(3000);
            //2.26 Select Radio Button “Credit Card”
            clickOnElement(By.id("paymentmethod_1"));
            Thread.sleep(2000);
            //2.27 Select “Master card” From Select credit card dropdown
            clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
            //2.28 Fill all the details
            sendTextToElement(By.id("CardholderName"),"Shubham");
            sendTextToElement(By.id("CardNumber"),"5413330089010640");
            selectByValueFromDropDown(By.id("ExpireMonth"),"10");
            Thread.sleep(1000);
            selectByValueFromDropDown(By.id("ExpireYear"),"2028");
            sendTextToElement(By.id("CardCode"),"123");

            //2.29 Click on “CONTINUE”
            clickOnElement(By.xpath("(//button[@class='button-1 payment-info-next-step-button'])[1]"));
            //2.30 Verify “Payment Method” is “Credit Card”
            String actPaymentText = getTextFromElement(By.xpath("//span[normalize-space()='Payment Method:']")) + getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']"));
            Assert.assertEquals("Payment method not valid", "Payment Method:Credit Card", actPaymentText);
            String actualShippingText = getTextFromElement(By.xpath("//span[normalize-space()='Shipping Method:']")) + getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']"));
            //2.32 Verify “Shipping Method” is “Next Day Air”
            Assert.assertEquals("Shipping method not valid", "Shipping Method:Next Day Air", actualShippingText);
            clickOnElement(By.xpath("//button[text()='Confirm']"));
            //2.33 Verify Total is “$2,950.00”
            Assert.assertEquals("Thank you", getTextFromElement(By.xpath("//h1[text()='Thank you']")));
            //2.36 Verify the message “Your order has been successfully processed!”
            Assert.assertEquals("Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']")));
            //2.37 Click on “CONTINUE”
            clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
            //2.37 Verify the text “Welcome to our store”
            Assert.assertEquals("Welcome to our store", getTextFromElement(By.xpath("//h2[text()='Welcome to our store']")));

        }


    @After
    public void tearDown() {

    }

}
