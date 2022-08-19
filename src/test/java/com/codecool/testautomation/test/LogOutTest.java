package com.codecool.testautomation.test;

import com.codecool.testautomation.page.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.codecool.testautomation.utility.DriverSingleton.quit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogOutTest {

    LoginPage loginPage;

    @BeforeAll
    public void setUp()
    {
        loginPage = new LoginPage();
        loginPage.fillUsernameAndPassword();
        loginPage.logIn();
    }

    @AfterAll
    public void quitDriver() {
        quit();

    }
    @Test
    public void successfullLogOut()
    {


    }

}
