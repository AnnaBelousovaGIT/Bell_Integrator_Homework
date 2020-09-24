package ru.otkritie.object;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCourse {
    protected WebDriver driver;
    protected WebElement inputField;

    public OpenCourse(WebDriver driver) {
        this.driver = driver;
        this.inputField = driver.findElement(By.xpath("//input[@title=\"Поиск\"]"));

    }

    public void findOpen(String key) {
        inputField.click();
        inputField.sendKeys(key);
        inputField.submit();

    }

    public void openLink(WebDriver driver) {
        driver.findElement(By.xpath("//*[@href=\"https://www.open.ru/\"]")).click();
        //переход на новую вкладку
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }

    public boolean compareDollarCourse() {
        WebElement dollarSale = driver.findElement(By.xpath("//tbody/tr[2]/td[2]/div/span"));
        WebElement dollarBuy = driver.findElement(By.xpath("//tbody/tr[2]/td[4]/div/span"));

        String sale = dollarSale.getText();
        String buy = dollarBuy.getText();

        sale = sale.replace(",", ".");
        buy = buy.replace(",", ".");

        double s = Double.parseDouble(sale);
        double b = Double.parseDouble(buy);
        if (s < b){return true;}  else {return false;}

    }

}