import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;



    public class WebStepsTest extends TestBase{
        @Step("Открываем главную страницу github")
        public void openMainPage() {
            open("https://github.com/");
        }
        @Step("Ищем репозиторий")
        public void searchRepo() {
            $x("//div[contains(@class,'mr-2 color-fg-muted')]").click();
            $x("//input[contains(@id,'query-builder-test')]").sendKeys(FindIssueTest.REPOSITORY);
            $x("//input[contains(@id,'query-builder-test')]").pressEnter();
        }
        @Step("Кликаем по ссылке репозитория")
        public void clickRepo() {
            $(linkText(FindIssueTest.REPOSITORY)).click();
        }
        @Step("Кликаем по таб Issue")
        public void clickIssue() {
            $x("//a[contains(@id,'issues-tab')]").click();
        }
        @Step("Проверяем наличие текста")
        public void searchText() {
            $x("//div[contains(@class,'container-md')]").shouldHave(Condition.text(FindIssueTest.ISSUETEXT));
        }
    }
