package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import demoqa.pages.RegistrationPage;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();

    @BeforeAll
    static void beforeAll() {
//        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy="eager";
        Configuration.browserSize = "2560x1600";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
