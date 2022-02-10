package PageObjects.BookStoreApplicationPOM;

import Setup.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginBookPOM extends PageObject {


    public LoginBookPOM(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstname")
    WebElement fName;

    @FindBy(id = "lastname")
    WebElement lName;

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement pswrd;

    @FindBy(className = "recaptcha-checkbox-border")
    WebElement captchaRobot;

    @FindBy(id = "register")
    WebElement registrationButton;

    public void registration(String ime,String prezime,String user) {
        fName.sendKeys(ime);
        lName.sendKeys(prezime);
        userName.sendKeys(user);
        pswrd.sendKeys("Ana+Milovan<3!");
    }

    public void captchaClick() throws InterruptedException {
        captchaRobot.click();
        Thread.sleep(15000);
    }
    /*public void confirmRegistration(){
        registrationButton.click();
    }*/
    //-----------------------------login--------------------------------------------------

    @FindBy(xpath = "//input[@id='userName']")
    WebElement uNameLogin;

    @FindBy(xpath = "//input[@id='password']")
    WebElement pswrdLogin;

    @FindBy(xpath = "//button[@id='login']")
    WebElement loginButton;

    public void login(){
        uNameLogin.sendKeys("Milovanka");
        pswrdLogin.sendKeys("Ana+Milovan<3!");
        loginButton.click();
    }


    @FindBy(id = "gotoStore")
    WebElement goToStoreButton;

    public void goToBookstore(){
        goToStoreButton.click();
    }

    //--------------------inputting a book-------------------------------------------

    @FindBy(xpath = "//input[@id='searchBox']")
    WebElement searchBox;

    @FindBy(xpath = "//a[contains(text(),'Git Pocket Guide')]")
    WebElement linkToBook;

    @FindBy(xpath = "//button[contains(text(),'Add To Your Collection')]")
    WebElement addToCollectionButton;

    public void inputBook(){
        searchBox.click();
        searchBox.sendKeys("Git");
        linkToBook.click();
        addToCollectionButton.click();
    }

    public void inputBook2(){
        searchBox.click();
        searchBox.sendKeys("Learning Java");
        linkToBook.click();
        addToCollectionButton.click();
    }

    public void inputBook3(){
        searchBox.click();
        searchBox.sendKeys("Eloquent Java");
        linkToBook.click();
        addToCollectionButton.click();
    }
    @FindBy(xpath = "//button[@id='submit']")
    WebElement logOutButton;

    public void logOut(){
        logOutButton.click();
    }

    //--------------------------deleting a book-------------------------------------------------

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[5]/div/span")
    WebElement kanta;

    public void deleteABook(){
        kanta.click();
    }
    @FindBy(xpath = "//button[@id='closeSmallModal-ok']")
    WebElement okDelete;

    public void confirmDeleteBook(){
        okDelete.click();
    }
    //-----------------------------deleting all books------------------------------

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[3]/button[1]")
    WebElement deleteAllButton;

    public void deletingAllBooksFromTheLibrary(){
        deleteAllButton.click();
    }
}
