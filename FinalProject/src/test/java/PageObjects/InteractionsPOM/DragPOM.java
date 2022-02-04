package PageObjects.InteractionsPOM;

import Setup.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragPOM extends PageObject {

    public DragPOM(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"dragBox\"]")
    WebElement dropBox;


    public void dragAndDropMethod(int xPixel, int yPixel) {
        Actions dragger = new Actions(driver);
        dragger.dragAndDropBy(dropBox, xPixel, yPixel).build().perform();
    }
}
