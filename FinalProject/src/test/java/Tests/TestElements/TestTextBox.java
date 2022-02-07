package Tests.TestElements;

import PageObjects.ElementsPOM.TextBoxPOM;
import Setup.TestSetup;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;


public class TestTextBox extends TestSetup {


    @BeforeMethod
    public void fetchingThePage() {
        driver.get("https://demoqa.com/text-box");
    }

    @DataProvider(name = "ubacivacImenaPrezimenaImaila")
    public Object[][] nizPodataka() {

        return new Object[][]{
                {faker.name().fullName(), faker.internet().emailAddress(), faker.address().streetAddress()},
                {faker.name().fullName(), faker.internet().emailAddress(), faker.address().streetAddress()},
                {faker.name().fullName(), faker.internet().emailAddress(), faker.address().streetAddress()},
                {faker.name().fullName(), faker.internet().emailAddress(), faker.address().streetAddress()},
                {faker.name().fullName(), faker.internet().emailAddress(), faker.address().streetAddress()}
        };
    }

    /**
     * Test case enterPersonalInfoHappyPath
     * The test is done using the Data Provider, which is filled with fake data using the class Faker.
     * 1.open the page https://demoqa.com/text-box
     * 2.enter the required information, parameters are as follows: first and lastname (imePrezime),
     * email addres (mail) and home address (adresa), which actually doubles, since there is a field after this named
     * "current address", that doesn't alter the results in any way, even with an entry different from the address
     * entered previously,so this field is just a copy of the parameter 'adresa';
     * 3.click on the 'Submit' button;
     * 4. assert that the entered fields appear below, in a box, in the same way they were entered;
     *
     * @param imePrezime
     * @param mail
     * @param adresa,
     */

    @Test(dataProvider = "ubacivacImenaPrezimenaImaila")
    public void enterPersonalInfoHappyPath(String imePrezime, String mail, String adresa) {
        personalData.enteringData(imePrezime, mail, adresa, adresa);

        String unos = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[6]/div")).getText();
        assertTrue(unos.contains(imePrezime) && unos.contains(mail) && unos.contains(adresa), "Test failed");
    }

    /**
     * Test case enteringPersonalDataUnhappyPath:
     * 1. use Faker class to fill in the required data for the text box,which include full name, email address and
     * home address, respectfully;
     * 2.the email address is supposed to be invalid and do not consist '@' symbol or a full stop (.) symbol;
     * 3. click on the submit button;
     * 4. the process should not be finalized, and instead, the field for an email address should signalize an error
     * with the border of the element turning red;
     * 5. expected result: the element of email address turns red color, in the code marked as "solid red" with the code
     * #ff0000";
     * 6. actual result: the color of the border of the element of text box where an email address is supposed to be
     * entered is not, in fact solid red, but the system throws the test, and upon further investigation, the color
     * gotten through HEX is, in fact, very bright red; another anomaly is that the codes of the actual color vary in
     * several shades of red: #d9a3a7, #eb5658, #d3bfc4, #e27e82, which, upon detailed research of the border color,
     * zooming them to individual pixels, shows that these shades can be found on the curves of the border, or, rather,
     * its angles, where they are used to smoothen the curve of the border;
     */

    @Test
    public void enteringPersonalDataUnhappyPath() {
        personalData.enteringData(faker.name().firstName(), faker.funnyName().name(), faker.address().streetAddress(), "address");

        assertEquals(personalData.colorOfTheEmailWrongEntry(), "#ff0000", "The color of the border does not match");
        personalData.colorOfTheEmailWrongEntry();
    }

}
