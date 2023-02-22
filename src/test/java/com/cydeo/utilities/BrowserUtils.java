package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    //This method will accept int (seconds) and will execute Thread.sleep method for giving duration
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
        }
    }

    public static void switchWindowAndVerify(String expectedInURL, String expectedTitle) {

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL)) {
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    public static void verifyTitleContains(String expectedInTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    public static void waitForInvisibilityOf(WebElement target) {
        //create an obj of WebDriver class to set up the constructor arg
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //waiting till expected condition load bar is invisible
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    public static void waitForTitleContains(String title) {
        //create an obj of WebDriver class to set up the constructor arg
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //waiting till expected condition title contains
        wait.until(ExpectedConditions.titleContains(title));
    }

    /**
     * This method accepts a dropdown element and returns List<Strings> that contains all options values as String
     * @param dropdownElement
     * @return
     */
    public static List<String> dropdownOptions_as_STRING(WebElement dropdownElement) {

        Select dropdown = new Select(dropdownElement);
        //Storing all the ACTUAL option into list of WebElements
        List<WebElement> actual_webElement = dropdown.getOptions();

        //Creating an EMPTY list of String to store ACTUAL <option> as a String
        List<String> actualElement_as_STRING = new ArrayList<>();

        //Looping thru the List<WebElement>, getting all options as a text, storing into List<String>
        for (WebElement each : actual_webElement) {
            actualElement_as_STRING.add(each.getText());
        }

        return actualElement_as_STRING;
    }
}

