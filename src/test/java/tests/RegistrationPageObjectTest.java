package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageObjectTest extends TestBase {
    @Test
    public void checkRegistrationTest() {
        String userName = "Big", lastName = "Wolf", emailField = "bbwolf@wuuuf.com", genderSelect = "Man", mobileNum = "0123456789", subjectsField = "Subjects", currentAddress = "10th Kingdom";

        // 1 Добавили из класса RegistrationPage
        registrationPage
                .openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setUserEmailInput(emailField)
                .setGenderInput(genderSelect)
                .setMobileNumber(mobileNum)
                .setBirthDate("11", "July", "2013");

        $("#subjectsInput").setValue(subjectsField).pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/some1.png");

        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", userName + "Wolf")
                .verifyResults("Student Email", "bbwolf@wuuuf.com")
                .verifyResults("Gender", "Man")
                .verifyResults("Mobile", "0123456789")
                .verifyResults("Date of Birth", "11 July,2013");

    }
    
}
