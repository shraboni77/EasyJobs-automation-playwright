package com.qa.easyjobs.pages;

import com.microsoft.playwright.Page;

public class ApplicationPage {

	
	private Page page;
	//locators
	private String applyNowButton  = "(//a[normalize-space()='Apply Now'])[1]";
	
	
	
	
	// page constructor:
	
	private ApplicationPage (Page page) {
		this.page = page;
	}
	
	
	
	
	  // Method to verify page title
	    public boolean verifyPageTitle(Page page1, String expectedTitle) {

	    	 String actualTitle = page1.title();
		        System.out.println("Actual page title: " + actualTitle);
		        return actualTitle.equals(expectedTitle);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
