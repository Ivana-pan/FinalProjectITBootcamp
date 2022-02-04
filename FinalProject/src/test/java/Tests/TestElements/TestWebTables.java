package Tests.TestElements;

import PageObjects.ElementsPOM.WebTablesPOM;
import Setup.TestSetup;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestWebTables extends TestSetup {

    Faker faker;

    @DataProvider(name = "obezbedjivacImena")
    public Object[][] obezbedjivacImena() {
        faker = new Faker();

        return new Object[][]{
                {faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), String.valueOf(faker.number().numberBetween(21, 65)), String.valueOf(faker.number().numberBetween(50000, 250000)), faker.job().position()},
                {faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), String.valueOf(faker.number().numberBetween(21, 65)), String.valueOf(faker.number().numberBetween(50000, 250000)), faker.job().position()},
                {faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), String.valueOf(faker.number().numberBetween(21, 65)), String.valueOf(faker.number().numberBetween(50000, 250000)), faker.job().position()}
        };

    }

    @Test(dataProvider = "obezbedjivacImena")
    public void enteringNewEmployeeHappyPath(String name, String lastName, String mail, String oldage, String plata, String departman) {

        driver.get("https://demoqa.com/webtables");

        WebTablesPOM newAddition = new WebTablesPOM(driver);
        newAddition.clickToEnter();
        newAddition.enterName(name);
        newAddition.enterLastName(lastName);
        newAddition.enterEmail(mail);
        newAddition.enterAge(oldage);
        newAddition.enterSalary(plata);
        newAddition.enterDepartment(departman);
        newAddition.submit();

        String unosiInformacija = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]")).getText();
        assertTrue(unosiInformacija.contains(name) && unosiInformacija.contains(lastName) && unosiInformacija.contains(mail) && unosiInformacija.contains(departman), "Table doesn't contain the information entered");


    }
}
