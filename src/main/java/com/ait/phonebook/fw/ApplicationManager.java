package com.ait.phonebook.fw;

import com.ait.phonebook.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ApplicationManager extends HomePageHelper {
static WebDriver driver;
UserHelper user;
ContactHelper contact;
HeaderHelper header;
HomePageHelper home;

    public ApplicationManager() {
        super(driver);
    }

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public HomePageHelper getHome() {
        return home;
    }

    public ApplicationManager(UserHelper user) {
        super(driver);
    }

    public ApplicationManager(HomePageHelper home) {
     super(driver);
    }

    public ApplicationManager(WebDriver driver, HeaderHelper header) {
        super(driver);
        this.header = header;
    }

    public void init() {
        System.err.close();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://telranedu.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        header=new HeaderHelper(driver);
        home = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[contains(.,'Login')]"));
    }

    public void fillLoginRegForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

}
