package com.wipro.objectrepository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class SignInScreen {
    public AndroidDriver<AndroidElement> driver;

    public SignInScreen(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    // Email or User name
    @AndroidFindBy(xpath="//android.widget.EditText[contains(@text,'Email or username')]")
    public AndroidElement txt_Email;

    // Password
    @AndroidFindBy(xpath="//android.widget.EditText[contains(@text,'Password')]")
    public AndroidElement txt_Password;
//Sign In
    @AndroidFindBy(xpath="//android.widget.Button[@text='SIGN IN']")
    public AndroidElement btn_SignIn;
}
