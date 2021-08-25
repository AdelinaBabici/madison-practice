package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HeaderAdminPage extends BasePage{
    public HeaderAdminPage(WebDriver driver) {
        super(driver);
    }

    public void navigateThroughCategories(String... pathNodes){
        Actions actions = new Actions(getDriver());
        for(int i = 0; i < pathNodes.length; i++){
            WebElement currentElement = getDriver().findElement(By.xpath("//ul/li[a/span[text()='" + pathNodes[i] + "']]"));
            actions.moveToElement(currentElement).perform();
            actions.click().perform();
        }
    }


}
