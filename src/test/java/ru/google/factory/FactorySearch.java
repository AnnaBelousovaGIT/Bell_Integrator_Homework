package ru.google.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class FactorySearch {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@title=\"Поиск\"]")
    WebElement inputField;

    @FindAll(@FindBy(how = How.XPATH, using = "//*[@href=\"https://ru.wikipedia.org/wiki/%D0%A8%D0%BF%D0%B0%D0%B6%D0%BD%D0%B8%D0%BA\"]"))
    List<WebElement> gladiolus;

    public FactorySearch(WebDriver driver){
        this.driver=driver;
    }

    public void findElem(String key) {
        inputField.click();
        inputField.sendKeys(key);
        inputField.submit();
    }

    public List<WebElement> getGladiolus() {
        return gladiolus;
    }
}


