//package stepDefinitions;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class steps {
//    WebDriver driver;
//    WebElement newtodo;
//
//    @Given("I am on ToDo MVC home page")
//    public void i_am_on_to_do_mvc_home_page() {
//        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://todomvc.com/examples/vue/");
//
//    }
//    @Given("I see title {string}")
//    public void i_see_title(String string) {
//        String title = driver.getTitle();
//        System.out.println("The page title is : " + title);
//    }
//    @When("I enter new ToDo {string}")
//    public void i_enter_new_to_do(String todo) {
//        newtodo = driver.findElement(By.xpath("//input[@class='new-todo']"));
//        newtodo.isDisplayed();
//        Assert.assertTrue(newtodo.isEnabled());
//        newtodo.click();
//        newtodo.sendKeys(""+todo);
//
//
//    }
//    @When("press enter")
//    public void press_enter() {
//        newtodo.sendKeys(Keys.RETURN);
//    }
//    @Then("verify {string} gets displayed")
//    public void verify_gets_displayed(String todo) {
//        WebElement label1 = driver.findElement(By.xpath(String.format("//label[contains(text(),'%s')]",todo)));
//        Assert.assertTrue(label1.isDisplayed());
//        Assert.assertEquals(todo,label1.getText());
//
//    }
//    @Then("todo count show {string} item left")
//    public void todo_count_show_item_left(String string) {
//        List<WebElement> todoItems = driver.findElements(By.xpath("//div[@class='view']//input[@type='checkbox']"));
//        Assert.assertEquals(1,todoItems.size());
//
//    }
//
//
//    @Then("clicking link {string} show added item as {string}")
//    public void clicking_link_show_added_item_as(String tab, String todoItem) {
//        if(tab.contains("All")) {
//                WebElement linkAll = driver.findElement(By.xpath("//a[@class='selected']"));
//                WebElement labelUnderAll = driver.findElement(By.xpath("//label[contains(text(),'example todo one')]"));
//            Assert.assertEquals(todoItem, labelUnderAll.getText());
//        }else if(tab.contains("Active")) {
//            WebElement linkActive = driver.findElement(By.xpath("//a[contains(text(),'Active')]"));
//            WebElement labelUnderActive = driver.findElement(By.xpath("//label[contains(text(),'example todo one')]"));
//            Assert.assertEquals(todoItem, labelUnderActive.getText());
//        }else if(tab.contains("Completed")) {
//            WebElement linkCompleted = driver.findElement(By.xpath("//a[contains(text(),'Completed')]"));
//            WebElement labelUnderCompleted = driver.findElement(By.xpath("//label[contains(text(),'example todo one')]"));
//            Assert.assertEquals(todoItem, labelUnderCompleted.getText());
//        }
//
//
//
//    }
//    @Then("clicking link {string} show no completed items")
//    public void clicking_link_show_no_completed_items(String string) {
//
//    }
//
//}
