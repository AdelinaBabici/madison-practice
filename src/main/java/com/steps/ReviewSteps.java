package com.steps;

import com.pages.HeaderAdminPage;
import com.pages.ReviewsAdminPage;
import net.thucydides.core.annotations.Step;

public class ReviewSteps extends AbstractSteps{

    private HeaderAdminPage headerAdminPage;
    private ReviewsAdminPage reviewsPage;

    @Step
    public void navigateThroughCategories(String... pathNodes){
        headerAdminPage.navigateThroughCategories(pathNodes);
    }

    @Step
    public void approveReviewAsAdmin(String name, String status){
        reviewsPage.clickOnPendingReview(name);
        reviewsPage.approveReview(status);
        reviewsPage.clickOnSaveReviewButton();

    }
}
