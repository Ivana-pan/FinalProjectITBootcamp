package PageObjects.ElementsPOM;

import Setup.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablesPOM extends PageObject {

    public WebTablesPOM(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNewRecordButton")
    WebElement addButton;

    @FindBy(id = "firstName")
    WebElement enterFirstName;

    @FindBy(id = "lastName")
    WebElement enterLastName;

    @FindBy(id = "userEmail")
    WebElement enterEmail;

    @FindBy(id = "age")
    WebElement enterAge;

    @FindBy(id = "salary")
    WebElement enterSalary;

    @FindBy(id = "department")
    WebElement enterDepartment;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(className = "mr-2")
    List<WebElement> polja;

    @FindBy(className = "rt-tr-group")
    List<WebElement> ispisPodataka;

    public List<WebElement> getPopunjenaPolja() {
        return polja;
    }

    public void ispisElemenata() {
        for (WebElement e : ispisPodataka) {
            String podaciOUnosu = e.getText();
            System.out.print(podaciOUnosu + " ");
            System.out.print(" ");
        }
    }


    @FindBy(id = "searchBox")
    WebElement searchBox;

    @FindBy(id = "basic-addon2")
    WebElement lupicaDugme;

    @FindBy(id = "delete-record")
    WebElement kanta;

    public void brisanjeElemenata(String prezime) {
        searchBox.click();
        searchBox.sendKeys(prezime);
        lupicaDugme.click();
        kanta.click();

    }

    public void clickToEnter() {
        addButton.click();
    }

    public void enterName(String ime) {
        enterFirstName.click();
        enterFirstName.sendKeys(ime);
    }

    public void enterLastName(String prezime) {
        enterLastName.click();
        enterLastName.sendKeys(prezime);
    }

    public void enterEmail(String email) {
        enterEmail.click();
        enterEmail.sendKeys(email);
    }

    public void enterAge(String age) {
        enterAge.click();
        enterAge.sendKeys(age);
    }

    public void enterSalary(String salary) {
        enterSalary.click();
        enterSalary.sendKeys(salary);
    }

    public void enterDepartment(String dept) {
        enterDepartment.click();
        enterDepartment.sendKeys(dept);
    }

    public void submit() {
        submitButton.click();
    }
}
