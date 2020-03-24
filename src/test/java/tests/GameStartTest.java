package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Guess The Number")
@Feature("Game Start")
public class GameStartTest extends BaseTest {

    @Test(priority = 1, description = "Presence of required element at the game start")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Presence of required element at the game start")
    @Story("As a User enter the game, he should see start elements")
    public void gameStartElementsAreDisplayed() {
        gamePage
                .goToGame()
                .verifyStartElementsAreDisplayed();
    }

    @Test(priority = 2, description = "Hiding required element at the game start")
    @Severity(SeverityLevel.MINOR)
    @Description("Hiding of required element at the game start")
    @Story("As a User enter the game, he should not see more than start elements")
    public void gameStartElementsOnlyAreDisplayed() {
        gamePage
                .goToGame()
                .verifyOnlyStartElementsAreDisplayed();
    }
}
