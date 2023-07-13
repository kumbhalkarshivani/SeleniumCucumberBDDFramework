package org.demoqa.PageObjects;

import org.demoqa.factory.DriverFactory;
import org.demoqa.utilities.ScrollHelper;
import org.demoqa.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends TestBase {
    private final ScrollHelper scroller = new ScrollHelper(DriverFactory.getDriver());
    private final WebDriver driver;
    private String tab = "//h5[contains(text(),'param')]";

    public MainPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void clickOnTab(String tb){
        WebElement element = getWebElement(setLocator(tab,tb));
        scroller.scrollTillElementIsVisible(element);
        click(element);
    }
}
