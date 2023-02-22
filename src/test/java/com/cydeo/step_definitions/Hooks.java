package com.cydeo.step_definitions;
//we will be able to create pre and post conditions for all the scenarios and even tests

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    //@Before
    public void setupMethod() {
        System.out.println("--> @Before: RUNNING BEFORE EACH SCENARIO");
    }

    @After //will be executed automatically after every scenario in the project
    public void teardownMethod(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        System.out.println("--> @After: RUNNING AFTER EACH SCENARIO");
        Driver.closeDriver();
    }

    //@BeforeStep
    public void setupStep() {
        System.out.println("--> @BeforeSTEP: Running before each step");
    }

    //@AfterStep
    public void teardownStep() {
        System.out.println("--> @AfterSTEP: Running after each step");
    }


}
