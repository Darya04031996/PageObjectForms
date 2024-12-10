package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxTests extends TestBase {

    @Test
    void fillformTest() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#UserName").setValue("Darya Melgunova");
        $("#userEmail").setValue("darya.melgunova@mail.com");
        $("#currentAddress").setValue("Street 1");
        $("#permanentAddress").setValue("Street 2");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text("Darya Melgunova"));
        $("#output").$("#email").shouldHave(text("darya.melgunova@mail.com"));
        $("#output").$("#currentAddress").shouldHave(text("Street 1"));
        $("#output").$("#permanentAddress").shouldHave(text("Street 2"));
    }
}
