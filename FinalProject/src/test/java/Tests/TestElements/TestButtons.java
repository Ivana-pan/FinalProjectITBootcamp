package Tests.TestElements;

import PageObjects.ElementsPOM.ButtonsPOM;
import Setup.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestButtons extends TestSetup {


    @Test
    public void kliktalicaDupla() {
        driver.get("https://demoqa.com/buttons");
        ButtonsPOM dugmad = new ButtonsPOM(driver);
        dugmad.dupliKlik();
        String porukaDuplogKlika = driver.findElement(By.id("doubleClickMessage")).getText();
        assertEquals(porukaDuplogKlika, "You have done a double click", "Not a double click");

    }

    @Test
    public void kliktalicaDesna() {
        driver.get("https://demoqa.com/buttons");
        ButtonsPOM dugmad = new ButtonsPOM(driver);
        dugmad.desniKlik();
        String porukaDesnogKlika = driver.findElement(By.id("rightClickMessage")).getText();
        assertEquals(porukaDesnogKlika, "You have done a right click", "Not a right click");
        System.out.println();
    }

    @Test
    public void kliktalicaLeva() {
        driver.get("https://demoqa.com/buttons");
        ButtonsPOM dugmad = new ButtonsPOM(driver);
        dugmad.leviKlik();
        String porukaDesnogKlika = driver.findElement(By.id("dynamicClickMessage")).getText();
        assertEquals(porukaDesnogKlika, "You have done a dynamic click", "Not a right click");
    }
}
