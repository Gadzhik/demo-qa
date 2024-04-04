package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.module.Configuration.*;

public class RegistrationTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void checkRegistrationTest() {
        String userName = "Groot";
        String lastName = "Wolf";
        String emailField = "bbwolf@wuuuf.com";
        String mobileNum = "0123456789";
        String subjectsField = "Subjects";
        String currentAddress = "10th Kingdom";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(emailField);
//        $("#gender-radio-1").click(); // wrong
//        $("#gender-radio-1").parent().click(); // good
//        $(byText("Man")).click(); // not very good
        $("#genterWrwpper").$(byText("Man")).click(); //best
//        $("label[for=gender-radio-1]").click(); // good
        $("userNumber").setValue(mobileNum);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
//        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOption("2013");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $x("//*[@class='react-datepicker__day--030'][not(contains(@class, 'react-datepicker__day--outside-month'))]").click();
        $("#subjectsInput").setValue(subjectsField).pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/some1.png");
//        $("#uploadPicture").uploadFile(new File("src/resources/img/some1.png"));
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Big Bad"), text("bbwolf@wuuuf.com"), text("0123456789"));

    }



}
