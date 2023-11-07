import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;



    public class WebSteps {
        @Step("Открываем главную страницу github")
        public void openMainPage() {
            open("https://github.com/");
        }
        @Step("Ищем репозиторий")
        public void searchRepo(String repo, String locator, String search) {
            $(locator).click();
            $(search).sendKeys(repo);
            $(search).pressEnter();
        }
        @Step("Кликаем по ссылке репозитория")
        public void clickRepo(String repo) {
            $(linkText(repo)).click();
        }
        @Step("Кликаем по таб Issue")
        public void clickIssue() {
            $x("//a[contains(@id,'issues-tab')]").click();
        }
        @Step("Проверяем наличие текста")
        public void searchText(String value) {
            $(withText(value)).should(Condition.exist);
        }
        }