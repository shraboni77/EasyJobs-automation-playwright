package com.qa.easyjobs.pages;

import com.microsoft.playwright.Page;
import com.qa.easyjobs.constants.AppConstants;

public class ConversationPage {

	
	private Page page;

	//locator OR-

	public String messageBox="//a[@class='button light-button']//i[@class='eicon e-chat']";
	public String conversationTab = "//div[normalize-space()='Conversation']";
	public String pipelineChangeLabel= "//div[@class='alert fade show text-center my-1 p-2 conversation__first__message note info-label']";
	public String noteLabel="//div[@class='alert fade show alert-warning text-center my-1 p-2 conversation__first__message note']";
    public String conversationStartedLabel="//div[contains(@class,'alert fade show alert-warning text-center my-1 p-2 conversation__first__message')]";
    public String conversationTextArea= "//div[@id='containerBox']";
    public String candidatesPage = "//div[normalize-space()='Candidates']";
    public String searchBar ="//*[@id=\"appa\"]/div[1]/main/div[2]/section/form/div/div[1]/div/input";
    public String viewDetails = "//*[@id=\"appa\"]/div[1]/main/div[2]/section/div/div/div[1]/div/a[2]";
    public String pipelineDropDown = "//button[normalize-space()='Applied']";
    public String selectPipeline = "//a[normalize-space()='shortlist']";
   
    //Locator for Note
    
    public String noteTextArea = "//textarea[@placeholder='Add a note here']";
    public String  saveNoteButton= "//button[normalize-space()='Save']";
   
    //Locator for conversation
  
    public String  conversationArea= "//div[@aria-label='Rich Text Editor, main']";
    public String  sendButton= "//button[normalize-space()='Send']";
    
    //Locator for assign assessment
    public String dropDownIcon = "//div[@class='back-button dropdown']//button[@class='back-button__icon']";
    public String assignAssessmentButton = "//a[normalize-space()='Assign assessment']";
    public String selectAssessment = "\"Select assessment\"";
    public String assessment = "//span[contains(text(),'Test Assessment')]";
    public String expiryDate = "//input[@placeholder='mm/dd/yyyy']";
    public String assignAssessment = "//button[normalize-space()='Assign assessment']";
  
    
    
    
 // 2. page constructor:
 			public ConversationPage(Page page) {
 				this.page = page;
 			}
	
	
	
	
//Actions
		
 			public String getCandidatesPageURL() {
				String url =  page.url();
				System.out.println("page url : " + url);
				return url;
			}

 			 public void navigateToCandidates() {
			        page.navigate(AppConstants.candidatesPageURL); // Navigate to the actual candidates page
			    }
 			 
 			  // Method to click on the search bar and search for text
 		    public void searchForText(String searchText) {
 		    	
 		    
 		        page.click(searchBar); // Click on the search bar
 		        page.fill(searchBar, searchText); // Enter the search text
 		        
 		        
 		    }
 		    
 		    
 		   public void clickViewutton() {
		    	
 	 		    
		        page.click(viewDetails); // Click view
		        
		        
		    }
 		    
 		  public void clickPipeline() {
		    	
		        page.click(pipelineDropDown); // Enter the search text
		        
		        
		    }
 		   
 		   
 		   
 		   public void changePipeline() {
		    	
		        page.click(selectPipeline); // Enter the search text
		        
		        
		    }
 		    
 		  public void clickConversationTab() {
		    	
		        page.click(conversationTab); // Enter the search text
		        
		        
		    }
 		   

			
 		   // Method to check if the "Conversation Started" label is visible
 		  
		    public boolean isConversationStartedLabelVisible() 
		    {
		        return page.isVisible(conversationStartedLabel);
		    }
	
		    
	
		    // Method to add a note
		    public void addNote(String noteText) {
		        page.click(noteTextArea);
		    	page.fill(noteTextArea, noteText);  // Fill the note text
		        page.click(saveNoteButton);  // Click to save the note
		    }
	
	       // Send message
		    public void sendMessage(String message) {
		    	page.click(conversationArea);
		        page.fill(conversationArea, message);  // Enter message text
		        page.click(sendButton);  // Click to send the message
		    }

		  
		    // Assign Assessment
		    public void assignAssessment(String expireDate) {
		    	page.click(dropDownIcon);
		        page.click(assignAssessmentButton);  // Enter message text
		        page.click(selectAssessment);  // Click to send the message
		        page.click(assessment);
		        page.click(expiryDate);
		        page.fill(expiryDate, expireDate);
		        page.click(assignAssessment);
		    }

	
	
	
	
	
	
}
