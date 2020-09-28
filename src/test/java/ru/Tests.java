package ru;

import ru.google.factory.FactorySearch;
import ru.google.object.AfterSearch;
import ru.google.object.BeforeSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import ru.otkritie.factory.FactoryOpenCourse;
import ru.otkritie.object.OpenCourse;

class Tests extends BasePage {

    static String link = "https://www.google.ru/";

    @Test
    public void findGladiolusPO() {
        driver.get(link);
        BeforeSearch beforeSearch = new BeforeSearch(driver);
        beforeSearch.findElem("Гладиолус");
        AfterSearch afterSearch = new AfterSearch(driver);
        Assertions.assertTrue(
                afterSearch.getGladiolus().stream().anyMatch(x -> x.getText().contains("Шпажник — Википедия")),
                "Страница \"Шпажник — Википедия\" не найдена :(");
    }

    @Test
    public void findGladiolusPF() {
        driver.get(link);
        FactorySearch factorySearch = PageFactory.initElements(driver, FactorySearch.class);
        factorySearch.findElem("Гладиолус");
        Assertions.assertTrue(
                factorySearch.getGladiolus().stream().anyMatch(x -> x.getText().contains("Шпажник — Википедия")),
                "Страница \"Шпажник — Википедия\" не найдена :(");

    }

    @Test
    public void openCoursePO() {
        driver.get(link);
        BeforeSearch beforeSearch = new BeforeSearch(driver);
        beforeSearch.findElem("Открытие");
        OpenCourse openBeforeSearch = new OpenCourse(driver);
        openBeforeSearch.openLink(driver);
        boolean course = openBeforeSearch.compareDollarCourse();
        Assertions.assertTrue(course);

    }

    @Test
    public void openCoursePF() {
        driver.get(link);
        FactorySearch factorySearch = PageFactory.initElements(driver, FactorySearch.class);
        factorySearch.findElem("Открытие");
        FactoryOpenCourse factoryOpenCourse = PageFactory.initElements(driver, FactoryOpenCourse.class);
        factoryOpenCourse.openLink(driver);
        boolean course = factoryOpenCourse.compareDollarCourse();
        Assertions.assertTrue(course);

    }
}
