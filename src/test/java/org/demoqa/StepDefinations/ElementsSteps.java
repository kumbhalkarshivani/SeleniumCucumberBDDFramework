package org.demoqa.StepDefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.demoqa.PageObjects.Elements.*;
import org.demoqa.PageObjects.MainPage;
import org.demoqa.factory.DriverFactory;
import java.util.List;
import java.util.Map;

public class ElementsSteps {
    private final MainPage mainPage = new MainPage(DriverFactory.getDriver());
    private final TextBox textBox = new TextBox(DriverFactory.getDriver());
    private final CheckBox checkBox = new CheckBox(DriverFactory.getDriver());
    private final RadioButton radioButton = new RadioButton(DriverFactory.getDriver());
    private final WebTable webTable = new WebTable(DriverFactory.getDriver());
    private final Buttons buttons = new Buttons(DriverFactory.getDriver());
    private final Links links = new Links(DriverFactory.getDriver());

    @Given("Navigate to {string} Site and click on {string} tab")
    public void navigate_to_site_and_click_on_tab(String baseUrl, String tabName) {
        DriverFactory.getDriver().get(baseUrl);
        mainPage.clickOnTab(tabName);    }

    @Given("Then Click on {string}")
    public void then_click_on(String tabName) {
        textBox.ClickOnElementType(tabName);
    }

    @When("Enter Full Name, Email, Current and Permanent Address and Submit")
    public void enter_full_name_email_current_and_permanent_address_and_submit(DataTable dataTable) {
        List<Map<String, String>> details = dataTable.asMaps();
        String fullName = details.get(0).get("fullName");
        String email = details.get(0).get("emailId");
        String currentAddress = details.get(0).get("currentAddress");
        String permanentAddress = details.get(0).get("permanentAddress");

        textBox.fillTextBoxes(fullName,email,currentAddress,permanentAddress);
        textBox.submit();
    }

    @Then("Display Text Box Output")
    public void displayOutput() {
        textBox.displayOutputElement();
    }
    @When("Check on {string} Check Boxes")
    public void checkOnCheckBoxes(String checkBoxValue) {
        checkBox.checkBoxclick(checkBoxValue);
    }

    @When("Expand on {string}  node")
    public void expandOnNode(String node) {
        checkBox.collapseOrExpand(node);
    }

    @Then("Display Check Box Output")
    public void displayCheckBoxOutput() {
        checkBox.displayOutput();
    }

    @When("Click on {string} Radio button")
    public void clickOnRadioButton(String buttonName) {
        radioButton.checkIfRadioButtonEnabledAndClick(buttonName);
    }

    @Then("Display Radio Button Output")
    public void displayRadioButtonOutput() {
        radioButton.displayOutput();
    }

    @When("Add Data as given below")
    public void addDataAsGivenBelow(DataTable dataTable) {
        List<Map<String, String>> details = dataTable.asMaps();
        webTable.addDataAndSubmit(details);
    }

    @Then("Check If data in table")
    public void checkIfDataInTable() {
        webTable.checkRecordInTable();
    }

    @When("Click on Add Button")
    public void clickOnAddButton() {
        webTable.clickOnAddButton();
    }

    @Then("Check Output")
    public void checkOutput() {
        buttons.displayOutput();
    }

    @When("click on {string} Click")
    public void clickOnClick(String button) {
        buttons.click(button);
    }

    @When("click on {string} Link")
    public void clickOnLink(String link) {
        if(link.equals("Home")){
            links.clickOnHome();
        }else {
            links.clickOndynamicLinktext();
        }
    }

    public void checkOutputMessage() {
        links.CheckResponseMessage();
    }

    @When("click on {string} API Link")
    public void clickOnAPILink(String link) {
        if(link.equalsIgnoreCase("created")){
            links.created();
        } else if (link.equalsIgnoreCase("moved")){
            links.moved();
        } else if (link.equalsIgnoreCase("badrequest")){
            links.badRequest();
        }else{
            links.NoContent();
        }
        checkOutputMessage();
    }
}
