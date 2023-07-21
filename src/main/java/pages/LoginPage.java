package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
    private final WebDriver driver;
    private final By userNameTxt = By.name("username");
    private final By passwordTxt = By.name("password");
    private final By loginButton = By.xpath("//*[@id=\"loginButton\"]");
    private final By logoutButton = By.xpath("//*[@class=\"nav-item logout\"]");
    private final By selectField = By.xpath("//*[@id=\"Inpatient Ward\"]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userName) {
        driver.findElement(userNameTxt).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

    public SecureAreaPage clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return new SecureAreaPage(driver);
    }

    public WebElement getElementById(String elementId) {
        return driver.findElement(By.xpath("//*[@id=\""+elementId+"\"]"));
    }

    
    public void pressEnterKey() {
        driver.findElement(passwordTxt).sendKeys(Keys.ENTER);
    }

    public void clickSelectField() {
        driver.findElement(selectField).click();
    }

    public void pressTab() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
    }

    public void pressBack() {
        driver.navigate().back();
    }
}
