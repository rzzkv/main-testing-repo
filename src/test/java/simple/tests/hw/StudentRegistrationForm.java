package simple.tests.hw;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
//        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "2560x1600";
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void fillFormTest() {
        String firstName = "Jakhongir";
        String lastName = "Razzakov";
        String userEmail = "rzzkv@gmail.com";
        String currentAddress = "currentAddress";
        String userNumber = "8936236723";

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOptionByValue("2000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--016").click();

        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").find(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("test.jpg");

        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();

        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail));

    }
}
