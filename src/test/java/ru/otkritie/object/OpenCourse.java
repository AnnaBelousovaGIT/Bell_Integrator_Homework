package ru.otkritie.object;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCourse {
    protected WebDriver driver;

    public OpenCourse(WebDriver driver) { this.driver = driver; }

    public void openLink(WebDriver driver) {
        driver.findElement(By.xpath("//*[@href=\"https://www.open.ru/\"]")).click();
        //переход на новую вкладку
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }

    public boolean compareDollarCourse() {

        double dollarSale = Double.parseDouble(driver.findElement(By.xpath("//tbody/tr[2]/td[2]/div/span")).getText().replace(",", "."));
        double dollarBuy = Double.parseDouble(driver.findElement(By.xpath("//tbody/tr[2]/td[4]/div/span")).getText().replace(",", "."));

        if (dollarSale < dollarBuy){return true;}  else {return false;}

    }

}