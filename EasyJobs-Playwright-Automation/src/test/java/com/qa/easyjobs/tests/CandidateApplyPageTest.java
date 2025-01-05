package com.qa.easyjobs.tests;

import java.util.concurrent.TimeoutException;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.qa.easyjobs.base.BaseTest;
import com.qa.easyjobs.constants.AppConstants;
import com.qa.easyjobs.pages.ApplicationPage;
import com.qa.easyjobs.pages.CandidateApplyPage;
import com.qa.easyjobs.pages.LoginPage;





public class CandidateApplyPageTest extends BaseTest {
	private Page newPage;  // Store the new tab (jobs page) to reuse in the second test
	private Page applicationPage; //To store the login page (after clicking "Apply Now")

	
	@Test(priority =1 )
	public void testVerifyPageTitle() {

		  candidateApplyPage = new CandidateApplyPage(page);

	      // Step 1: Click on "View Jobs" and handle new tab
	       newPage = dashboardPage.clickViewJobsAndHandleNewTab();
	      //
	      Assert.assertTrue(newPage.url().contains("jobs"), "URL of the new tab does not contain 'jobs' keyword");

	     // Step 2: Verify if the page title matches the expected value from AppConstants
	      boolean isTitleCorrect = candidateApplyPage.verifyPageTitle(newPage, AppConstants.companyJobPageTitle);
	        
	        // Step 3: Assert the title is correct
	        Assert.assertTrue(isTitleCorrect, "Page title does not match the expected value!");
	        page.waitForTimeout(3000);
	}


	

    @Test(priority = 2, dependsOnMethods = "testVerifyPageTitle")
    
    public void testApplyNow() throws TimeoutException {
      
    	// Ensure the child window is already opened and stored in newPage
        Assert.assertNotNull(newPage, "The child window (newPage) is not available!");
        page.waitForTimeout(3000);

        // Step 1: Click on "Apply Now" button in the existing child window (newPage)
        applicationPage = candidateApplyPage.clickApplyNowButtonAndHandleNewTab(newPage); // Assign to class-level variable
        page.waitForTimeout(3000);

        // Step 2: Assert that the login page has opened
        Assert.assertNotNull(applicationPage, "Login page did not open after clicking 'Apply Now' button!");

        // Step 3: Verify login page title
        String expectedLoginPageTitle = AppConstants.LOGIN_PAGE_TITLE;
        boolean isApplicationPageTitleCorrect = applicationPage.title().equals(expectedLoginPageTitle);

        // Step 4: Assert the login page title matches the expected title
        Assert.assertTrue(isApplicationPageTitleCorrect, "Login page title does not match the expected value!");

        // Perform login
        boolean loginSuccess = loginPage.doCandidateLogin(
                applicationPage,
                prop.getProperty("candidateEmail").trim(),
                prop.getProperty("candidatePassword").trim()
        );
        Assert.assertTrue(loginSuccess, "Login was not successful!");
        page.waitForTimeout(3000);
        
    }
	   
    
    @Test(priority = 3, dependsOnMethods = "testApplyNow")
    public void cAIModal() throws TimeoutException  {
    	
         // Step 2: Call the method to assert the heading and close the modal
         candidateApplyPage.assertAndCloseModal(applicationPage);
         page.waitForTimeout(3000);
             
     }  
      
    
    @Test(priority = 4,  dependsOnMethods = "cAIModal")
    public void testSaveBasicInfo() {
        // Test clicking the save button on the basic info page
       candidateApplyPage.clickSaveButton(applicationPage);
       page.waitForTimeout(3000);
        // Add assertions for what should happen after saving basic info
    }

    @Test(priority = 5,  dependsOnMethods = "testSaveBasicInfo")
    public void testWriteCoverLetter() {
        // Test writing a cover letter
    	//boolean isCoverLetterTextVisible = candidateApplyPage.isCoverLetterTextVisible(applicationPage);
       // Assert.assertTrue(isCoverLetterTextVisible, "Cover Letter text is visible");
        //page.waitForTimeout(3000);
        //candidateApplyPage.writeCoverLetter(AppConstants.coverLetter, applicationPage);
        //page.waitForTimeout(2000);
        applicationPage.click("//div[@class='checkbox-text']");
        page.waitForTimeout(3000);    

    }

