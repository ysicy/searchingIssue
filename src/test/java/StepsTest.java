import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class StepsTest extends TestBase{

    @Test
    public void searchIssueTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStepsTest steps = new WebStepsTest();

        steps.openMainPage();
        steps.searchRepo();
        steps.clickRepo();
        steps.clickIssue();
        steps.searchText();
    }

}

