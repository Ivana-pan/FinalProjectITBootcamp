package PageObjects.FormsPOM;

import Setup.MethodsForPOM;
import Setup.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FormsPOM extends PageObject {

    MethodsForPOM methods;

    public FormsPOM(WebDriver driver) {
        super(driver);
        methods = new MethodsForPOM(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(className = "custom-control")
    List<WebElement> genders;

    @FindBy(id = "userNumber")
    WebElement phoneNumber;

    @FindBy(id = "dateOfBirthInput")
    WebElement dob;

    @FindBy(className = "react-datepicker__month-select")
    WebElement monthPicker;

    @FindBy(className = "react-datepicker__year-dropdown-container")
    WebElement yearPicker;

    @FindBy(className = "react-datepicker__day")
    List<WebElement> dayPick;

    @FindBy(className = "subjects-auto-complete__value-container")
    WebElement enterSubjects;

    @FindBy(className = "custom-checkbox")
    List<WebElement> hobbies;



    public void selectingGender(String pol){
        for (WebElement we : genders){
            if(!we.getText().equals("Male") && !we.getText().equals("Female") && !we.getText().equals("Other")){
                System.out.println("Try again, your gender does not exist YET!");
            }
            else if (we.getText().equals(pol)){
                we.click();
                return;
            }
        }
    }



}
