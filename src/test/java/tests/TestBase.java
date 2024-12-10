package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.TextBoxPage;

public class TestBase {
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

    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "920x920";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
