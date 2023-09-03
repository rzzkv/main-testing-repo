package demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private final String TITLE_TEXT = "Text Box";
    private SelenideElement
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            userCurrentAddress = $("#currentAddress"),
            userPermanentAddress = $("#permanentAddress");

    public TextBoxPage openPage(){
        open("/text-box");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        return this;
    }
    public TextBoxPage setUserName(String userName) {
        userNameInput.setValue(userName);
        return this;
    }
    public TextBoxPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }
    public TextBoxPage setCurrentAddress(String currentAddress) {
        userCurrentAddress.setValue(currentAddress);
        return this;
    }
    public TextBoxPage setPermanentAddress (String permanentAddress) {
        userPermanentAddress.setValue(permanentAddress);
        return this;
    }
    public TextBoxPage submit () {
        $("#submit").click();
        return this;
    }
    public TextBoxPage verifyResult (String key, String value) {
        $("#output").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}
