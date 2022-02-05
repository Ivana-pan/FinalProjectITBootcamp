package Tests.TestElements;

import PageObjects.ElementsPOM.CheckboxPOM;
import Setup.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

//add unhappy path, verify only one checked/one unchecked, more checked, more unchecked boxes
public class TestCheckbox extends TestSetup {

    @Test
    public void allBoxesAreSelected(){
        driver.get("https://demoqa.com/checkbox");
        CheckboxPOM boxes = new CheckboxPOM(driver);
        assertFalse(boxes.getUncheckedBoxes().isEmpty(), "Boxes are not empty a.k.a. not checked.");
        boxes.selectAllBoxes();
        assertTrue(boxes.getUncheckedBoxes().isEmpty(),"Boxes are checked");
    }

    @Test
    public void listOfAllTheEmptyBoxes(){
        driver.get("https://demoqa.com/checkbox");
        CheckboxPOM boxes = new CheckboxPOM(driver);
        int[] actualNiz = boxes.selectingOnlyCertainBoxes(3);
        Assert.assertEquals(actualNiz,new int[]{14,1,2},"Nizovi nisu jednaki");
    }
}
