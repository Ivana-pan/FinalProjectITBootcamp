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

    @FindBy(className = "rct-icon-half-check")
    List<WebElement> halfCheckedBoxes;

    public List<WebElement> getCheckedBoxes() {
        return checkedBoxes;
    }

    public List<WebElement> getUncheckedBoxes() {
        return uncheckedBoxes;
    }

    public List<WebElement> getHalfCheckedBoxes() {
        return halfCheckedBoxes;
    }

    public void selectAllBoxes() {
        selectAll.click();
        expandButton.click();
    }
    //-----------------one by one arrow selection

    public int[] selectingOnlyCertainBox(int numberOfTheFileDesired) {
        expandButton.click();
        //System.out.println(uncheckedBoxes.size());
        for (int i = 0; i < uncheckedBoxes.size(); i++) {
            uncheckedBoxes.get(numberOfTheFileDesired).click();
            break;
        }
        switch (numberOfTheFileDesired) {
            case 2:
            case 3:
            case 15:
            case 16:
                //14e,1s,2h
                return new int[]{checkedBoxes.size(), halfCheckedBoxes.size(), uncheckedBoxes.size()};
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
                //13e ,1s, 3h
                return new int[]{checkedBoxes.size(), halfCheckedBoxes.size(), uncheckedBoxes.size()};
        }
        return new int[0];
    }

    public int[] selectingOnlyCertainBoxTypeFolder(int numberOfTheFileDesired) {
        expandButton.click();
        //System.out.println(uncheckedBoxes.size());
        for (int i = 0; i < uncheckedBoxes.size(); i++) {
            uncheckedBoxes.get(numberOfTheFileDesired).click();
            break;
        }
        switch (numberOfTheFileDesired) {
            case 1:
                //13,3,1
                return new int[]{uncheckedBoxes.size(), checkedBoxes.size(), halfCheckedBoxes.size()};
            case 4:
                //6,10,1
                return new int[]{uncheckedBoxes.size(), checkedBoxes.size(), halfCheckedBoxes.size()};
            case 5:
                //11,4,2
                return new int[]{uncheckedBoxes.size(), checkedBoxes.size(), halfCheckedBoxes.size()};
            case 9:
                //10,5,2
                return new int[]{uncheckedBoxes.size(), checkedBoxes.size(), halfCheckedBoxes.size()};
            case 14:
                //13,3,1
                return new int[]{uncheckedBoxes.size(), checkedBoxes.size(), halfCheckedBoxes.size()};


        }
        return new int[0];
    }


}
