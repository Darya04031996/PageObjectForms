package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.OutputComponents;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage extends TestBase {
    private final SelenideElement fullNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");

    OutputComponents outputComponents = new OutputComponents();
    private String value;

    public TextBoxPage openPage() {
        open("/text-box");
        return null;
    }
    public TextBoxPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public TextBoxPage setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
        return this;
    }

    public void submit() {
        $("#submit").click();
    }

    public TextBoxPage checkResult(String key) {
        OutputComponents.checkOutputResult(key, value);
        return this;

    }


}
