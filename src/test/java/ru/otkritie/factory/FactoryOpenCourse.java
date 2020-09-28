package ru.otkritie.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class FactoryOpenCourse {
    private WebDriver driver;


    @FindBy(how = How.XPATH, using = "//*[@href=\"https://www.open.ru/\"]")
    WebElement open;

    @FindBy(how = How.XPATH, using ="//tbody/tr[2]/td[2]/div/span")
    WebElement Sale;

    @FindBy(how = How.XPATH, using ="//tbody/tr[2]/td[4]/div/span")
    WebElement Buy;


    public FactoryOpenCourse(WebDriver driver){
        this.driver=driver;
    }

    public void openLink(WebDriver driver) {
        open.click();
        //переход на новую вкладку
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }
    public boolean compareDollarCourse() {
        double dollarSale = Double.parseDouble(Sale.getText().replace(",", "."));
        double dollarBuy = Double.parseDouble(Buy.getText().replace(",", "."));

        if (dollarSale < dollarBuy){return true;}  else {return false;}
    }

}

