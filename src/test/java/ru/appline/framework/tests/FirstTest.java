package ru.appline.framework.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.appline.framework.basetestsclass.BaseTests;

public class FirstTest extends BaseTests {

    @Test
    @DisplayName("Проверяем резутаты рассчета ипотеки")
    public void startTest() {
        app.getStartPage()
                .selectBaseMenu("Ипотека")
                .selectSubMenu("Ипотека на вторичное жильё")
                .checkOpenMortgagePage()
                .fillField("Стоимость недвижимости", "5 180 000")
                .fillField("Первоначальный взнос", "3 058 000")
                .fillField("Срок кредита", "30")
                .clickDealOnDomclickButton()
                .clickHealthAndLifeInsuranceButton()
                .clickElectronicDealRegisterButton()
                .checkOutputFields("Ежемесячный платеж", 21827)
                .checkOutputFields("Сумма кредита", 2122000)
                .checkOutputFields("Необходимый доход",37106)
                .checkOutputFields("Процентная ставка", 11);
    }

}
