package Tests.TestForms;

import PageObjects.FormsPOM.FormsPOM;
import Setup.TestSetup;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TestPracticeForm extends TestSetup {

    @BeforeClass
    public void openingThePage(){
        driver.get("https://demoqa.com/automation-practice-form");
    }

    /**
     * Test case: entering required data to successfully submit a form;
     * <p>
     * Parameters are: name, last name, email, gender selection, mobile phone number, date of birth, hobbies,
     * picture, current address;
     * <p>
     * 1.open the link https://demoqa.com/automation-practice-form
     * 2.enter the parameters in the required fields
     * 3.click on the submit button
     * 4.assert that the message displayed is equal to the one expected
     */

    @Test
    public void fillingOutFormHappyPath() throws InterruptedException {

        person.enterNameandMail(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
        person.selectingGender("Female");
        person.addingPhoneNo("0987560398");
        person.addDateOfBirth("3", "1988");
        person.dayOfBirth("28");
        person.addSubjects("E");
        person.selectHobbies("Music");
        person.submitAPhoto();
        person.addCurrentAddress(faker.address().streetAddress());
        person.submit();
        assertTrue(person.assertionMessage.isDisplayed());

    }
}
