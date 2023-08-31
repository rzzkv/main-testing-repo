package jUnit;

import jUnit.data.Locale;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideLocaleTest {

    static Stream<Arguments> selenideLocaleDataProvider() {
        return Stream.of(
                Arguments.of(Locale.EN, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Locale.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }
   /*
   * Stream name should be either identical to methode or we should mention it in @MethodSource("Stream name")
   */
    @MethodSource("selenideLocaleDataProvider")
    @ParameterizedTest(name = "Для локали {0} отображаются кнопки {1}")
    @Tag("BLOCKER")
    void selenideSiteShouldContainAllOfButtonsForGivenLocale(
            Locale locale,
            List<String> buttons
    ) {
        open("https://ru.selenide.org/");
        $$("#languages a").find(text(locale.name())).click();
        $$(".main-menu-pages a")
                .filter(visible)
                .shouldHave(texts(buttons));
    }

}
