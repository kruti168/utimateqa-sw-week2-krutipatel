package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl ="https://courses.ultimateqa.com/";
    @Before
    public void setup(){
        openBrowser(baseUrl);

    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //Click on Sign in linke
        WebElement signInButton = driver.findElement(By.xpath("//a[@href='/users/sign_in']"));
        signInButton.click();

        //Verify Welcome Back
        String expecedMessage = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expecedMessage,actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){

        //Click on Sign in link
        WebElement signInLink= driver.findElement(By.xpath("//a[@href='/users/sign_in']"));
        signInLink.click();

       //Find the email in email field element
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("kruti@gmail.com");

        //Find password field and enter password
        WebElement password = driver.findElement(By.id("user[password]"));
        password.sendKeys("kruti123");

        //Click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        //Verify the error messege 'Invalid email or password
        String expectedMessage = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @After
    public void close(){

        driver.close();
    }

}
