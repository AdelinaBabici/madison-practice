package com.pages;

import com.models.ProductReview;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductDetailsPage extends BasePage {

    @FindBy(css = "#product-review-table tbody tr")
    private List<WebElement> reviewCriteriaRows;

    @FindBy(css = "a[href*='review-form'")
    private WebElementFacade addAReviewLink;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getDriver().findElement(By.cssSelector(".product-name span")).getText();
    }

    public Double getPrice() {
        return Double.parseDouble(getDriver().findElement(By.cssSelector("span[id*='product-price']")).getText().replaceAll("[^0-9.]+", ""));
    }

    public String getProductRandomColor() {
        WebElement colorElement = getRandomElementFromList(By.cssSelector("#configurable_swatch_color>li a"));
        clickOn(colorElement);
        return colorElement.getAttribute("title");
    }

    public String getProductRandomSize() {
        WebElement sizeElement = getRandomElementFromList(By.cssSelector("#configurable_swatch_size li:not(.not-available) a"));
        clickOn(sizeElement);
        return sizeElement.getAttribute("title");
    }

    public void fillReviewDetails(ProductReview productReview){
        typeInInputWithName("detail", productReview.getThoughts());
        typeInInputWithId("nickname_field", productReview.getNickname());
        typeInInputWithId("summary_field", productReview.getSummary());
        setReviewRating(productReview.getCriteria(),productReview.getNrStars());
    }
    public void setReviewRating(String criteria, int nrStars) {
        for (WebElement criteriaRow : reviewCriteriaRows) {
            if (criteriaRow.findElement(By.cssSelector("th")).getText().equalsIgnoreCase(criteria)) {
                criteriaRow.findElement(By.cssSelector("input[id*='" + nrStars + "']")).click();
                break;
            }
        }
    }
    public void clickOnAddAReviewLink() {
        clickOn(addAReviewLink);
    }

    public void setReviewCriteriaRows(){
        Random random = new Random();
       setReviewRating("QUALITY", random.nextInt(5) + 1);
       setReviewRating("PRICE", random.nextInt(5) + 1);
       setReviewRating("VALUE", random.nextInt(5) + 1);
    }

}
