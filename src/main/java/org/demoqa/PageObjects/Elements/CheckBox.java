package org.demoqa.PageObjects.Elements;

import org.demoqa.factory.DriverFactory;
import org.demoqa.utilities.ScrollHelper;
import org.demoqa.utilities.TestBase;
import org.demoqa.utilities.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox extends TestBase {
    private final WebDriver driver;
    private final WaitManager wait;
    private By result = By.id("result");
    String collapseOrExpand = "//span[contains(text(),'param')]/parent::label" +
            "/preceding-sibling::button";
    String checkBox = "//span[contains(text(),'param')]";

    public CheckBox( WebDriver driver){
        super(driver);
        this.driver = driver;
        wait =  new WaitManager(driver);
    }

    public void collapseOrExpand(String node){
        wait.addWait();
        click(setLocator(collapseOrExpand,node));
    }
    public void checkBoxclick(String node){
        wait.addWait();
        click(setLocator(checkBox,node));
    }
    public void displayOutput(){
        String output = getTextValue(result);
        System.out.println(output);
    }
}
