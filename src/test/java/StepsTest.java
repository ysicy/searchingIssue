import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest{

    private static final String REPOSITORY = "ysicy/junitHomeWork";
    private static final String ISSUETEXT = "Welcome to issues!";
    private static final String URL = "https://github.com/";
    private static final String LOCATOR = ".search-input-container";
    private static final String SEARCH = "#query-builder-test";


    @Test
    @Feature("Поиск в репозитории")
    @Story("Поиск в репозитории junitHomeWor")
    @Owner("ysicy")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверяем Issue в репозитории junitHomeWork с Listener")
    public void checkNameIssue() {
        open(URL);
        $(LOCATOR).click();
        $(SEARCH).setValue(REPOSITORY).pressEnter();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText(ISSUETEXT)).should(Condition.exist);
    }
    @Feature("Поиск в репозитории")
    @Story("Поиск в репозитории junitHomeWor")
    @Owner("ysicy")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверяем Issue в репозитории junitHomeWork с помощьюlambda")
    @Test
    public void lambdaStep () {
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
    @Feature("Поиск в репозитории")
    @Story("Поиск в репозитории junitHomeWor")
    @Owner("ysicy")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверяем Issue в репозитории junitHomeWork по шагам с аннотацией @Step")
    public void searchIssueTest(){

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchRepo(REPOSITORY, LOCATOR, SEARCH);
        steps.clickRepo(REPOSITORY);
        steps.clickIssue();
        steps.searchText(ISSUETEXT);
    }

}



