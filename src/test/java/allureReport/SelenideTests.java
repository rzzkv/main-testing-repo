package allureReport;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {

    @Test
    void shouldHaveRepositoryAtTheTop() {

        open("https://github.com/");
        $(".input-button").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $("a[href*='/selenide/selenide']").click();
        $("#repository-container-header").shouldHave(text("selenide"));
    }

    @Test
    void solntsevShouldBeTheTopContributor() {

        open("https://github.com/selenide/selenide");
        $(".BorderGrid").$(byText("Contributors"))
                .ancestor(".BorderGrid-row").$$("ul li").first().hover();
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
    }

    @Test
    void shouldHaveJUnit5CodeEx() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-demoqa.pages-filter").setValue("SoftAssertions");
        $(".Box--condensed").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));
    }

}