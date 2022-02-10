package Tests.TestBookStoreApplication;

import PageObjects.BookStoreApplicationPOM.LoginBookPOM;
import Setup.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TestAddBook extends TestSetup {

    @Test
    public void testAddBook() throws InterruptedException {
        driver.get("https://demoqa.com/login");
        LoginBookPOM registracija = new LoginBookPOM(driver);
        registracija.login();
        Thread.sleep(5000);
        registracija.goToBookstore();
        Thread.sleep(5000);
        registracija.inputBook();
        /*registracija.logOut();
        registracija.login();
        registracija.goToBookstore();
        registracija.inputBook();*/

        String tabela = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]")).getText();
        assertTrue(tabela.contains("Git"));
    }

    @Test
    public void deletingBooks() throws InterruptedException {
        driver.get("https://demoqa.com/login");
        LoginBookPOM registracija = new LoginBookPOM(driver);
        registracija.login();
        Thread.sleep(5000);
        registracija.deleteABook();
        Thread.sleep(5000);
        registracija.confirmDeleteBook();

        driver.get("https://demoqa.com/profile");

    }
}
