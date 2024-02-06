package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueTest {

    @Test
    public void issueSearchTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".search-input-container").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("#query-builder-test").submit();
        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#81")).shouldHave(Condition.exist);
    }
}