   @Test(priority = 6, dependsOnMethods = "testWriteCoverLetter")
    public void testSaveContinueAfterCoverLetter() {
        // Test clicking save and continue after filling out the cover letter
        candidateApplyPage.clickSaveContinueButton2(applicationPage);
        page.waitForTimeout(4000);
        // Add assertions as necessary for next steps
    }

    @Test(priority = 7, dependsOnMethods = "testSaveContinueAfterCoverLetter")
    public void testScreeningPageVisible() {
        // Verify that the screening page is visible
        boolean isScreeningVisible = candidateApplyPage.isScreeningTextVisible(applicationPage);
        Assert.assertTrue(isScreeningVisible, "Screening page not visible.");
        page.waitForTimeout(4000);
    }

    @Test(priority = 8, dependsOnMethods = "testScreeningPageVisible")
    public void testSelectAnswer3() {
        // Select the answer for screening questions
        candidateApplyPage.clickAnswer3(applicationPage);
        page.waitForTimeout(4000);
    }

    @Test(priority = 9, dependsOnMethods = "testSelectAnswer3")
    public void testSaveContinueScreening() {
        // Test clicking save and continue after answering screening questions
        candidateApplyPage.clickSaveContinueButton3(applicationPage);
        // Add assertions for further validation
        page.waitForTimeout(4000);
    }

    @Test(priority = 10, dependsOnMethods = "testSaveContinueScreening")
    public void testQuizPageVisible() {
        // Verify that the quiz page is visible
        boolean isQuizVisible = candidateApplyPage.isQuizTextVisible(applicationPage);
        Assert.assertTrue(isQuizVisible, "Quiz page not visible.");
        page.waitForTimeout(4000);
    }

    @Test(priority = 11, dependsOnMethods = "testQuizPageVisible")
    public void testStartQuiz() {
        // Test clicking the start quiz button
        candidateApplyPage.clickStartQuizButton(applicationPage);
        // Add assertions based on quiz starting
        page.waitForTimeout(4000);
    }

    @Test(priority = 12, dependsOnMethods = "testStartQuiz")
    public void testSelectQuizOption2() {
        // Select option 2 in the quiz
        candidateApplyPage.clickoption2(applicationPage);
        page.waitForTimeout(3000);
        // Add assertions for selected options
    }

    @Test(priority = 13, dependsOnMethods = "testSelectQuizOption2")
    public void testSubmitQuizAnswer() {
        // Submit quiz answer
        candidateApplyPage.clickSubmitAnswer(applicationPage);
        page.waitForTimeout(3000);
        // Add assertions based on what happens after submitting the answer
    }

    @Test(priority = 14, dependsOnMethods = "testSubmitQuizAnswer")
    public void testFinalPageVisible() {
        // Verify that the final page is visible
        boolean isFinalPageVisible = candidateApplyPage.isFinalTextVisible(applicationPage);
        Assert.assertTrue(isFinalPageVisible, "Final page not visible.");
        page.waitForTimeout(3000);
    }

   // @Test(priority = 15, dependsOnMethods = "testFinalPageVisible")
    //public void testClickResumeTab() {
        // Test clicking the resume tab
       // candidateApplyPage.clickResumeTab(applicationPage);
        //page.waitForTimeout(2000);
        // Add assertions as necessary
   // }

   // @Test(priority = 16, dependsOnMethods = "testClickResumeTab")
   // public void testClickScreeningTab() {
        // Test clicking the screening tab
       // candidateApplyPage.clickScreeningTab(applicationPage);
        //page.waitForTimeout(2000);
        // Add assertions as necessary
   // }

    @Test(priority = 15, dependsOnMethods = "testFinalPageVisible")
    public void testSubmitApplication() {
        // Test submitting the job application
        candidateApplyPage.clickSubmitApplication(applicationPage);
        // Add assertions based on what should happen after submitting the application
    }
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

