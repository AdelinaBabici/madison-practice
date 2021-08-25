package com.steps;

import com.pages.LoginAdminPage;
import com.tools.constants.EnvironmentConstants;
import net.thucydides.core.annotations.Step;

public class LoginAdminSteps extends AbstractSteps{

    private LoginAdminPage loginAdminPage;

    @Step
    public void navigateToAdminLoginPage(){
        loginAdminPage.navigateToAdminLoginPage();
    }

    @Step
    public void loginAsAdmin(){

        loginAdminPage.loginAsAdmin();
        loginAdminPage.closePopupMessage();
    }


}
