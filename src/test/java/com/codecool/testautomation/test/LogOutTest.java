package com.codecool.testautomation.test;

import com.codecool.testautomation.page.LoginPage;
import com.codecool.testautomation.utility.DriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.codecool.testautomation.utility.Utility.*;
import static com.codecool.testautomation.utility.LogIn.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogOutTest {
//    static DriverSingleton driverSingleton = DriverSingleton.getInstance();
    LoginPage loginPage;

    @BeforeAll
    public void setUp(){
        loginPage = new LoginPage(DriverSingleton.getDriver());
        beforeEachSetup();
    }

    @AfterAll
    public void quitDriver() {
        close();
    }

    @Test
    public void successfullLogOut() {
        loginPage.logIn();
        logout();
        loginPage.validateLogin();
    }

}