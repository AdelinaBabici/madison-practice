package com.tests;

import com.pages.LoginAdminPage;
import com.steps.*;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.StepEventBus;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import com.steps.flowsteps.ProductFlowSteps;
import com.tools.constants.EnvironmentConstants;

public class BaseTest {
    @Managed(uniqueSession = true)
    WebDriver webdriver;
    @Steps
    protected LoginSteps loginSteps;
    @Steps
    protected CartSteps cartSteps;
    @Steps
    protected ProductFlowSteps productFlowSteps;
    @Steps
    protected WishlistSteps wishlistSteps;
    @Steps
    protected ProductDetailsSteps productDetailsSteps;
    @Steps
    protected LoginAdminSteps loginAdminSteps;

    @Before
    public void setup() {
        System.setProperty("env", "qa2-env");
        webdriver.navigate().to(EnvironmentConstants.BASE_URL);
    }

    @After
    public void tearDown() {
        StepEventBus.getEventBus().clearStepFailures();
        webdriver.quit();
    }
}
