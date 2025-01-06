package com.qa.easyjobs.pages;

import java.util.List;
import java.util.concurrent.TimeoutException;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.qa.easyjobs.constants.AppConstants;

public class CandidateApplyPage {

	
	private Page page;
	


	//locator OR-

	private String viewJobPage = "//a[@class='button info-button']";
	private String applyNowButton  = "(//a[normalize-space()='Apply Now'])[1]";
	private String candiEmail= "//input[@id='email']";
	private String candiPassword ="//input[@id='password']";
	private String candidateLoginButton = "//button[@id='login-submit']";
	private String basicInfoSaveButton ="//button[normalize-space()='Save and Continue']";
	
	//Locator for resume page
	private String coverLetterEditor = "//div[@id='quill_editor']";
	private String checkBox ="//div[@class='checkbox-text']";
	private String saveContinueButton2 = "//button[normalize-space()='Save and Continue']";
	
	//Screening question page  locator
	private String screeningText = "//p[@class='content-card__title__text']";
	private String checkOption3= "//label[normalize-space()='option3']";
	private String saveContinueButton3 = "//button[normalize-space()='Save and Continue']";
	
	// zLocator for Quiz page
	private String  quizText = "//p[@class='content-card__title__text']";
	private String  startQuizButton= "//button[normalize-space()='Start Quiz']";
	private String  option2 = "//div[contains(text(),'hgbu')]";
	private String submitAnswer = "//button[normalize-space()='Submit Answer']";
	
	//Final page Locator
	private String finalPageText = "//h4[normalize-space()='You are just 1 click away!']";
	private String resumeTab = "//a[normalize-space()='Resume']";
	private String screeningTab= "//a[normalize-space()='Screening']";
	private String submitApplication = "//a[normalize-space()='Submit Job Application']";
	private String basicInfoLocator = "//p[@class='content-card__title__text']";
	private String closeButton = ".close-item";
	private String profileHeading = "Update your profile with AI";
	private String resumeText = "//p[normalize-space()='Cover Letter']";
	
	
	// page constructor:
	
				public CandidateApplyPage(Page page) {
					this.page = page;
				}
	
	
//	Actions/methods:
				
		    		
		    // Method to click "Apply Now" and handle new tab
		    public Page clickApplyNow() {
		    	
		    	
		        // Wait for the popup to open after clicking the "Apply Now" link
		        Page page3 = page.waitForPopup(() -> {
		            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Apply Now")).click();
		        });
		        return page3;
		    }
		    	
			  // Method to verify page title
		    public boolean verifyPageTitle(Page newPage, String expectedTitle) {

		    	 String actualTitle = newPage.title();
			        System.out.println("Actual page title: " + actualTitle);
			        return actualTitle.equals(expectedTitle);
		    }
		 // Method to click "Apply Now" and handle new tab
		    public Page clickApplyNowButtonAndHandleNewTab(Page newPage) {
		        BrowserContext context = newPage.context();
		        Page applicationPage = context.waitForPage(() -> {
		            newPage.click(applyNowButton);  // Click on "Apply Now" button
		        });
		        applicationPage.waitForLoadState();
		        return applicationPage;
		    }
		    
			
			  // Method to assert heading visibility and close the modal
		    public void assertAndCloseModal(Page applicationPage) {
		        // Step 1: Assert that the heading is visible
		        boolean isHeadingVisible = applicationPage.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(profileHeading)).isVisible();
		        
		        // Assertion
		        if (!isHeadingVisible) {
		            throw new AssertionError("Heading ''Update your profile with AI' is not visible!");
		        }

		        // Step 2: Click the close button to close the modal
		        applicationPage.locator(closeButton).click();
		    }

		 
				public void clickSaveButton(Page applicationPage) {
					
					applicationPage.click(basicInfoSaveButton);
				}
				
			
				 public boolean isCoverLetterTextVisible(Page applicationPage) 
				    {
				        return applicationPage.isVisible(resumeText);
				    }
				
				public void writeCoverLetter(String coverLetter, Page applicationPage) {
					
					applicationPage.click(coverLetterEditor);
					applicationPage.fill(coverLetterEditor, coverLetter);
					System.out.println("Cover letter is visible....");
					
	
			}
	
               //public void clickcheckbox(Page applicationPage)	{
					
					//applicationPage.click(checkBox);
				
             //  }
               
               public void clickSaveContinueButton2(Page applicationPage)	{
					
					applicationPage.click(saveContinueButton2);
               
				
               }
               
               
               public boolean isScreeningTextVisible(Page applicationPage) 
			    {
			        return applicationPage.isVisible(screeningText);
			        
			    }
               
               public void clickAnswer3(Page applicationPage)	{
					
					applicationPage.click(checkOption3);
              
				
              }
               
               public void clickSaveContinueButton3(Page applicationPage)	{
					
				applicationPage.click(saveContinueButton3);
             
				
             } 
               
               
               public boolean isQuizTextVisible(Page applicationPage) 
			    {
			        return applicationPage.isVisible(quizText);
			    } 
               
               
               public void clickStartQuizButton(Page applicationPage)	{
					
					applicationPage.click(startQuizButton);
            
				
            }
               
               
               public void clickoption2(Page applicationPage)	{
					
					applicationPage.click(option2);
           
				
           }  
               
               
               public void clickSubmitAnswer(Page applicationPage)	{
					
				applicationPage.click(submitAnswer);
           
				
           }
               
               public boolean isFinalTextVisible(Page applicationPage) 
			    {
			        return applicationPage.isVisible(finalPageText);
			    }   
               
               
               
               
               public void clickResumeTab(Page applicationPage)	{
					
					applicationPage.click(resumeTab);
           
				
           }
               
               
               
               public void clickScreeningTab(Page applicationPage)	{
					
					applicationPage.click(screeningTab);
           
				
           }
               
               
               
               
               public void clickSubmitApplication(Page applicationPage)	{
					
					applicationPage.click(submitApplication);
           
				
           }


		


			
               
				
}
