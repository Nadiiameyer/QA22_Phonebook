package com.ait.tests;

import com.ait.phonebook.model.Contact;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class AddContactTests extends TestBase {
    //precondition: 1. User is logged out, 2. log in
    //click on Add link
    @DataProvider
    public Iterator<Object[]> addNewContact(){

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"Oliver", "Kan", "987656858846", "nm1@qwe.com", "Cologne", "goalkeeper"});

        list.add(new Object[]{"Oliver", "Kan", "987656669966", "nm2@qwe.com", "Cologne", "goalkeeper"});

        list.add(new Object[]{"Oliver", "Kan", "9876564060746", "nm@qwe.com", "Cologne", "goalkeeper"});
        return list.listIterator();
    }
    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line= reader.readLine();
        while (line !=null){

       String[] split = line.split(",");

        list.add(new Object[]{new Contact().setName(split[0]).setSurename(split[1]).setPhone(split[2]).setEmail(split[3])
                .setAddress(split[4]).setDesc(split[5])});

        line = reader.readLine();
     return list.iterator();
    }
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getHeader().clickOnLoginLink();
            app.fillLoginRegForm(new User()
                    .setEmail("hellohello@world.com")
                    .setPassword("Hello12345@$!'"));
            app.clickOnLoginButton();
        }
    }

    @Test(dataProvider = "addNewContact")
    public void addContactPositiveTest(String name, String sureName,
                                       String phone,String email, String address, String desc) {

        app.getHeader().clickOnAddLink();

        app.getContact().addContact(new Contact().setName(name)
                .setSurename(sureName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDesc(desc));


        app.getContact().clickOnSaveButton();
        app.getContact().removeContact();
    }

}
    @Test(dataProvider = "addNewContactFromCSV")
    public void addContactPositiveFromCSVFileTest(Contact contact) {

        app.getHeader().clickOnAddLink();

        app.getContact().addContact(contact);


        app.getContact().clickOnSaveButton();
        app.getContact().removeContact();




    //fill add contact form
    //click on Save button
    //verify new contact is added


