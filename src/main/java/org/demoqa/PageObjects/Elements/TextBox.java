package org.demoqa.PageObjects.Elements;

import org.demoqa.factory.DriverFactory;
import org.demoqa.utilities.ScrollHelper;
import org.demoqa.utilities.TestBase;
import org.demoqa.utilities.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TextBox extends TestBase {
    private WebDriver driver;
    private final ScrollHelper scroller = new ScrollHelper(DriverFactory.getDriver());
    private By fullName = By.id("userName");
    private By email = By.id("userEmail");
    private By currentAddress = By.id("currentAddress");
    private By permanentAddress = By.id("permanentAddress");
    private By submit = By.id("submit");
    private By output = By.xpath("//*[@id=\"output\"]/div/p");
    private By elementTypeList = By.xpath("//div[@class='element-list collapse show']/ul/li/span");

    public TextBox(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public String getElementsPageTitle() {
        return driver.getTitle();
    }

    public void fillTextBoxes(String name, String emailId, String curr_Address, String perm_Address){
        enterText(fullName,name);
        enterText(email,emailId);
        enterText(currentAddress,curr_Address);
        enterText(permanentAddress,perm_Address);
    }

    public void submit(){
        WebElement element= driver.findElement(submit);
        scroller.scrollTillElementIsVisible(element);
        click(element);
    }

    public void displayOutputElement(){
        List<WebElement> elementList = driver.findElements(output);
        for (WebElement element: elementList) {
            System.out.println(element.getText());
        }    }

    public void ClickOnElementType(String elementType){
        List<WebElement> elementList = driver.findElements(elementTypeList);
        for (WebElement element: elementList) {
           if(element.getText().equals(elementType)){
               click(element);
           }
        }
    }

//    public void clickOnHeaderWrapperTab(String tabName){
//        wait.addWait();
//        this.headerWrapper = By.xpath("//div[contains(text(),'"+tabName+"') and @class='header-text']");
//        click(headerWrapper);
//    }

}
