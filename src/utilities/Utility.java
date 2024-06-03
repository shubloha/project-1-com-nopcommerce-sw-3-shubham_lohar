package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    /**
     * this method will click on element
     */

    public void clickOnElement(By by){
        driver.findElement(by).click();

    }
    /**
     * this method will click on elements  (for more than one elements )
     */
    public void clickOnElements(By by){
        driver.findElements(by);
    }



    /**
     *This method will get text from element
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();

    }


    /**
     * This method will send text to element

     */
    //multiple elements store in list of webelement
    public List<WebElement> getMultipleElements(By by) {
        return driver.findElements(by);
    }
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    //************************* Alert Methods *****************************************************
    // Total 5 methods

    // 1. switchToAlert
    public void switchToAlert(){
        driver.switchTo().alert(); // creating alert object reference and Switch to alert
    }

    // 2. acceptAlert both are void
    public void acceptAlert(){
        driver.switchTo().alert();
    }

    // 3. dismissAlert
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    // 4.sendTextToAlert
    public void sendTextToAlert(By by, String text){
        driver.switchTo().alert().sendKeys(text);
        // driver.findElement(by).sendTextToAlert(by,text);
    }

    // 5.getTextToAlert
    public String getTextFromAlert(By by){
        return driver.switchTo().alert().getText();
        //  return driver.findElement(by).getText()
    }


    //*************************** Select Class Methods ***************************************//
    // 1. selectByValueFromDropDown(By by, String value)
    public void selectByValueFromDropDown(By by, String value){
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select class
        Select select = new Select(dropDown);
        // Select by visible
        select.selectByValue(value);
    }

    // 2.selectByIndexFromDropDown(By by, int index)
    public void selectByIndexFromDropDown(By by, int index){
        WebElement index1 = driver.findElement(by);
        Select select = new Select(index1);
        select.selectByIndex(index);
    }

    // 3. selectByVisibleTextFromDropDown(By by, String text)
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement visibleText = driver.findElement(by);
        Select select = new Select(visibleText);
        select.selectByVisibleText(text);
    }


    //*****************************Action Methods********************//
    //1. mouseHoverToElement
    public void mouseHoverToElement(By by){
        WebElement mouse1 = driver.findElement(by);
        // WebElement mouse2 = driver.findElement(by);
        // actions.moveToElement(mouse1).moveToElement(mouse2).click().build().perform();
        Actions actions = new Actions(driver);
        actions.moveToElement(mouse1).click().build().perform();

    }
}
