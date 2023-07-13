package org.demoqa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.By.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class TestBase extends WaitManager{
    WebDriver driver;
    Actions action;

    public TestBase(WebDriver driver){
        super(driver);
        this.driver=driver;
        this.action = new Actions(driver);
    }
    public void click(By locator){driver.findElement(locator).click();}
    public void click(WebElement element){
        element.click();
    }
    public void enterText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
    public String getTextValue(By locator){
        return driver.findElement(locator).getText();
    }
    public String getAttributeValue(By locator, String attribute){return driver.findElement(locator).getAttribute(attribute);}
    public WebElement getWebElement(By locator){return driver.findElement(locator);}
    public List<WebElement> getWebElements(By locator){
        return driver.findElements(locator);
    }
    public By setLocator(String locator, String param){
        return By.xpath(locator.replace("param",param));
    }
    public void doubleClick(By locator){
        action.doubleClick(getWebElement(locator)).perform();
    }
    public void rightClick(By locator){
        action.contextClick(getWebElement(locator)).perform();
    }
    public void closeNewTab(){
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        addWait();
        driver.switchTo().window(browserTabs .get(1));
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }
}
