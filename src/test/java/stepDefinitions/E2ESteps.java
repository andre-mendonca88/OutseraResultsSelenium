package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.Map;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.chrome.ChromeOptions;

public class E2ESteps {
    public WebDriver driver;

    public E2ESteps() {
        //WebDriverManager.firefoxdriver().setup(); // To run in other browsers using WebDriverManager
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu"); //avoid some desktop browsers issues
        this.driver = new ChromeDriver(options);
        //System.out.println("ChromeDriver initialized."); //Log for confirming the initialization
    }



    @Given("I open the guide page")
    public void i_open_the_guide_page() {
        driver.get("https://jsonplaceholder.typicode.com/guide/");
    }

    @When("I click on the guide menu")
    public void i_click_on_the_guide_menu() {

        driver.findElement(By.linkText("Guide")).click();
    }

    @When("I navigate to albums photos")
    public void i_navigate_to_albums_photos() {

        driver.findElement(By.linkText("/albums/1/photos")).click();
    }

    @Then("I should see the photos data")
    public void i_should_see_the_photos_data() {
        String jsonText = driver.findElement(By.tagName("pre")).getText();
        //verify if the jsonText is not empty
        Assert.assertNotNull(jsonText);
     }

    @Then("I validate the object with id 6")
    public void i_validate_the_object_with_id_6() {
        String jsonText = driver.findElement(By.tagName("pre")).getText();
        List<Map<String, Object>> photosData = JsonPath.from(jsonText).getList("");
        Map<String, Object> objectId6 = photosData.stream()
                .filter(photo -> ((Integer) photo.get("id")) == 6)
                .findFirst()
                .orElse(null);
        Assert.assertNotNull(objectId6);
        Assert.assertTrue(objectId6.containsKey("title"));
        driver.quit();
    }
}