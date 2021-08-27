package com.tests;

import java.lang.reflect.InvocationTargetException;

import com.google.inject.Inject;
import com.models.ProductReview;
import com.tools.factories.ProductReviewFactory;
import net.bytebuddy.utility.RandomString;
import net.serenitybdd.junit.runners.SerenityRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class Test003ManageProductsReviews extends BaseTest {
@Inject
private ProductReview productReview;

    @Before
    public void dataPrep() {
        loginSteps.login();
    }

    @Test
    public void test003ManageProductsReviews() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        productFlowSteps.navigateToProductDetailsPage("AVIATOR SUNGLASSES");
        productFlowSteps.addProductReview();
       //TODO approve the review from magento admin if that's the only way to make it visible under the product
        loginAdminSteps.navigateToAdminLoginPage();
        loginAdminSteps.loginAsAdmin();
        reviewSteps.navigateThroughCategories("Catalog", "Reviews and Ratings", "Customer Reviews", "Pending Reviews");
        reviewSteps.approveReviewAsAdmin("AVIATOR SUNGLASSES", "Approved");

        setup();
        productFlowSteps.navigateToProductDetailsPage("AVIATOR SUNGLASSES");
        productDetailsSteps.clickOnAddAReviewLink();
        productDetailsSteps.verifyReviews();

    }

    @Override
    @Before
    public void tearDown() {
        //ideally, here you could remove the review from admin
    }
}
