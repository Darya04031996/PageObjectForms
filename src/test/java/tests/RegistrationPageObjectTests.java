package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.TestBase;


public class RegistrationPageObjectTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillAllFieldsTest() {
        registrationPage.openPage()
                .setFirstName("Darya")
                .setLastName("Melgunova")
                .setEmail("darya.melgunova@gmail.com")
                .setGender("Female")
                .setNumber("8999543121")
                .setDateOfBirth("04", "March", "1996")
                .setSubjects("Computer Science")
                .setHobbies("Music")
                .setImagePath("380x240.jfif")
                .setAddress("Street1")
                .setState("NCR")
                .setCity("Delhi")
                .submit();

        registrationPage.openPage()
                .checkResult("Student Name", "Darya Melgunova")
                .checkResult("Student Email", "darya.melgunova@gmail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8999543121")
                .checkResult("Date of Birth", "04 March,1996")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "80x240.jfif")
                .checkResult("Address", "Street1")
                .checkResult("State and City", "NCR Delhi");
    }
    @Test
    void incompleteDates() {
        registrationPage.openPage()
                .setFirstName("Darya")
                .setLastName("Melgunova")
                .setEmail("darya.melgunova@gmail.com")
                .setGender("Female")
                .setNumber("8999543121")
                .setDateOfBirth("04", "March", "1996")
                .submit()

                .checkResult("Student Name", "Darya Melgunova")
                .checkResult("Student Email", "darya.melgunova@gmail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8999543121")
                .checkResult("Date of Birth", "04 March,1996");
    }
    @Test
    void inccorectDates() {
        registrationPage.openPage()
                .setFirstName("Darya")
                .setLastName("Melgunova")
                .setEmail("darya.melgunova@gmail.com")
                .setGender("Female")
                .setNumber("ththtrhthr")
                .setDateOfBirth("04", "March", "1996")
                .submit()
                .verifyUserNumberFieldIsRed();
    }
}