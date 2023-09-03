package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static demoqa.utils.RandomUtils.randomEmail;
import static demoqa.utils.RandomUtils.randomString;

public class TextBoxTests extends TestBase {

    @Test
    void fillFormTest() {
        String userName = randomString(10),
                userEmail = randomEmail(),
                currentAddress = randomString(10),
                permanentAddress = randomString(10);

        textBoxPage
                .openPage()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit()

                .verifyResult("Name:", userName)
                .verifyResult("Email:", userEmail)
                .verifyResult("Current Address :", currentAddress)
                .verifyResult("Permananet Address :", permanentAddress);
    }
}
//    String userName = "Jakhongir Razzakov",
//            userEmail = "rzzkv@gmail.com",
//            currentAddress = "currentAddress",
//            permanentAddress = "permanentAddress";

//        open("/text-box");
//        $(".main-header").shouldHave(text("Text Box"));
//        $("#userName").setValue(userName);
//        $("#userEmail").setValue(userEmail);
//        $("#currentAddress").setValue(currentAddress);
//        $("#permanentAddress").setValue(permanentAddress);
//        $("#submit").click();
//
//        $("#output").shouldBe(Condition.visible);
//        $("#output #name").shouldHave(text(userName));
//        $("#output #email").shouldHave(text(userEmail));
//        $("#output #currentAddress").shouldHave(text(currentAddress));
//        $("#output #permanentAddress").shouldHave(text(permanentAddress));


