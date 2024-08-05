package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtils;

public class Hooks {
    private WebDriver driver;

    public Hooks() {

    }

    @Before
    public void setUp() {
        driver = new E2ESteps().driver;
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed, taking screenshot...");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");

            String screenshotPath = "target/cucumber-reports/screenshots/" + scenario.getName() + ".png";
            ScreenshotUtils.takeScreenshot(driver, screenshotPath);
        }

        if (driver != null) {
            driver.quit();
            System.out.println("WebDriver closed.");
        }
    }
}
