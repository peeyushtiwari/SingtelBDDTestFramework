package seleniumTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class E2E_Test {

    private static WebDriver driver;

    //launch brower
    //navigate to url: https://todomvc.com/examples/vue/
    // click on what needs to be done ?
    //enter todo task name and press enter
    //Verfify it is added to the list under all tabs and active tabs
    //verify item left check
    //click on radio box to mark it as completed
    //And verify it gets striked out and show o items lef
    // click on completed tab and it should on completed tab
    //click on active tab to check if displays o items left
    // click link clear completed and list should get cleared


    public static void main(String[] args) throws InterruptedException {
        //setting the driver path
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");

        //creating WebDriver instance
        driver = new ChromeDriver();

        //maximize window
        driver.manage().window().maximize();

        //putting implicit wait
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        //Navigate to web page
        driver.get("https://todomvc.com/examples/vue/");

        //Get webpage title
        String title = driver.getTitle();
        System.out.println("The page title is : " + title);


        WebElement todo = driver.findElement(By.xpath("//input[@class='new-todo']"));
        todo.isDisplayed();
        Assert.assertTrue(todo.isEnabled());

        todo.click();
        todo.sendKeys("buy groceries");
        todo.sendKeys(Keys.RETURN);

        WebElement label1 = driver.findElement(By.xpath("//label[contains(text(),'buy groceries')]"));
        Assert.assertTrue(label1.isDisplayed());
        if (label1.getText().contains("buy groceries")) {
            Assert.assertEquals("buy groceries",label1.getText());
        }else{
            Assert.assertEquals("buy groceries",label1.getText());
        }

        WebElement checkbox1 = driver.findElement(By.xpath("//ul/li[1]//input[@type='checkbox']"));
        checkbox1.click();

        Thread.sleep(5000);

        WebElement clearCompleted = driver.findElement(By.xpath("//button[@class='clear-completed']"));
        clearCompleted.click();

        driver.quit();




    }


}
