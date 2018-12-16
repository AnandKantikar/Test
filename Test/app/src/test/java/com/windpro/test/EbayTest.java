package com.windpro.test;

import com.wipro.testUtils.BaseSuiteSetUp;
import com.wipro.testUtils.PageElements;
import org.testng.annotations.Test;


public class EbayTest extends BaseSuiteSetUp {
String usrNme=null;
String password=null;

    @Test
    public void purchaseProduct()  {
        log.info("Login Test Starts");
     PageElements.getInstance().getHelperMethods().selectCountry(PageElements.getInstance().getSettingsScreen().label_UnitedStates, PageElements.getInstance().getDataFactory().getExcelData("EbayData", 1, 3));
        usrNme= PageElements.getInstance().getDataFactory().getExcelData("EbayData", 1, 1);
        password=PageElements.getInstance().getDataFactory().getExcelData("EbayData", 1, 2);
        PageElements.getInstance().getHelperMethods().loginintoEbay(usrNme,password);

        if(PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_popUp)){
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_popUp);
            log.info("Google Pop up Clicked");
        }
        if(PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_searchTxt)) {
            log.info("Search Text field is dispayed");
            PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_searchTxt);
            log.info("Search Text field is Clicked");
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().txt_searchTxt)) {
                log.info("Product Search Text field is dispayed");
                PageElements.getInstance().getCommonFunctions().enter_Value(PageElements.getInstance().getDataFactory().getExcelData("EbayData", 1, 4), PageElements.getInstance().getProductDetailsPage().txt_searchTxt);
                log.info(" Product name entered in search text fiels");
            } else {
                log.info("Product Search Text field does not dispayed");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_iPhone5)) {
                log.info("Iphone 5 is dispayed");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_iPhone5);
                log.info("Clicked Iphone 5");
            } else {
                log.info("Iphone 5 is product does not dispayed");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_iPhone5Product)) {
                log.info("Iphone 5 is listed ");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_iPhone5Product);
                log.info("Clicked Iphone 5 from listed product");
            } else {
                log.info("Iphone 5 is product does not listed");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_AddToCart)) {
                log.info("AddToKart is displayed ");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_AddToCart);
                log.info("Clicked AddToKart button");
            } else {
                log.info("AddToKart is displayed d");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().drpDwn_Color)) {
                log.info("Color dropDown displayed");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().drpDwn_Color,PageElements.getInstance().getProductDetailsPage().drpDwn_Color_Black,PageElements.getInstance().getProductDetailsPage().drpDwn_Grade,PageElements.getInstance().getProductDetailsPage().drpDwn_Grade_A,PageElements.getInstance().getProductDetailsPage().drpDwn_Storage,PageElements.getInstance().getProductDetailsPage().drpDwn_Storage_GB);

                log.info("Selected Color, Storage and Grade from dropDown");
            } else {
                log.info("Color dropDown  does not displayed");
            }
            if (PageElements.getInstance().getCommonFunctions().isDisplayed(PageElements.getInstance().getProductDetailsPage().btn_AddBasket)) {
                log.info("Add Basket is displayed ");
                PageElements.getInstance().getCommonFunctions().tap_On_Element(PageElements.getInstance().getProductDetailsPage().btn_AddBasket);
                log.info("Clicked Add Basket button");
            } else {
                log.info("Add Basket does not displayed ");
            }
        }

    }
}