package PageObjects.ElementsPOM;

import Setup.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPOM extends PageObject {

    public ButtonsPOM(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickButton;

    @FindBy(id = "rightClickBtn")
    WebElement rightClickButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/button")
    WebElement leftClickButton;

    public void dupliKlik() {
        Actions duplo = new Actions(driver);
        duplo.doubleClick(doubleClickButton).perform();
    }

    public void leviKlik() {
        leftClickButton.click();
    }

    public void desniKlik() {
        Actions desno = new Actions(driver);
        desno.contextClick(rightClickButton).perform();

    }


}
