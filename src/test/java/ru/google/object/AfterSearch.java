package ru.google.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AfterSearch extends BeforeSearch{

    List <WebElement> gladiolus;


    public AfterSearch(WebDriver driver) {
        super(driver);
        gladiolus = driver.findElements(By.xpath("//*[@href=\"https://ru.wikipedia.org/wiki/%D0%A8%D0%BF%D0%B0%D0%B6%D0%BD%D0%B8%D0%BA\"]"));
    }

    public List<WebElement> getGladiolus() {
        return gladiolus;

    }
}
