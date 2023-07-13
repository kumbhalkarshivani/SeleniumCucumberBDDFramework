package org.demoqa.PageObjects.Elements;

import org.demoqa.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Buttons extends TestBase {
    WebDriver driver;
    By doubleClick = By.id("doubleClickBtn");
    By rightClick = By.id("rightClickBtn");
    By dynamicButton = By.xpath("//button[text()='Click Me']");
    By output = By.xpath("//p[contains(@id,'Message')]");

    public Buttons(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void click(String buttonName){
        if(buttonName.equals("Double")){
            doubleClick(doubleClick);
        } else if (buttonName.equals("Right")) {
            rightClick(rightClick);
        }else {
            click(dynamicButton);
        }
    }
    public void displayOutput(){
        addWait();
        String message = getTextValue(output);
        System.out.println(message);
    }
}
