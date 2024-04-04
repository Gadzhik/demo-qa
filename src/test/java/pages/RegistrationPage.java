package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();

    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";

    // 2 Еще один метод выноса метода для универсальности
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userMobile = $("userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput");

    // 1 Вынесли из класса RegistrationTestsWithPageObjects
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    // 2
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmailInput(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGenderInput(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setMobileNumber(String value) {
        userMobile.setValue(value);

        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }
    public RegistrationPage verifyResults(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
}
// 1.12.00