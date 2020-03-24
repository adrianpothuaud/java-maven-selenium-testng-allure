package pages;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class GamePage extends BasePage {

    /**
     * Constructor
     */
    public GamePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Variables
     */
    String baseURL = "https://adrianpothuaud.github.io/guess-the-number/public/index";

    /**
     * Web Elements
     */

    // timeout bloc
    By timeLeftValue = By.id("timeLeftValue");

    // guess bloc
    By guessInput = By.id("guessInput");
    By submitBtn = By.id("submitBtn");

    // clues bloc
    By clueLeft = By.id("clueLeft");
    By clueRight = By.id("clueRight");
    By clueLess = By.id("less");
    By clueMore = By.id("more");
    By clueOk = By.id("ok");
    By clueNOk = By.id("nok");

    // results bloc
    By resText = By.id("resText");

    // actions bloc
    By reloadBtn = By.id("reloadBtn");
    By stopBtn = By.id("stopBtn");

    /**
     * Page Methods
     */

    // Go to Homepage
    @Step("Open Game Step...")
    public GamePage goToGame() {
        driver.get(baseURL);
        saveScreenshotPNG("Open page");
        return this;
    }

    // Verify start elements
    @Step("Verify display of the start game elements")
    public GamePage verifyStartElementsAreDisplayed() {
        Assertions.assertThat(isDisplayed(timeLeftValue)).isTrue();
        Assertions.assertThat(isDisplayed(guessInput)).isTrue();
        Assertions.assertThat(isDisplayed(submitBtn)).isTrue();
        Assertions.assertThat(isDisplayed(clueLeft)).isTrue();
        Assertions.assertThat(isDisplayed(clueRight)).isTrue();
        Assertions.assertThat(isDisplayed(reloadBtn)).isTrue();
        Assertions.assertThat(isDisplayed(stopBtn)).isTrue();
        return this;
    }

    // Verify start elements
    @Step("Verify hiding of other game elements")
    public GamePage verifyOnlyStartElementsAreDisplayed() {
        Assertions.assertThat(isDisplayed(clueLess)).isFalse();
        Assertions.assertThat(isDisplayed(clueMore)).isFalse();
        Assertions.assertThat(isDisplayed(clueOk)).isFalse();
        Assertions.assertThat(isDisplayed(clueNOk)).isFalse();
        Assertions.assertThat(isDisplayed(resText)).isFalse();
        return this;
    }

    // Verify game over elements
    @Step("Verify display of the game over elements")
    public GamePage verifyGameOverElements() {
        Assertions.assertThat(isDisplayed(clueNOk)).isTrue();
        Assertions.assertThat(isDisplayed(reloadBtn)).isTrue();
        return this;
    }

    // Verify game success elements
    @Step("Verify display of the game success elements")
    public GamePage verifyGameSuccessElements() {
        Assertions.assertThat(isDisplayed(clueOk)).isTrue();
        Assertions.assertThat(isDisplayed(resText)).isTrue();
        Assertions.assertThat(isDisplayed(reloadBtn)).isTrue();
        return this;
    }

    // Verify lower clue
    @Step("Verify display of lower clue")
    public GamePage verifyLowerClue() {
        waitVisibility(clueLess);
        return this;
    }

    // Verify higher clue
    @Step("Verify display of higher clue")
    public GamePage verifyHigherClue() {
        waitVisibility(clueMore);
        return this;
    }

    // Get timeLeft by javascript code
    public int getTimeLeft() {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        String timeLeftStr = jsExec.executeScript("return timeLeft;").toString();
        return Integer.parseInt(timeLeftStr);
    }

    // Get mystery by javascript code
    public int getMystery() {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        String mysteryStr = jsExec.executeScript("return mystery;").toString();
        return Integer.parseInt(mysteryStr);
    }

    // Set mystery by javascript code
    public GamePage setMystery(int mystery) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("mystery=" + mystery + ";");
        return this;
    }

    // Send a number for verification
    @Step("Sending a number")
    public GamePage sendNumber(int num) {
        driver.findElement(guessInput).sendKeys(String.valueOf(num));
        driver.findElement(submitBtn).click();
        saveScreenshotPNG("Send number");
        return this;
    }

    // Verify clue

    // Force game over
    @Step("Forcing game over method")
    public GamePage forceGameOver() {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("gameOver();");
        saveScreenshotPNG("Game over");
        return this;
    }

    // Force game success
    @Step("Forcing game success method")
    public GamePage forceGameSuccess() {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("youWin();");
        saveScreenshotPNG("Win game");
        return this;
    }

}
