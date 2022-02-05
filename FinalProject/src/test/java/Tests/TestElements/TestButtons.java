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
    /**
     * Test case clicking on the clickable elements of a webpage:
     * 1.open the webpage assigned before methods - https://demoqa.com/buttons
     * 2.click on each element on the directed way, which is written on the element itself
     * (elements are buttons: one for a right-click, one for a double click and the third one for a left click)
     * 3.assert that the valid messages are displayed below the elements
     */

    @BeforeMethod
    public void openThePage() {
        driver.get("https://demoqa.com/buttons");
    }

    @Test
    public void kliktalicaDupla() {
        ButtonsPOM dugmad = new ButtonsPOM(driver);
        dugmad.dupliKlik();
        String porukaDuplogKlika = driver.findElement(By.id("doubleClickMessage")).getText();
        assertEquals(porukaDuplogKlika, "You have done a double click", "Not a double click");

    }

    @Test
    public void kliktalicaDesna() {
        ButtonsPOM dugmad = new ButtonsPOM(driver);
        dugmad.desniKlik();
        String porukaDesnogKlika = driver.findElement(By.id("rightClickMessage")).getText();
        assertEquals(porukaDesnogKlika, "You have done a right click", "Not a right click");
        System.out.println();
    }

    @Test
    public void kliktalicaLeva() {
        ButtonsPOM dugmad = new ButtonsPOM(driver);
        dugmad.leviKlik();
        String porukaDesnogKlika = driver.findElement(By.id("dynamicClickMessage")).getText();
        assertEquals(porukaDesnogKlika, "You have done a dynamic click", "Not a right click");
    }
}
