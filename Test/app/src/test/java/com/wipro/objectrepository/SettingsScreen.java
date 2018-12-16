package com.wipro.objectrepository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class SettingsScreen {
    public AndroidDriver<AndroidElement> driver;

    public SettingsScreen(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    // MenuItem button
    @AndroidFindBy(xpath="//android.widget.ImageButton[contains(@content-desc,'Main navigation, open')]")
    public AndroidElement btn_MenuItem;


    // Home button
    @AndroidFindBy(xpath="//android.widget.CheckedTextView[contains(@text,'Home')]")
    public AndroidElement btn_Home;


    // Settings button
    @AndroidFindBy(xpath="//android.widget.CheckedTextView[@text='Settings']")
    public AndroidElement btn_Settings;

    // Country/Region button
    @AndroidFindBy(xpath="//android.widget.TextView[@text='India']")
    public AndroidElement btn_Country_Region;

    // Country/Region button
    @AndroidFindBy(xpath="//android.widget.Switch[contains(@resource-id,'switch_widget')]")
    public AndroidElement btn_AutoDetectToggle;

    // Naviagte Back button
    @AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Navigate up']")
    public AndroidElement btn_NaviagteBack;


    // Country search field
    @AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'filter')]")
    public AndroidElement txt_searchCountry;

    // Select Country Label
    @AndroidFindBy(xpath="//android.widget.CheckedTextView[contains(@text,'United States')]")
    public AndroidElement label_UnitedStates;

    // Selected Country Label
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'United States')]")
    public AndroidElement label_secUnitedStates;




}
