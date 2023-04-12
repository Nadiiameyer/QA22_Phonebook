package com.ait.tests;

import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test
    public void newUserRegistrationPositiveTest() {
        app.getHeader().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        app.fillLoginRegForm(new User()
                .setEmail("hellohello@world.com")
                .setPassword("Hello12345@$!'"));
        app.clickOnLoginButton();

        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test(priority = 2)
    public void newUserRegistrationNegativeTest() {
        app.getHeader().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        app.fillLoginRegForm(new User()
                .setEmail("hellohello@world.com")
                .setPassword("Hello12345@'"));
        app.clickOnLoginButton();

        Assert.assertTrue(app.isAlertPresent());
    }

}
