package ru.google.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BeforeSearch {
    protected WebDriver driver;
    private WebElement inputField;


    public BeforeSearch(WebDriver driver){
        this.driver=driver;
        this.inputField = driver.findElement(By.xpath("//input[@title=\"Поиск\"]"));
    }

    public void findElem(String key){
        inputField.click();
        inputField.sendKeys(key);
        inputField.submit();
    }


}


