package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Стартовая страница приложения
 */
public class StartPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class,'kitt-top-menu__list')]//a[@aria-label and @role='button']")
    private List<WebElement> menuBaseList;

    @FindBy(xpath = "//a[contains(@class,'kitt-top-menu__link_second')]")
    private List<WebElement> menuSubList;

    /**
     * Функция наведения мыши на любой пункт меню
     *
     * @param nameBaseMenu - наименование меню
     * @return StartPage - т.е. остаемся на этой странице
     */
    @Step("Переход в главное меню {nameBaseMenu}")
    public StartPage selectBaseMenu(String nameBaseMenu) {
        for (WebElement menuItem : menuBaseList) {
            if (menuItem.getText().trim().equalsIgnoreCase(nameBaseMenu)) {
                elementToBeClickable(menuItem).click();
                return this;
            }
        }

        Assertions.fail("Меню '" + nameBaseMenu + "' не было найдено на стартовой странице!");
        return this;
    }

    /**
     * Функция клика на любое подменю
     *
     * @param nameSubMenu - наименование подменю
     * @return InsurancePage - т.е. переходим на страницу {@link MortgagePage}
     */
    @Step("Выбираем подменю {nameSubMenu}")
    public MortgagePage selectSubMenu(String nameSubMenu) {
        for (WebElement menuItem : menuSubList) {
            if (menuItem.getText().equalsIgnoreCase(nameSubMenu)) {
                elementToBeClickable(menuItem).click();
                return app.getMortgagePage().checkOpenMortgagePage();
            }
        }
        Assertions.fail("Подменю '" + nameSubMenu + "' не было найдено на стартовой странице!");
        return app.getMortgagePage();
    }


}
