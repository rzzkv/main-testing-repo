package simple.tests.hw;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubEnterprise {

    @Test
    void clickOnEnterpriseWithHover(){

        open("https://github.com/");
        $(".Header-old").find(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $(".application-main").shouldHave(text("GitHub for enterprises"));

    }
}
