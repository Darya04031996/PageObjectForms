package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxObjectTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillformTest(){
        textBoxPage.openPage()
                .setUserName("Darya Melgunova")
                .setUserEmail("darya.melgunova@mail.com")
                .setCurrentAddress("Street 1")
                .setPermanentAddress("Street 2")
                .submit();

        textBoxPage.checkResult("Darya Melgunova");
        .checkResult("darya.melgunova@mail.com");
        .checkResult("Street 1");
        .checkResult("Street 2");
    }

    }

