package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class GitHubLambdaTest {


    private  static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String NAMEISSUE = "IK New Issue";


    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем гл. страницу", () -> {
            open("https://github.com");
        });
        step("В поиск вводим название репозитория и ищем его", () -> {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });
        step("Переходим по ссылке с названием репозитория:  " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем  таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем, что на странице есть Issue c названием: " + NAMEISSUE, () -> {
            $(withText(NAMEISSUE)).should(Condition.visible);
        });

    }

}