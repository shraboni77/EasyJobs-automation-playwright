package com.qa.easyjobs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.qa.easyjobs.base.BaseTest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CandidateDetailsPageTest extends BaseTest{
	
	@Test
	
	 public void clickNotification() {
		 // Perform the click action on the notification
	       // dashboardPage.clickNotification();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
		      page.click("//*[@id=\"appa\"]/div[1]/main/div[1]/header/div[2]/div[3]/div/ul/ul/li[1]/a/p/small[1]/b");
		      page.waitForTimeout(3000);
		      assertThat(page.getByText("Back")).isVisible();
		      page.waitForTimeout(3000);
	}
		
		      @Test
		      public void cli() {
		     
		    	  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Resume")).click();
		    	   page.waitForTimeout(3000);
			      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Evaluation").setExact(true)).click();
			      page.waitForTimeout(3000);
			      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Conversation")).click();
			      page.waitForTimeout(3000);
			      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
			      page.waitForTimeout(3000);
			      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Assign assessment")).click();
			      page.waitForTimeout(3000);
			      page.locator("div:nth-child(2) > .col-md-12 > .form-group > .multiselect > .multiselect__tags").click();
			      page.waitForTimeout(3000);
			      page.locator("span").filter(new Locator.FilterOptions().setHasText("Test Assessment")).first().click();
			      page.getByPlaceholder("mm/dd/yyyy").click();
			      page.waitForTimeout(3000);
			      page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("6")).first().click();
			      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Assign assessment")).click();
			      page.waitForTimeout(3000);
     
	
	 }
	
	
	
	
	
	
	
	
	
	
	

}
