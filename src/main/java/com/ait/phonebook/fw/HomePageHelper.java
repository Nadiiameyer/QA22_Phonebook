package com.ait.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper{
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return ApplicationManager.driver.findElements(By.cssSelector("div:nth-child(2)>div>div")).size()>0;
    }

    public boolean isHomeComponentPresent2() {
        try {
            ApplicationManager.driver.findElement(By.cssSelector("div:nth-child(2)>div>div"));
            return true;
        }catch (org.openqa.selenium.NoSuchElementException ex) {
            return false;
        }
    }
}
