package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AllTodosPage {

    public AllTodosPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.XPATH, using = "//a[@class='selected']")
    private WebElement lnk_all;

    @FindBy(how= How.XPATH, using = "//div[@class='view']//label[1]")
    private WebElement label_under_all;

    public void click_link_all(){
        lnk_all.isDisplayed();
        lnk_all.click();
    }

    public String get_text_of_label_under_all(){
        label_under_all.isDisplayed();
        return label_under_all.getText();
    }


}
