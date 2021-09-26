package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ActiveTodosPage {

    public ActiveTodosPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.XPATH, using = " //a[contains(text(),'Active')]")
    private WebElement lnk_active;

    @FindBy(how= How.XPATH, using = "//div[@class='view']//label[1]")
    private WebElement label_under_active;

    public void click_link_active(){
        lnk_active.isDisplayed();
        lnk_active.click();
    }

    public String get_text_of_label_under_active(){
        label_under_active.isDisplayed();
        return label_under_active.getText();

    }


}
