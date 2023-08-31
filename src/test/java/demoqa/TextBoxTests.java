package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy="eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "2560x1600";
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void fillFormTest() {
        String userName = "Jakhongir";
        String userEmail = "rzzkv@gmail.com";

        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue("currentAddress");
        $("#permanentAddress").setValue("permanentAddress");
        $("#submit").click();

        $("#output").shouldBe(Condition.visible);
        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text("currentAddress"));
        $("#output #permanentAddress").shouldHave(text("permanentAddress"));

    }
}
