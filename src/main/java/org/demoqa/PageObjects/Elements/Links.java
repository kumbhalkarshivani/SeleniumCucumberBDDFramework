package org.demoqa.PageObjects.Elements;

import org.demoqa.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class Links extends TestBase {
    WebDriver driver;
    By locator = By.tagName("a");
    By home = By.linkText("Home");
    By dynamicLinktext = By.partialLinkText("Home");
    By Created = By.linkText("Created");
    By noContent = By.linkText("No Content");
    By moved = By.partialLinkText("Moved");
    By badRequest = By.partialLinkText("Bad Request");
    By output = By.id("linkResponse");

    public Links(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    public void clickOnHome(){
        click(home);
        addWait(10);
        closeNewTab();
    }
    public void clickOndynamicLinktext(){
        click(dynamicLinktext);
        addWait(10);
        closeNewTab();
    }
    public void created(){
        click(Created);
    }
    public void NoContent(){
        click(noContent);
    }
    public void moved(){
        click(moved);
    }
    public void badRequest(){
        click(badRequest);
    }
    public void CheckResponseMessage(){
        addWait();
        String message = getTextValue(output);
        System.out.println(message);
    }
}
