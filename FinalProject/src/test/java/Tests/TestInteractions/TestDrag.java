package Tests.TestInteractions;

import PageObjects.InteractionsPOM.DragPOM;
import Setup.TestSetup;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestDrag extends TestSetup {

    @BeforeClass
    public void openingThePage(){
        driver.get("https://demoqa.com/dragabble");
    }

    /**
     * Test case dragAndDropElement:
     * 1. open the page https://demoqa.com/dragabble
     * 2. click on the element with the title "drag me" on it and hold it with the left click on the mouse
     * 3. while holding it, drag it across the screen
     * 4. drop it on the entered pixels position, the first one being the x-axis, and the second one the y-axis;
     * 5. assert that the given coordinates are correct;
     * @throws InterruptedException
     */

    @Test
    public void dragAndDropElement() throws InterruptedException {
        dropovanje.dragAndDropMethod(1133, 549);
        Point box = dropovanje.getDropBox().getLocation();
        int xAxis = box.getX();
        System.out.println(xAxis);
        int yAxis = box.getY();
        System.out.println(yAxis);
        
    }

}
