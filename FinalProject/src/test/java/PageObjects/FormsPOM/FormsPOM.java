package PageObjects.FormsPOM;

import Setup.MethodsForPOM;
import Setup.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.List;

public class FormsPOM extends PageObject {
    /**
     *
     */

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
    public WebElement dob;

    @FindBy(className = "react-datepicker__month-dropdown-container")
    WebElement monthDropDown;

    @FindBy(className = "react-datepicker__month-select")
    WebElement monthPicker;

    @FindBy(className = "react-datepicker__year-dropdown-container")
    WebElement yearDropDown;

    @FindBy(className = "react-datepicker__year-select")
    WebElement yearPicker;

    @FindBy(className = "react-datepicker__day")
    List<WebElement> dayPick;

    @FindBy(className = "subjects-auto-complete__value-container--is-multi")
    List<WebElement> subjects;

    @FindBy(className = "custom-control-label")
    List<WebElement> hobbies;

    @FindBy(id = "uploadPicture")
    WebElement uploadPictureButton; //send Keys - src/main/java/Pic

    @FindBy(id = "currentAddress")
    WebElement address;

    @FindBy(id = "state")
    WebElement selectState;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement assertionMessage;


    public void enterNameandMail(String fname, String lname, String mail) {
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        email.sendKeys(mail);
    }

    public void selectingGender(String pol) {
        for (WebElement we : genders) {
            if (!we.getText().equals("Male") && !we.getText().equals("Female") && !we.getText().equals("Other")) {
                System.out.println("Try again, your gender does not exist YET!");
            } else if (we.getText().equals(pol)) {
                we.click();
                return;
            }
        }
    }

    public void addingPhoneNo(String num) {
        phoneNumber.sendKeys(num);
    }

    public void addDateOfBirth(String month, String year) throws InterruptedException {
        dob.click();
        monthDropDown.click();
        Select selectmonth = new Select(monthPicker);
        selectmonth.selectByValue(month);
        yearDropDown.click();
        Select selectYear = new Select(yearPicker);
        selectYear.selectByValue(year);
    }

    public void dayOfBirth(String day) {
        for (WebElement we : dayPick) {
            if (we.getText().equals(day)) {
                we.click();
                return;
            }
        }
    }

    public void addSubjects(String subject) {

        for (WebElement sub : subjects){
            if (subject.equals(sub.getText())){
                sub.click();
            }
        }
    }

    public void selectHobbies(String hobby){
        for (WebElement we : hobbies){
            if (we.getText().equals(hobby)){
                we.click();
            }
        }
    }

    public void submitAPhoto(){
        //uploadPictureButton.click();
        uploadPictureButton.sendKeys("D:\\QA\\Java Final Project\\FinalProject\\src\\main\\java\\Pic\\del.jpg");
    }

    public void addCurrentAddress(String adr){
        address.sendKeys(adr);
    }

    public void addStateAndCity(){
        selectState.click();
        selectState.sendKeys("Haryana");
        //city.click();
        city.sendKeys("Karnal");
    }

    public void submit(){
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("arguments[0].scrollIntoView();", submitButton);
        submitButton.click();
    }

}
