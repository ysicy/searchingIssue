import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class FindIssueTest extends TestBase {
    public static final String REPOSITORY = "ysicy/junitHomeWork";
    public static final String ISSUETEXT = "Welcome to issues!";
    @Test
    public void testLambdaStep (){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу github", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $x("//div[contains(@class,'mr-2 color-fg-muted')]").click();
            $x("//input[contains(@id,'query-builder-test')]").sendKeys(REPOSITORY);
            $x("//input[contains(@id,'query-builder-test')]").pressEnter();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Кликаем по таб Issue", () -> {
            $x("//a[contains(@id,'issues-tab')]").click();
        });
        step("Проверяем наличие текста " + ISSUETEXT, () -> {
            $x("//div[contains(@class,'container-md')]").shouldHave(Condition.text(ISSUETEXT));
        });
    }

    @Test
    public void searchIssueTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchRepo();
        steps.clickRepo();
        steps.clickIssue();
        steps.searchText();
    }

}