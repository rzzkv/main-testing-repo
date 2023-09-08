package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demoqa.helpers.Attach;
import demoqa.pages.TextBoxPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();
    TestData data = new TestData();

    @BeforeAll
    static void beforeAll() {
//        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy="eager";
        Configuration.browserSize = "2560x1600";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

//    @AfterEach
//    void addAttachments() {
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();
//        Attach.addVideo();
//    }
}
