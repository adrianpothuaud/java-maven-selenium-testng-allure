package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Guess The Number")
@Feature("End Game")
public class EndGameTest extends BaseTest {

    @Test(priority = 1, description = "Presence of required element at the game over")
    @Severity(SeverityLevel.MINOR)
    @Description("Presence of required element at the game over")
    @Story("As a User's party is over, he should see game over elements")
    public void gameOver() {
        gamePage
                .goToGame()
                .forceGameOver()
                .verifyGameOverElements();
    }

    @Test(priority = 1, description = "Presence of required element at the game success")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Presence of required element at the game success")
    @Story("As a User's party is won, he should see success elements")
    public void gameSuccess() {
        gamePage
                .goToGame()
                .forceGameSuccess()
                .verifyGameSuccessElements();
    }
}
