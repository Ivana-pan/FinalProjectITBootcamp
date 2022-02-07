package Tests.TestElements;

import PageObjects.ElementsPOM.WebTablesPOM;
import Setup.TestSetup;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestWebTables extends TestSetup {

    @BeforeClass
    public void OpeningTheWebPage() {
        driver.get("https://demoqa.com/webtables");
    }


    @DataProvider(name = "obezbedjivacImena")
    public Object[][] obezbedjivacImena() {

        return new Object[][]
                {{faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),String.valueOf(faker.number().numberBetween(21, 65)), String.valueOf(faker.number().numberBetween(50000, 250000)), faker.job().position()},
                {faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), String.valueOf(faker.number().numberBetween(21, 65)), String.valueOf(faker.number().numberBetween(50000, 250000)), faker.job().position()},
                {faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), String.valueOf(faker.number().numberBetween(21, 65)), String.valueOf(faker.number().numberBetween(50000, 250000)), faker.job().position()}};

    }

    /**
     * Test case enteringNewEmployeeHappyPath:
     * Using the Data Provider, the test enters several new entries using the 'add' button and fills in the required
     * information, subsequently adding new entries into the table;
     * 1. go to the web page 'https://demoqa.com/webtables'
     * 2. click on the 'add' button in the upper left corner;
     * 3. fill in the required fields with the parameters needed, which are first name, last name, email address, age,
     * salary, and the department; the test use data provider filled in with random fake information provided by Faker
     * class;
     * 4. click on the 'submit' button;
     * 5. assert that the correct info is shown in the table of information.
     *
     * @param name
     * @param lastName
     * @param mail
     * @param oldage
     * @param plata
     * @param departman
     */

    @Test(dataProvider = "obezbedjivacImena")
    public void enteringNewEmployeeHappyPath(String name, String lastName, String mail, String oldage, String plata, String departman) {

        newAddition.clickToEnter();
        newAddition.enterName(name);
        newAddition.enterLastName(lastName);
        newAddition.enterEmail(mail);
        newAddition.enterAge(oldage);
        newAddition.enterSalary(plata);
        newAddition.enterDepartment(departman);
        newAddition.submit();

        String unosiInformacija = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]")).getText();
        assertTrue(unosiInformacija.contains(name) && unosiInformacija.contains(lastName) && unosiInformacija.contains(mail) && unosiInformacija.contains(departman),
                "Table doesn't contain the information entered");

    }
}
