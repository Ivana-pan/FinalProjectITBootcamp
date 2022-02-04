package Tests.TestForms;

import PageObjects.FormsPOM.FormsPOM;
import Setup.TestSetup;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestPracticeForm extends TestSetup {

    @Test
    public void selectingGender(){
        driver.get("https://demoqa.com/automation-practice-form");
        FormsPOM gender = new FormsPOM(driver);


        gender.selectingGender("Female");
    }
}
