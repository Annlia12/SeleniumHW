import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class StudentsAppTest {

    WebDriver driver;

    @BeforeClass
    public void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "/Users/annliashenko/Downloads/chromedriver");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeEachMethod() {
        driver.get("http://151.80.70.42:3000/");
    }


    @Test
    public void openStudentsApp() {
        Assert.assertEquals(driver.getTitle(), "App Students");

    }


    @Test
    public void deleteUser() throws InterruptedException {

        Thread.sleep(5000);
        int sizeBefore = driver.findElements(By.cssSelector("#user-list > li")).size();
        System.out.println(sizeBefore);
        driver.findElement(By.cssSelector("#user-list > li:nth-child(2) > a.secondary-content")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        int sizeAfter = driver.findElements(By.cssSelector("#user-list > li")).size();
        Assert.assertTrue(sizeAfter < sizeBefore);


    }

    @AfterClass
    public void afterEachMethod() {
        driver.quit();
    }


}
