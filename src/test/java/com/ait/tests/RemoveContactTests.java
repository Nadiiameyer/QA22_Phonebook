package com.ait.tests;

import com.ait.phonebook.fw.ApplicationManager;
import com.ait.phonebook.model.Contact;
import com.ait.phonebook.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    //precondition: 1. Verify User is log out, 2. log in, 3. add contact

    //click on Card

    //click on Remove button

    //verify contact is removed

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getHeader().clickOnLoginLink();
            app.fillLoginRegForm(new User()
                    .setEmail("hellohello@world.com")
                    .setPassword("Hello12345@$!'"));
            app.clickOnLoginButton();

            app.getHeader().clickOnAddLink();

            app.getContact().addContact(new Contact().setName("Karl")
                    .setSurename("Adam")
                    .setPhone("7583494595")
                    .setEmail("edamame@com")
                    .setAddress("Koblenz")
                    .setDesc("torwart"));


            app.getContact().clickOnSaveButton();
        }
    }


    @Test
    public void removeContactTest(){
        int sizeBefore = app.getContact().sizeOfContacts();
        System.out.println(sizeBefore);

        app.getContact().removeContact();
        pause(1000);
        int sizeAfter=app.getContact().sizeOfContacts();
        System.out.println(sizeAfter);
        Assert.assertEquals(sizeBefore-sizeAfter,1);
    }


    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
