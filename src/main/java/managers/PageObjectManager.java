package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.ActiveTodosPage;
import pageObjects.AllTodosPage;
import pageObjects.CompletedTodosPage;
import pageObjects.ViewtodosHomePage;

public class PageObjectManager {

    private WebDriver driver;
    private ViewtodosHomePage homePage;
    private AllTodosPage allPage;
    private ActiveTodosPage activePage;
    private CompletedTodosPage completedPage;


    public PageObjectManager(WebDriver driver){
        this.driver = driver;

    }

    public ViewtodosHomePage getHomePage(){
        return(homePage==null) ? homePage = new ViewtodosHomePage(driver): homePage;

    }

    public AllTodosPage getAllPage(){
        return(allPage==null) ? allPage = new AllTodosPage(driver): allPage;

    }
    public ActiveTodosPage getActivePage(){
        return(activePage==null) ? activePage = new ActiveTodosPage(driver): activePage;
    }

    public CompletedTodosPage getCompletedPage(){
        return(completedPage==null) ? completedPage = new CompletedTodosPage(driver): completedPage;
    }

}
