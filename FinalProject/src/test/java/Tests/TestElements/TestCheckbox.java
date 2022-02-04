package Tests.TestElements;

import PageObjects.ElementsPOM.CheckboxPOM;
import Setup.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestCheckbox extends TestSetup {

    @Test
    public void selectigAllBoxes() {
        driver.get("https://demoqa.com/checkbox");
        CheckboxPOM boxes = new CheckboxPOM(driver);
        boxes.selectAllBoxes();

        String centralPage = driver.findElement(By.id("result")).getText();
        assertTrue(centralPage.contains("You have selected :"+"home" +"desktop" +"notes" +"commands"+"documents" +
                "workspace" +"react" +"angular" +"veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile"), "Not all boxes are selected.");
    }

    @Test
    public void allBoxesAreSelected(){
        driver.get("https://demoqa.com/checkbox");
        CheckboxPOM boxes = new CheckboxPOM(driver);
        assertFalse(boxes.getUncheckedBoxes().isEmpty(), "Boxes are not empty a.k.a. not checked.");
        boxes.selectAllBoxes();
        assertTrue(boxes.getUncheckedBoxes().isEmpty(),"Boxes are checked");
    }

}
