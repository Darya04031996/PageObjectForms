package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationTests extends TestBase {
    String firstName = "Darya";
    String lastName = "Melgunova";
    String userEmail ="darya.melgunova@gmail.com";
    String genterWrapper = "Female";
    String userNumber ="8999543121";
    String monthOfBirth = "March";
    String yearOfBirth = "1996";
    String dayOfBirth = "04";
    String subject = "Computer Science";
    String hobby = "Music";
    String pictureFileName = "380x240.jfif";
    String address = "Street1, City2, Country3";
    String state = "NCR";
    String city = "Delhi";


    @Test
   void fillFormTest() {
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText(monthOfBirth);
        $(".react-datepicker__year-select").selectOptionByValue(yearOfBirth);
        $(".react-datepicker__day.react-datepicker__day--0" + dayOfBirth).click();

        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(pictureFileName);
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();


        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Darya Melgunova"));
   $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("darya.melgunova@gmail.com"));
   $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
   $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("8999543121"));
   $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("04 March,1996"));
   $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Computer Science"));
   $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Music"));
   $(".table").shouldHave(text("Picture")).shouldHave(text("380x240.jfif"));
   $(".table").$(byText("Address")).sibling(0).shouldHave(text("Street1"));
   $(".table").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));

}
}

