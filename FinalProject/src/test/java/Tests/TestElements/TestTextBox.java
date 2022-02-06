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

    Faker faker;

    @BeforeMethod
    public void fetchingThePage(){
        driver.get("https://demoqa.com/text-box");
    }

    @DataProvider(name = "ubacivacImenaPrezimenaImaila")
    public Object[][] nizPodataka() {
        faker = new Faker();
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
     * 2.
     * @param imePrezime
     * @param mail
     * @param adresa
     */

    @Test(dataProvider = "ubacivacImenaPrezimenaImaila")
    public void enterPersonalInfoHappyPath(String imePrezime, String mail, String adresa) {
        personalData.enteringData(imePrezime, mail, adresa, adresa);

        String unos = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[6]/div")).getText();
        assertTrue(unos.contains(imePrezime) && unos.contains(mail) && unos.contains(adresa), "Test failed");
    }

    @Test
    public void enteringPersonalDataUnhappyPath(){
        personalData.enteringData("Name", "babauga", "address", "address");

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(personalData.colorOfTheEmailWrongEntry(),"#ff0000", "The color of the border does not match");
        personalData.colorOfTheEmailWrongEntry();
    }

}
