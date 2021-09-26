package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import dataProvider.ConfigFileReader;



import java.util.List;

public class ViewtodosHomePage {
    WebDriver driver;
    ConfigFileReader configFileReader;
    public ViewtodosHomePage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);

    }

    @FindBy(how= How.XPATH, using = "//input[@class='new-todo']")
    private WebElement txtbx_newtodo;

    @FindBy(how= How.XPATH, using = "//h1[contains(text(),'todos')]")
    private WebElement header_todos;

    @FindAll(@FindBy(how= How.XPATH, using = "//div[@class='view']//input[@type='checkbox']"))
    private List<WebElement> todos_list;

    @FindBy(how= How.XPATH, using = "//label[@for='toggle-all']")
    private WebElement toggle_all_todos_icon;

    @FindBy(how= How.XPATH, using = "//button[@class='clear-completed']")
    private WebElement btn_clear_completed;

    @FindBy(how= How.XPATH, using = "//button[@class='destroy']")
    private WebElement btn_destroy;

    public void enter_newToDoItem(String todoItem){
        txtbx_newtodo.click();
        txtbx_newtodo.sendKeys(todoItem);
        txtbx_newtodo.sendKeys(Keys.RETURN);
    }

    public void navigateTo_HomePage(){
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
    }


    public int todo_count_show_item_left() {

        return todos_list.size();

    }

    public void mark_todo_as_complete(){
        for(WebElement wb: todos_list){
            wb.isDisplayed();
            wb.click();
        }

    }

    public void click_toggle_all_todos_icon(){
        toggle_all_todos_icon.click();
    }

    public void click_Btn_clear_completed(){
        btn_clear_completed.isDisplayed();
        btn_clear_completed.click();

    }

    public void click_btn_destroy(){
        btn_destroy.click();

    }


}
