package Tests.TestInteractions;

import PageObjects.InteractionsPOM.DragPOM;
import Setup.TestSetup;
import org.testng.annotations.Test;

public class TestDrag extends TestSetup {

    @Test
    public void dragAndDropElement() throws InterruptedException {
        driver.get("https://demoqa.com/dragabble");
        DragPOM dropovanje = new DragPOM(driver);
        dropovanje.dragAndDropMethod(617, 255);
    }

}
