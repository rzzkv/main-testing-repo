package simple.tests.hw;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @Test
    void testDragAndDrop(){

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-b").shouldHave(Condition.text("A"));
    }
}
