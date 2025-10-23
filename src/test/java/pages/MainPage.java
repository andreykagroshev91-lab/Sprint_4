package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void closeCookieBanner() {
        List<WebElement> cookieButtons = driver.findElements(LocatorsList.COOKIE_BUTTON);
        if (!cookieButtons.isEmpty()) {
            cookieButtons.get(0).click();
        }
    }

    public void clickQuestion(int index) {
        closeCookieBanner();

        // Скролл до элемента
        String questionId = "accordion__heading-" + index;
        ((JavascriptExecutor) driver).executeScript(
                "document.getElementById('" + questionId + "').scrollIntoView(true);"
        );

        // ID вопроса
        By questionLocator = By.id(questionId);
        WebElement question = wait.until(ExpectedConditions.elementToBeClickable(questionLocator));
        question.click();

        // Ждем появления ответа
        By answerLocator = By.id("accordion__panel-" + index);
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
    }

    public String getAnswerText(int index) {
        // ID ответа
        By answerLocator = By.id("accordion__panel-" + index);
        WebElement answer = wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
        return answer.getText();
    }

    public void clickOrderButtonTop() {
        closeCookieBanner();
        // Скролл наверх
        if (driver.getClass().getSimpleName().contains("Firefox")) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        }
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(LocatorsList.ORDER_BUTTON_TOP));
        button.click();
    }

    public void clickOrderButtonBottom() {
        closeCookieBanner();
        // Скролл вниз
        if (driver.getClass().getSimpleName().contains("Firefox")) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        }
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(LocatorsList.ORDER_BUTTON_BOTTOM));
        button.click();
    }
}