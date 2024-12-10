package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static utils.RandomUtils.getRandomString;

public class RegistrationWithRandomUtilsTests extends TestBase {

    @Test
    void fillFormTest() {


        String firstName = getRandomString (10);
        String lastName = getRandomString (10);
        String userEmail = getRandomString (10);
        String genterWrapper = "Female";
        String userNumber = getRandomString (10);
        String monthOfBirth = "March";
        String yearOfBirth = "1996";
        String dayOfBirth = "04";
        String subject = "Computer Science";
        String hobby = "Music";
        String pictureFileName = "380x240.jfif";
        String address = getRandomString (10);
        String state = "NCR";
        String city = "Delhi";

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

        // Проверяем данные
        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text(firstName + " " + lastName));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text(userEmail));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text(genterWrapper));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text(userNumber));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text(subject));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text(hobby));
        $(".table").shouldHave(text("Picture")).shouldHave(text(pictureFileName));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text(address));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text(state + " " + city));
    }
}

