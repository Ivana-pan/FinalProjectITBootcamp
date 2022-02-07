package Setup;

import PageObjects.ElementsPOM.CheckboxPOM;
import PageObjects.ElementsPOM.TextBoxPOM;
import PageObjects.ElementsPOM.WebTablesPOM;
import PageObjects.FormsPOM.FormsPOM;
import PageObjects.InteractionsPOM.DragPOM;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;


public class TestSetup {

    protected static WebDriver driver;
    protected static Faker faker;
    protected static TextBoxPOM personalData;
    protected static WebTablesPOM newAddition;
    protected static CheckboxPOM boxes;
    protected static FormsPOM person;
    protected static DragPOM dropovanje;


    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //objects
        faker = new Faker();
        personalData = new TextBoxPOM(driver);
        newAddition = new WebTablesPOM(driver);
        boxes = new CheckboxPOM(driver);
        person = new FormsPOM(driver);
        dropovanje = new DragPOM(driver);

    }


    @AfterClass
    public static void tearDown() {
        driver.close();
        driver.quit();

    }

}

