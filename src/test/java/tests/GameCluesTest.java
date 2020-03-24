package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Guess The Number")
@Feature("Game Clues")
public class GameCluesTest extends BaseTest {

    @Test(priority = 1, description = "Presence of required element when the number is too low")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Presence of required element when the number is too low")
    @Story("As a User gives a number too low, he should see according clue")
    public void lowerNumberElements() {
        gamePage
                .goToGame()
                .setMystery(50)
                .sendNumber(40)
                .verifyHigherClue();
    }

    @Test(priority = 1, description = "Presence of required element when the number is too high")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Presence of required element when the number is too high")
    @Story("As a User gives a number too high, he should see according clue")
    public void higherNumberElements() {
        gamePage
                .goToGame()
                .setMystery(50)
                .sendNumber(60)
                .verifyLowerClue();
    }
}
