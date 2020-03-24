package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
    }

    // Click Method
    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    // Write Text
    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    // Read Text
    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

    // Wait
    public void waitVisibility(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Visibility
    public boolean isDisplayed(By by) {
        return driver.findElement(by).isDisplayed();
    }

    // Screenshot text attachments for Allure
    public void saveScreenshotPNG (String name) {
        String scrn = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        Allure.addAttachment(name, scrn);
    }
}
