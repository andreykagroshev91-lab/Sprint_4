package tests;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FirefoxFAQTest extends BaseTest {

    private final int questionIndex;

    public FirefoxFAQTest(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}
        });
    }

    @Before
    public void setUp() {
        setupFirefox();
    }

    @Test
    public void checkFAQQuestionAnswer() {
        MainPage mainPage = new MainPage(driver);

        // Нажали на выпадающий список
        mainPage.clickQuestion(questionIndex);

        // Ответ в выпадающем списке
        String answer = mainPage.getAnswerText(questionIndex);

        // Проверка что не пустой
        Assert.assertFalse("Ответ не должен быть пустым", answer.isEmpty());
        System.out.println("Вопрос " + questionIndex + ": " + answer);
    }
}