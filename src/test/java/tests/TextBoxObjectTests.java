package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxObjectTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillformTest(){
        textBoxPage.openPage()
                .removeBanner()
                .setUserName("Darya")
                .setUserEmail("darya.melgunova@mail.com")
                .setCurrentAddress("Street 1")
                .setPermanentAddress("Street 2")
                .submit();

        textBoxPage.checkResult("Name:", "Darya");
        textBoxPage.checkResult("Email:", "darya.melgunova@mail.com");
        textBoxPage.checkResult("Current Address :", "Street 1");
        textBoxPage.checkResult("Permananet Address :", "Street 2");
    }

    }

