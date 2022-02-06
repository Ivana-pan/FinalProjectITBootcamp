package PageObjects.ElementsPOM;

import Setup.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;



public class TextBoxPOM extends PageObject {

    public TextBoxPOM(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "userName")
    WebElement userNameAndLastname;

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "currentAddress")
    WebElement address;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement submitButton;


    public void enteringData(String firstandlastName, String mail, String homeAddress, String permAddress) {
        userNameAndLastname.sendKeys(firstandlastName);
        email.sendKeys(mail);
        address.sendKeys(homeAddress);
        permanentAddress.sendKeys(permAddress);
        submitButton.click();
    }

    public String colorOfTheEmailWrongEntry(){
        String errorBoxBorder = email.getCssValue("border-color");
        String hex = Color.fromString(errorBoxBorder).asHex();
        System.out.println(hex);
        return hex;
    }

}
