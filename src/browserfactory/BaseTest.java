package browserfactory;
/**BaseUrl = https://courses.ultimateqa.com/
 1. Create the package ‘browserfactory’ and create the
 class with the name ‘BaseTest’ inside the
 ‘browserfactory’ package. And write the browser setup
 code inside the class ‘Base Test’.
 2. Create the package ‘testsuite’ and create the
 following class inside the ‘testsuite’ package.

 1. LoginTest

 3. Write down the following test into ‘LoginTest’ class

 1. userShouldNavigateToLoginPageSuccessfully

 * click on the ‘Sign In’ link
 * Verify the text ‘Welcome Back!’

 2. verifyTheErrorMessage

 * click on the ‘Sign In’ link
 * Enter invalid username
 * Enter invalid password
 * Click on Login button
 * Verify the error message ‘Invalid email**/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {

        driver = new ChromeDriver();

        //launch thr URl
        driver.get(baseUrl);

        //Maximise window
        driver.manage().window().maximize();

        //Implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        //Browser close
        driver.quit();
    }
}
