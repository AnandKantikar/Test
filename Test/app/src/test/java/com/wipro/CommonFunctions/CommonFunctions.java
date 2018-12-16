package com.wipro.CommonFunctions;

import com.wipro.testUtils.PageElements;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static org.testng.Assert.assertEquals;

// This class is created to  maintain all generic/common functions
public class CommonFunctions {
    public AndroidDriver<AndroidElement> driver;
    boolean isVisible,isDisplayed;
    String getElementTxt;
    public CommonFunctions(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public boolean isDisplayed(AndroidElement element) {
        return waitForVisibilityOfElement(element) && element != null && element.isDisplayed();

    }
    public boolean waitForVisibilityOfElement(AndroidElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(PageElements.getInstance().driver, 40);
            element = (AndroidElement) wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public void SwipeElementUp(AndroidElement element,int duration) {

                int offset = 1;
                Point p = element.getCenter();
                Point location = element.getLocation();
                Dimension size = element.getSize();
                PageElements.getInstance().driver.swipe(p.getX(), location.getY() + size.getHeight() + offset, p.getX(), location.getY(), duration);
        }

    public void setScreen_Resolution(String Resolution) {
        if (Resolution.equalsIgnoreCase("LANDSCAPE")) {
            PageElements.getInstance().driver.rotate(ScreenOrientation.LANDSCAPE);
            try {
                assertEquals(ScreenOrientation.LANDSCAPE, driver.getOrientation());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Resolution.equalsIgnoreCase("PORTRAIT")) {
            PageElements.getInstance().driver.rotate(ScreenOrientation.PORTRAIT);
            try {
                assertEquals(ScreenOrientation.PORTRAIT, driver.getOrientation());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void tap_On_Element(AndroidElement... element) {
        for (int i = 0; i < element.length; i++) {
            isVisible = waitForVisibilityOfElement(element[i]);
            isDisplayed = isDisplayed(element[i]);
            if (isVisible && isDisplayed ) {
                getElementTxt=element[i].getText();
                PageElements.getInstance().driver.tap(1, element[i], 1);
            }
        }
    }
    public void enter_Value(String value, AndroidElement... element) {
        for (int i = 0; i < element.length; i++) {
            isVisible = waitForVisibilityOfElement(element[i]);
            isDisplayed = isDisplayed(element[i]);
            if (isVisible && isDisplayed) {
                getElementTxt=element[i].getText();
                element[i].sendKeys(value);
            }
        }
    }
    public String getTextFromElement(AndroidElement element) {
        boolean isValue = false;
        String actTxt = null;
        isValue = waitForVisibilityOfElement(element);
        if (isValue) {
            actTxt = element.getText().trim().toString();
        }

        return actTxt;
    }
    public void moveToElelemnt(AndroidElement element){
        TouchActions action = new TouchActions(PageElements.getInstance().driver);
        action.down(10, 10);
        action.move(50, 50);
        action.perform();

    }
}
