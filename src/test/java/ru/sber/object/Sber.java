package ru.sber.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.sber.object.model.Menu;
import ru.sber.object.model.SubMenu;

import java.util.ArrayList;
import java.util.List;


public class Sber {

    private static final String MAIN_MENU_SELECTOR = "//li/span";
    private static final String TEMPLATE_SUB_MENU_SELECTOR = "//li/span[contains(text(), \"%s\")]/following-sibling::div//a";

    private List<Menu> menuList = new ArrayList<>();

    public Sber(WebDriver driver) {
        this.menuList = getDataFromWebPage(driver);
    }

    public List<Menu> getDataFromWebPage(WebDriver driver) {
        List<WebElement> menuList = driver.findElements(By.xpath(MAIN_MENU_SELECTOR));
        List<Menu> menuMainList = new ArrayList<>();
        for (WebElement menu : menuList) {
            String menuName = menu.getText();
            String resultSelectorSubMenu = String.format(TEMPLATE_SUB_MENU_SELECTOR, menuName);
            List<WebElement> subMenuList = driver.findElements(By.xpath(resultSelectorSubMenu));

            Menu menuObj = new Menu();
            menuObj.setName(menuName);
            List<SubMenu> subList = new ArrayList<>();
            for (WebElement submenu : subMenuList) {
                String nameSubmenu = submenu.getAttribute("innerText");
                String href = submenu.getAttribute("href");
                SubMenu subMenuObj = new SubMenu();
                subMenuObj.setHref(href);
                subMenuObj.setName(nameSubmenu);
                subList.add(subMenuObj);
            }
            menuObj.setSubMenuList(subList);
            menuMainList.add(menuObj);
        }
        return menuMainList;
    }

    public String getHrefSubMenu(String menuName, String subMenuName) {
        if (this.menuList.isEmpty()) {
            throw new IllegalArgumentException("data from page is empty");
        }
        String href = null;
        for (Menu mainMenu : this.menuList) {
            List<SubMenu> subMenuList = mainMenu.getSubMenuList();
            String mainMenuName = mainMenu.getName();
            for (SubMenu subMenu : subMenuList) {
                if (menuName.equals(mainMenuName) && subMenuName.equals(subMenu.getName())) {
                    href = subMenu.getHref();
                }
            }
        }
        return href;
    }
}




