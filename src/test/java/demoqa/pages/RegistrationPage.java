package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
   private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final String TITLE_TEXT = "Practice Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#gender-radio-1"),
            uploadPicture = $("#uploadPicture"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            userNumberInput = $("#userNumber");


    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(TITLE_TEXT));

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }
    public RegistrationPage setGender() {
        genderInput.parent().click();
        return this;
    }

    public RegistrationPage setNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setDateOfBirth(){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOptionByValue("2000");
        $(".react-datepicker__day--016").click();
        return this;
    }

    public RegistrationPage setAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();        return this;
    }

    public RegistrationPage setSubject (String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies (String hobbies) {
        hobbiesInput.find(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage submit () {
        $("#submit").click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears(){
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }



}
