package com.wipro.testUtils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.ServerSocket;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class BaseSuiteSetUp {
    public Logger log;
    public String workingDir = System.getProperty("user.dir");
    public String loggerLocation = workingDir + "\\Files\\log4j.properties";
    int port = 4723;
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;

    @BeforeSuite(alwaysRun = true)
    public void onBeforeSuite() throws Throwable {
        PropertyConfigurator.configure(loggerLocation);
        log = Logger.getLogger(this.getClass().getName());
        if (!checkIfServerIsRunnning(port)) {
            startServer();
        } else {
            log.info("Appium Server already running on Port - " + port);
        }
        PageElements.getInstance().suiteSetUp();
    }


    //@BeforeMethod
    public void launchEbayApp() throws Throwable {
        if (!checkIfServerIsRunnning(port)) {
            startServer();
        } else {
            log.info("Appium Server already running on Port - " + port);
        }
        PageElements.getInstance().suiteSetUp();
    }

    public void startServer() {
        //Set Capabilities
        cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");

        //Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(port);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public void stopServer() {
        try {
            {
                service.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void resetAll() {
        PageElements.getInstance().resetApplication();
        log.info("Test completed and tear down the driver");
       /* if (checkIfServerIsRunnning(port)) {
            stopServer();

        } else {
            log.info("Appium Server not running on Port - " + port);
        }*/
    }
    @AfterSuite(alwaysRun = true)
    public void onAfterSuite() {
        PageElements.removeInstance();
        log.info("Suite Execution is Completed");
    }
}