package stepDefinitions;

import dataProvider.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import pageObjects.ActiveTodosPage;
import pageObjects.AllTodosPage;
import pageObjects.CompletedTodosPage;
import pageObjects.ViewtodosHomePage;

import java.util.concurrent.TimeUnit;

public class steps {
    WebDriver driver;
    ViewtodosHomePage home;
    AllTodosPage all;
    ActiveTodosPage active;
    CompletedTodosPage completed;
    PageObjectManager pageObjectManager;
    ConfigFileReader configFileReader;
    WebDriverManager webDriverManager;

    @Given("I am on ToDo MVC home page")
    public void i_am_on_to_do_mvc_home_page() {
        configFileReader = new ConfigFileReader();
//        System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
//        driver = new ChromeDriver();
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
        driver.get(configFileReader.getApplicationUrl());

    }

    @Given("I see title {string}")
    public void i_see_title(String string) {
        String title = driver.getTitle();
        System.out.println("The page title is : " + title);
    }

    @When("I enter new ToDo {string}")
    public void i_enter_new_to_do(String todo) {
        pageObjectManager = new PageObjectManager(driver);
        home = pageObjectManager.getHomePage();
        home.enter_newToDoItem(todo);

    }


    @Then("verify {string} gets displayed")
    public void verify_gets_displayed(String todo) {
        WebElement label1 = driver.findElement(By.xpath(String.format("//label[contains(text(),'%s')]", todo)));
        Assert.assertTrue(label1.isDisplayed());
        Assert.assertEquals(todo, label1.getText());

    }

    @Then("todo count show {string} item left")
    public void todo_count_show_item_left(String todoCount) {
        Assert.assertEquals(1, home.todo_count_show_item_left());
    }


    @Then("clicking link {string} show added item as {string}")
    public void clicking_link_show_added_item_as(String tab, String todoItem) {
        if (tab.contains("All")) {

            all = pageObjectManager.getAllPage();
            all.click_link_all();
            Assert.assertEquals(todoItem, all.get_text_of_label_under_all());
        } else if (tab.contains("Active")) {
            active = pageObjectManager.getActivePage();
            active.click_link_active();
            Assert.assertEquals(todoItem, active.get_text_of_label_under_active());
        } else if (tab.contains("Completed")) {
            completed = pageObjectManager.getCompletedPage();
            completed.click_link_completed();

            Assert.assertEquals(todoItem, completed.get_text_of_label_under_completed());
        }


    }

    @Then("clicking link {string} show no completed items")
    public void clicking_link_show_no_completed_items(String string) {
        completed = pageObjectManager.getCompletedPage();
        completed.click_link_completed();
        boolean isLabelPresent = true;
        try {
            driver.findElement(By.xpath("//div[@class='view']//label[1]"));
        } catch (NoSuchElementException e) {
            isLabelPresent = false;
        }
        Assert.assertEquals(false,isLabelPresent);
        webDriverManager.closeDriver();

    }

    @When("I mark {string} as complete by clicking on checkbox next to it")
    public void i_mark_as_complete_by_clicking_on_checkbox_next_to_it(String string) {
        home.mark_todo_as_complete();
    }


    @Then("clicking link {string} show {string} as completed")
    public void clicking_link_show_as_completed(String string, String string2) {
        completed = pageObjectManager.getCompletedPage();
        completed.click_link_completed();
        boolean isLabelPresent = true;
        try {
            driver.findElement(By.xpath("//div[@class='view']//label[1]"));
        } catch (NoSuchElementException e) {
            isLabelPresent = false;
        }
        Assert.assertEquals(true,isLabelPresent);
        webDriverManager.closeDriver();

    }


}
