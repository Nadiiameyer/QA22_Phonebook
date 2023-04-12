package com.ait.tests;

import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccontTests extends TestBase{

    // precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()){
            app.getHeader().clickOnSignOutButton();
        }
    }


    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        app.getHeader().clickOnLoginLink();
        Assert.assertTrue(app.getHeader().isLoginLinkPresent());

        app.fillLoginRegForm(new User()
                .setEmail("hellohello@world.com")
                .setPassword("Hello12345@$!'"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

}
