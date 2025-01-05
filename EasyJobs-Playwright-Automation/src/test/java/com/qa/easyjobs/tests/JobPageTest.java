package com.qa.easyjobs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.easyjobs.base.BaseTest;
import com.qa.easyjobs.constants.AppConstants;
import com.qa.easyjobs.pages.JobPage;

public class JobPageTest extends BaseTest {



	@Test(priority = 1)
	public void testNavigateToJobPage() {
		 
		// Navigate to the Job Page
		
	        dashboardPage.navigateToJobPage();
	        page.waitForTimeout(3000);
	        


	}
	
	
	@Test(priority = 2)
	public void jobPageTitleTest() {

		 // Verify that the navigation was successful by checking the URL
        String actualJobPageURL = jobPage.getJobPageURL();
        Assert.assertEquals(actualJobPageURL, AppConstants.ExpectedJobPageURL, "Failed to navigate to the Job Page!");

        // Verify that the page title is correct
        String actualJobPageTitle = jobPage.getJobPageTitle();
        Assert.assertEquals(actualJobPageTitle, AppConstants.Job_Page_TITLE, "Page title does not match after navigating to the Job Page!");
        page.waitForTimeout(3000);

	}
	
        @Test(priority = 3)

        public void createJobTest() {
        	
            // Step 1: Click on the create job button
            jobPage.clickCreateJobButton();
            page.waitForTimeout(3000);
        }
        
        @Test(priority = 4)
        
         public void fillJobDetails() {

            // Call the method to fill job details
            jobPage.fillJobDetails(prop.getProperty("jobTitle"),
            prop.getProperty("jobDescription"),
            prop.getProperty("jobResponsibility"));
            
            
         }
            // Step 3: Select job type
           
        @Test(priority = 5)

            public void selectJobType() {
            
            jobPage.selectJobType();
            page.waitForTimeout(3000);
            }

        @Test(priority = 6)
        
        public void setExpiryDate() {
        	
            // Step 4: Set expiry date
            jobPage.setExpiryDate("10/30/2024");
            page.waitForTimeout(3000);
            
        }

        @Test(priority = 7)
        public void selectJobCategory() {
        	
        
            // Step 5: Select job category
            jobPage.selectJobCategory();
}
        
        
        @Test(priority = 8)
        
        public void selectSkills() {

            // Step 6: Select skills
            jobPage.selectSkills();
            page.waitForTimeout(3000);
            
}
        
        @Test(priority = 9)
        
        public void selectEmploymentType() {

            // Step 7: Select employment type
            jobPage.selectEmploymentType();
        
            
        }
        
        @Test(priority = 10)
        public void selectSalaryType() {

            // Step 8: Select salary type
            jobPage.selectSalaryType();
            page.waitForTimeout(3000);
        }
        
       // public void uploadBannerImage() {

            // Step 9: Upload banner image (provide the correct path to your image)
           // jobPage.uploadBannerImage(null);
            
        //}

        @Test(priority = 11)
        public void clickSaveButton() {
            // Step 10: Click save and continue
            jobPage.clickSaveButton();
            page.waitForTimeout(3000);
        }
        
        
        @Test(priority = 12)
    	public void screeningQuestionPageTitleTest() {

    		 // Verify that the navigation was successful by checking the URL
           // String actualScreeningQuestionPageURL = jobPage.getScreeningQuestionPageURL();
           // Assert.assertEquals(actualScreeningQuestionPageURL, AppConstants.ScreeningQuestionPageURL, "Failed to navigate to the Job Page!");
           // page.waitForTimeout(3000);

            // Verify that the page title is correct
            String actualScreeningQuestionPageTitle = jobPage.getScreeningQuestionPageTitle();
            Assert.assertEquals(actualScreeningQuestionPageTitle, AppConstants.ScreeningQuestionPageTitle, "Page title does not match after navigating to the Job Page!");
            page.waitForTimeout(3000);

    	}
        
        @Test(priority = 13)
       public void addScreeningQuestions() {
            // Step 11: Add questions
            jobPage.addScreeningQuestions();
        }
        
        
        @Test(priority = 14)
        
        public void screeningQuestionSaveButton() {
            // Step 12: Click the publish button to create the job
           jobPage.screeningQuestionSaveButton();
           page.waitForTimeout(3000);
        }


        @Test(priority = 15)
    	public void quizQuestionPageTitleTest() {

            // Verify that the page title is correct
            String actualQuizQuestionPageTitle = jobPage.getQuizQuestionPageTitle();
            Assert.assertEquals(actualQuizQuestionPageTitle, AppConstants.quizQuestionPageTitle, "Page title does not match after navigating to the Job Page!");
           

     

	}

        @Test(priority = 16)
        public void addQuizQuestions() {
             // Step 11: Add questions
             jobPage.addQuizQuestions();
             page.waitForTimeout(3000);
         }

        
        @Test(priority = 17)
        public void setQuizDuration() {
        	
             // Step 11: Add quiz duration
        	 jobPage.setQuizDuration(prop.getProperty("quizDuration"));
         }
        
        
        @Test(priority = 18)
        public void setQuizMarks() {
        	
             // Step 11: Add quiz marks
        	 jobPage.setQuizMarks(prop.getProperty("quizMarks"));
         }
        
        
   @Test(priority = 19)
        
        public void quizSaveButton(){
	   
            // Step 19: Click the quiz save button to create the job
            jobPage.quizSaveButton();

        }
        
   @Test(priority = 20)
   
   public void customJobApplyFieldSaveButton(){

       // Step 20: Click the quiz save button to create the job
      jobPage.clickCustomFieldsaveButton();
      
       
   }
   
   @Test (priority = 21)
   public void jobPublishConfirmButton() {
	   
	// Step 22: Click the job publish confirm button to create the job
   
    jobPage.jobPublishConfirmButton(); 
    page.waitForTimeout(3000);

}

   @Test (priority = 22)
	   
   public void isJobPublishedSuccessfully() {
	   
   
// Validate the job published success message
   boolean isPublished = jobPage.isJobPublishedSuccessfully();
   Assert.assertTrue(isPublished, "Job was not published successfully!");
   page.waitForTimeout(3000);

}

}
