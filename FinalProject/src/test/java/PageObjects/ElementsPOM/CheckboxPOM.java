package PageObjects.ElementsPOM;

import Setup.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxPOM extends PageObject {

    public CheckboxPOM(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/span[1]/label[1]/span[1]/*[1]")
    WebElement selectAll;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]/*[1]")
    WebElement expandButton;

    @FindBy(className = "rct-icon-uncheck")
    List<WebElement> uncheckedBoxes;

    @FindBy(className = "rct-icon-check")
    List<WebElement> checkedBoxes;

    public List<WebElement> getCheckedBoxes() {
        return checkedBoxes;
    }

    public List<WebElement> getUncheckedBoxes() {
        return uncheckedBoxes;
    }

    public void selectAllBoxes() {
        selectAll.click();
        expandButton.click();
    }


}
