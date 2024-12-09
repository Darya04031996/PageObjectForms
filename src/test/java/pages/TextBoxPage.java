package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.TableComponent;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxPage {
    private final SelenideElement userNameInput = $("#userName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement permanentAddressInput = $("#permanentAddress");
    SelenideElement submitPress = $("#submit");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }
    public TextBoxPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);
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

    public TextBoxPage submit() {
        submitPress.click();
        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        $("#output").$(byText(key)).shouldHave(text(value));
        return this;
    }

}
