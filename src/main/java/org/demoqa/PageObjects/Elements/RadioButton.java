package org.demoqa.PageObjects.Elements;

import org.demoqa.utilities.TestBase;
import org.demoqa.utilities.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton extends TestBase {
    WebDriver driver;
    String radioButton = "//*[contains(text(),'param')]/preceding-sibling::input";
    String clickButton = "//*[contains(text(),'param')]";
    private final By output = By.xpath("//p[contains(text(),'You have selected')]");
    boolean buttonState = true;
    public RadioButton(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void checkIfRadioButtonEnabledAndClick(String buttonName){
        By locator = setLocator(radioButton,buttonName);
        String attribute = getAttributeValue(locator,"class");
        if(attribute.contains("disabled")){
            buttonState = false;
            System.out.println(buttonName + " radio Button is Disabled");
        }else{
            addWait(10);
            click(setLocator(clickButton,buttonName));
        }
    }

    public void displayOutput(){
        if(buttonState){
            String result = getTextValue(output);
            System.out.println(result);
        }else {
            System.out.println("No Output : As radio Button is Disabled");
        }

    }
}
