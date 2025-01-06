package com.qa.easyjobs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.easyjobs.base.BaseTest;
import com.qa.easyjobs.constants.AppConstants;
import com.qa.easyjobs.pages.JobPage;
 
class DashboardPageTest extends BaseTest {
	 

@Test(priority= 1)

public void dashboardPageTitleTest() {
	 
	     
		   String actualDashboardPageTitle = dashboardPage.getDashboardPageTitle();
		   System.out.println("page act title: " + actualDashboardPageTitle);
		   Assert.assertEquals(actualDashboardPageTitle, AppConstants.DASHBOARD_PAGE_TITLE);
		   page.waitForTimeout(3000);
		   
	}


@Test(priority= 2)

public void testRecentApplicantsSection() {

    Assert.assertFalse(dashboardPage.isRecentApplicantsSectionEmpty(), "Recent applicants section is empty.");
    Assert.assertFalse(dashboardPage.getRecentApplicantsCount() > 0, "Recent applicants count is zero.");
    page.waitForTimeout(3000);
}

@Test(priority=3)

public void testActiveCandidateCardClickable() {

	        
	        // Call the method to check if the jobs element is clickable
	        boolean isClickable = dashboardPage.isActiveCandidateCardClickable();
	        // Log the current URL to debug the actual navigation URL
	        String actualURL = page.url();
	        System.out.println("URL after clicking Active Candidate Card: " + actualURL);
	        
	        // Assert that the Teammember element is clickable
	        Assert.assertTrue(isClickable, "Active CandidateCard element is clickable!");
	        page.waitForTimeout(3000);
	        // Return to the dashboard after performing the click test
	        dashboardPage.navigateToDashboard();
	        
  

}
	

	 @Test(priority = 4)
	    public void testActiveJobsClickable() {
		
	        
	        // Call the method to check if the jobs element is clickable
	        boolean isClickable = dashboardPage.isActiveJobsClickable();
	        
	        // Assert that the jobs element is clickable
	        Assert.assertTrue(isClickable, "Active jobs element is clickable!");
	        page.waitForTimeout(3000);
	        String actualURL = dashboardPage.getExpectedJobPageURL();
	        Assert.assertEquals(actualURL,AppConstants.ExpectedJobPageURL2, "Failed to navigate to the active page!");
	        page.waitForTimeout(1000);
	       // Return to the dashboard after performing the click test
	        dashboardPage.navigateToDashboard();
	        
	    }
 
 
 
	 @Test(priority = 5)
	    public void testTeamMembersClickable() {
	        
	        // Call the method to check if the jobs element is clickable
	        boolean isClickable = dashboardPage.isTeamMembersClickable();
	        
	        // Assert that the Teammember element is clickable
	        Assert.assertTrue(isClickable, "Active teammember element is clickable!");
	        page.waitForTimeout(3000);
	      // Assert that the URL matches the expected URL for the team members page
	        
	        String actualURL = dashboardPage.getExpectedTeamMembersPageURL();
	        Assert.assertEquals(actualURL,AppConstants.ExpectedTeamMembersPageURL, "Failed to navigate to the Team Members page!");
	        page.waitForTimeout(1000);
	        // Return to the dashboard after performing the click test
	        dashboardPage.navigateToDashboard();
	        
	   
 

	 }
	 
	/* @Test(priority = 6)
	    public void testNavigateToJobPage() {
		 
		// Navigate to the Job Page
	        JobPage jobPage = dashboardPage.navigateToJobPage();

	        // Verify that the navigation was successful by checking the URL
	        String actualJobPageURL = jobPage.getJobPageURL();
	        Assert.assertEquals(actualJobPageURL, AppConstants.ExpectedJobPageURL, "Failed to navigate to the Job Page!");

	        // Verify that the page title is correct
	        String actualJobPageTitle = jobPage.getJobPageTitle();
	        Assert.assertEquals(actualJobPageTitle, AppConstants.Job_Page_TITLE, "Page title does not match after navigating to the Job Page!");
	        page.waitForTimeout(3000);
	        // Return to the dashboard after performing the click test
	       // dashboardPage.navigateToDashboard();
		
}

*/	 
}