package Tests.TestElements;

import PageObjects.ElementsPOM.TextBoxPOM;
import Setup.TestSetup;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;


public class TestTextBox extends TestSetup {

    Faker faker;

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

    @Test(dataProvider = "ubacivacImenaPrezimenaImaila")
    public void enterPersonalInfoHappyPath(String imePrezime, String mail, String adresa) {
        driver.get("https://demoqa.com/text-box");
        TextBoxPOM persData = new TextBoxPOM(driver);
        persData.enteringData(imePrezime, mail, adresa, adresa);

        String unos = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[6]/div")).getText();
        assertTrue(unos.contains(imePrezime) && unos.contains(mail) && unos.contains(adresa), "Test failed");
    }

}
