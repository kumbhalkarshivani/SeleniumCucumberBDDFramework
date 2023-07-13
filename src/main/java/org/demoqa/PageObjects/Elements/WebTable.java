package org.demoqa.PageObjects.Elements;

import org.demoqa.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebTable extends TestBase {
    private WebDriver driver;
    private By addButton = By.id("addNewRecordButton");
    private By tableRows = By.xpath("//*[@class='rt-tbody']/div");
    private String cell = "//*[@class='rt-tbody']/div[param]/div/div";
    private List<Map<String,String>> inputlist;

    public WebTable(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void addDataAndSubmit(List<Map<String,String>> list){
        this.inputlist = list;
        for (Map<String,String> map: list) {
            for ( String key: map.keySet()) {
                enterText(By.id(key),map.get(key));
            }
        }
        driver.findElement(By.id("submit")).click();
    }
    public void clickOnAddButton(){
        click(addButton);
    }
    public void checkRecordInTable(){
        List<WebElement> rows = getWebElements(tableRows);
        int totalRows = rows.size();
        List<String> record = new ArrayList<>();
        for (Map<String,String> map: inputlist) {
            for ( String key: map.keySet()) {
                record.add(map.get(key));
            }
        }
        for(int i = 1; i <= totalRows ; i++){
            String cellValue = getTextValue(setLocator(cell, Integer.toString(i)));
            if(record.contains(cellValue)){
                System.out.print(cellValue);
            }
        }
    }
}
