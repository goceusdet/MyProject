package com.stryker.stepDefinitions;

import com.stryker.utils.Driver;
import com.stryker.utils.Environment;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {

    /**
     * @Before will be executed automatically before EVERY scenario in the project.
     */
    @Before("@ui")
    public void setupMethod(){
        System.out.println("this is coming from BEFORE");
        Driver.getDriver().get(Environment.URL);
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
    }

    /**
     * @After will be executed automatically after EVERY scenario in the project.
     * @param scenario
     */
    @After("@ui")
    public void teardownMethod(Scenario scenario){

        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

}
