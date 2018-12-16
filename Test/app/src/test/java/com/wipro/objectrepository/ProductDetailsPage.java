package com.wipro.objectrepository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDetailsPage {
    AndroidDriver<AndroidElement> driver;
    public ProductDetailsPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Google Pop Up
    @AndroidFindBy(xpath="//android.widget.Button[contains(@text,'NO THANKS')]")
    public AndroidElement btn_popUp;

    // Main Search filed
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'search_box')]")
    public AndroidElement btn_searchTxt;


    // Main Search filed
    @AndroidFindBy(xpath="//android.widget.EditText[contains(@text,'Search for anything')]")
    public AndroidElement txt_searchTxt;

    // Iphone 5
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'iphone 5')]")
    public AndroidElement btn_iPhone5;

    // Iphone 5 from product list
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Apple iPhone 5 - 32GB - Black - Fully Unlocked')]")
    public AndroidElement btn_iPhone5Product;


    // Add to Cart
    @AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'button_add_to_cart')]")
    public AndroidElement btn_AddToCart;


    // Color
    @AndroidFindBy(xpath="//android.widget.LinearLayout[contains(@resource-id,'selection_option_row') and @index='0']")
    public AndroidElement drpDwn_Color;

    //Black color

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Black')]")
    public AndroidElement drpDwn_Color_Black;

    // Storage
    @AndroidFindBy(xpath="//android.widget.LinearLayout[contains(@resource-id,'selection_option_row') and @index='1']")
    public AndroidElement drpDwn_Storage;

    //Storage GB
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'16GB')]")
    public AndroidElement drpDwn_Storage_GB;


    // Grade
    @AndroidFindBy(xpath="//android.widget.LinearLayout[contains(@resource-id,'selection_option_row') and @index='2']")
    public AndroidElement drpDwn_Grade;


    //Grade
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'A')]")
    public AndroidElement drpDwn_Grade_A;

//Add to Basket
    @AndroidFindBy(xpath="//android.widget.Button[contains(@text,'ADD TO BASKET')]")
    public AndroidElement btn_AddBasket;


}

