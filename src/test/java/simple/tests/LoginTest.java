package simple.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    @Test
    void successfulLoginTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://qa.guru/cms/system/login");
        $(".login-form").shouldHave(text("Войти"));
        $("[name=email]").setValue("qagurubot@gmail.com");
        $("[name=password]").setValue("qagurupassword");
        $(".btn-success").click();
        $(".main-header__login").click();
        $(".logined-form").shouldHave(text("Здравствуйте, QA_GURU_BOT"));

    }
}