package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MethodsForPOM {

    WebDriver driver;

    public MethodsForPOM(WebDriver driver) {
        this.driver = driver;
    }

    public void actionOfhover(WebElement element){
        Actions hover = new Actions(driver);
        hover.moveToElement(element).build().perform();
    }
}
