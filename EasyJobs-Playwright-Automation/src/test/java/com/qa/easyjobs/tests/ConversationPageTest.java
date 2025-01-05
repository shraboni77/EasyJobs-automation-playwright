package com.qa.easyjobs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.easyjobs.base.BaseTest;
import com.qa.easyjobs.constants.AppConstants;

public class ConversationPageTest extends BaseTest {

	
	@Test(priority = 1)
	
    public void testNavigateToCandidatesPage() {
        // Navigate to the candidates page
        conversationPage.navigateToCandidates();

        // Verify that the current URL is the candidates page URL
        String currentURL = conversationPage.getCandidatesPageURL();
        Assert.assertEquals(currentURL, AppConstants.candidatesPageURL, "Failed to navigate to the Candidates page.");
        page.waitForTimeout(3000);
    }

    @Test(priority = 2)
    public void testSearchForCandidate() {
        // Search for a specific candidate
     
    	String searchText = AppConstants.searchText;
        conversationPage.searchForText(searchText);
        page.keyboard().press("Enter");
        page.waitForTimeout(3000);

    }

    @Test(priority = 3)
    public void testViewCandidateDetails() {
        // Click on the "View Details" button for a candidate
        conversationPage.clickViewutton();
        page.waitForTimeout(3000);

       
    }

    
   
    @Test(priority = 4)
    public void clickpipelineDropDown() {
    	
    // Change the pipeline status to "Shortlist"
       
   	   conversationPage.clickPipeline();
   	   page.waitForTimeout(3000);
    }
    
    
    
    @Test(priority = 5)
    public void testChangePipelineToShortlist() {
        // Change the pipeline status to "Shortlist"
       
   
    	conversationPage.changePipeline();
    	page.waitForTimeout(3000);

        
    }

    
    @Test(priority = 6)
    public void clickConversationTab() {
        
    	// Click conversation tab"
       
    	conversationPage.clickConversationTab();
    	 page.waitForTimeout(3000);

    }
    
    
    @Test(priority = 7)
    public void testConversationStartedLabelNotVisibleOnPipelineChange() {

        // Check if the "Conversation Started" label is visible after changing the pipeline
        boolean isLabelVisible = conversationPage.isConversationStartedLabelVisible();

        // Assert that the label is NOT visible (the test will pass if the label is not found)
        Assert.assertFalse(isLabelVisible, "Conversation Started' label should not be visible after changing the pipeline..");
        page.waitForTimeout(3000);
    }

    @Test(priority = 8)

    public void testAddNoteAndCheckConversationStartedLabel() {
        // Add a note
        String noteText = AppConstants.noteText;
        conversationPage.addNote(noteText);

        // Check if the "Conversation Started" label is visible
        boolean isLabelVisible = conversationPage.isConversationStartedLabelVisible();

        // Assert that the label should NOT be visible after adding a note
        Assert.assertFalse(isLabelVisible, "'Conversation Started' label should not be visible after adding a note.");
        page.waitForTimeout(3000);
    }


    @Test(priority = 9)
    public void testSendMessageAndCheckConversationStartedLabel() {
        // Send a message to the candidate
        String message = AppConstants.message;
        conversationPage.sendMessage(message);

        // Check if the "Conversation Started" label is visible
        boolean isLabelVisible = conversationPage.isConversationStartedLabelVisible();

        // Assert that the label SHOULD be visible after sending a message
        Assert.assertTrue(isLabelVisible, "'Conversation Started' label should be visible after sending a message.");
        page.waitForTimeout(3000);
    }




    @Test(priority = 10)
    public void testAssignAssessment() {
        // Send a message to the candidate
        String expiredate = AppConstants.expireDate;
        page.waitForTimeout(3000);
        conversationPage.assignAssessment(expiredate);
        page.waitForTimeout(3000);
      
    }
    
    
    
    
    
    
    
    
    
    













}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	

