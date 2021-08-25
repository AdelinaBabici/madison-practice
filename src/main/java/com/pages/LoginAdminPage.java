package com.pages;

import com.tools.constants.EnvironmentConstants;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginAdminPage extends BasePage{

    @FindBy(css = "input[value='Login']")
    private WebElementFacade loginButton;

    public LoginAdminPage(WebDriver driver) {
        super(driver);
    }

    public void loginAsAdmin(){
        typeInInputWithId("username", EnvironmentConstants.USER_NAME);
        typeInInputWithId("login", EnvironmentConstants.PASS_ADMIN);
        clickLoginButton();
    }
    public void clickLoginButton() {
        clickOn(loginButton);
    }
}
