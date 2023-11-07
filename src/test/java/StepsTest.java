import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepsTest{

    private static final String REPOSITORY = "ysicy/junitHomeWork";
    private static final String ISSUETEXT = "Welcome to issues!";
    private static final String URL = "https://github.com/";
    private static final String LOCATOR = ".search-input-container";
    private static final String SEARCH = "#query-builder-test";


    @Test
    @DisplayName("Проверка Issue в репозитории junitHomeWork с Listener")
    public void checkNameIssue() {
        open(URL);
        $(LOCATOR).click();
        $(SEARCH).setValue(REPOSITORY).pressEnter();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText(ISSUETEXT)).should(Condition.exist);
    }
    @Test
    @DisplayName("Проверка Issue в репозитории junitHomeWork по шагам с аннотацией @Step")
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

