package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class CompletedTodosPage {

    public CompletedTodosPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.XPATH, using = "//a[contains(text(),'Completed')]")
    private WebElement lnk_completed;

    @FindBy(how= How.XPATH, using = "//div[@class='view']//label[1]")
    private WebElement label_under_completed;

    public void click_link_completed() {

        lnk_completed.isDisplayed();
        lnk_completed.click();

    }

    public String get_text_of_label_under_completed(){
        label_under_completed.isDisplayed();
        return label_under_completed.getText();

    }




}
