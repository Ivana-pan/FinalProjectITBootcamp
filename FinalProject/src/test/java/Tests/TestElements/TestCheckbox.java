package Tests.TestElements;

import PageObjects.ElementsPOM.CheckboxPOM;
import Setup.TestSetup;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import static org.testng.Assert.*;

//add unhappy path, verify only one checked/one unchecked, more checked, more unchecked boxes
public class TestCheckbox extends TestSetup {

    @BeforeMethod
    public void openThePage() {
        driver.get("https://demoqa.com/checkbox");
    }

    /**
     * Test case allBoxesAreSelected
     * 1.open the page 'https://demoqa.com/checkbox'
     * 2.assert that the checkboxes are all empty before attempting the test
     * 2.click/check the box of the folder "Home"
     * 3.click on the '+' button in the upper right corner to expand the list
     * 4.assert that all the folders and files are checked
     */

    @Test
    public void allBoxesAreSelected() throws InterruptedException {
        assertFalse(boxes.getUncheckedBoxes().isEmpty(), "Boxes are not empty a.k.a. not checked.");
        boxes.selectAllBoxes();
        assertTrue(boxes.getUncheckedBoxes().isEmpty(), "Boxes are checked");
    }

    /**
     * Test case selectingOneBoxWhichIsATypeFile
     * In this test, it was impossible to get the text of each element, so I opted for numerical values.
     * They are listed in the comment section in line ____ and stand for individual files of the checkboxes
     * 1. open the web page 'https://demoqa.com/checkbox'
     * *optionally, change the value/parameter of the "selectingOnlyCertainBox" method in line ___
     * 3. select the file
     * 4. assert that the number of half-selected ("-" symbol) folders in the path is correct, meaning it should be equal
     * the same as the number of folders leading up to the file selected (kind of the full path of a file),
     * and that the number of checked boxes is one (it should always be one, since only one file is selected);
     */

    @Test
    public void selectingOneBoxWhichIsATypeFile() {
        //options for selecting a file: 2, 3, 6, 7, 8, 10, 11, 12, 13, 15, 16
        int[] actualNiz = boxes.selectingOnlyCertainBox(2);
        Assert.assertTrue(Arrays.equals(actualNiz, new int[]{1, 2, 14}) || Arrays.equals(actualNiz, new int[]{1, 3, 13}), "Selected fiels are not files");
    }

    /**
     * Test case "selectingOneBoxWhichIsATypeFolder"
     * Similarly like in the previous test case, the folders are numbered, but there only five, so the assertion is in a switch loop
     * 1. open the page 'https://demoqa.com/checkbox'
     * *optionally changing the number of the file to be selected, between 1, 4, 5, 9 or 14;
     * 2. assert that the number of flies, folders and half-checked boxes is correct, indicating to the relative path
     * of the selected folder, including all of its files within.
     */

    @Test
    public void selectingOneBoxWhichIsATypeFolder() {
        //options for selecting a folder: 1, 4, 5, 9, 14
        int numberOfAFile = 5; // can be changed
        int[] actualNiz = boxes.selectingOnlyCertainBoxTypeFolder(numberOfAFile);
        switch (numberOfAFile) {
            case 1:
            case 14:
                assertTrue(Arrays.equals(actualNiz, new int[]{13, 3, 1}), "Parameter is not 1");
                break;
            case 4:
                assertTrue(Arrays.equals(actualNiz, new int[]{6, 10, 1}), "Parameter is not 4");
                break;
            case 5:
                assertTrue(Arrays.equals(actualNiz, new int[]{11, 4, 2}), "Parameter is not 1");
                break;
            case 9:
                assertTrue(Arrays.equals(actualNiz, new int[]{10, 5, 2}), "Parameter is not 1");
                break;
        }

    }
}
