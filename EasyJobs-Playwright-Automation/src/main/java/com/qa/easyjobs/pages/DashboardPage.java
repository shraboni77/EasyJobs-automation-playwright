package com.qa.easyjobs.pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.qa.easyjobs.constants.AppConstants;


public class DashboardPage {

	private Page page;

	//locator OR-

	public String draftJobs = "//a[@href='/job/draft']";
	public String activeCandidateCard = "(//a[@class='counter__card'])[1]";
	public String activeJobs = "(//a[@class='counter__card'])[2]";
	public String teamMembers = "//a[@href='/company/setting/basic/user']";
	public String recentApplicationSection= "//div[@class='recent-applicants-sections']";
    public String jobs="//div[normalize-space()='Jobs']";
    public String viewJobPage ="//a[@class='button info-button']";
    public String notification = "//button[@class='button light-button dropdown-toggle']";
    public String selectNotification = "(//small[@class='message-text'])[1]";

	// 2. page constructor:
			public DashboardPage(Page page) {
				this.page = page;
			}


	//Actions
			
			public String getExpectedTeamMembersPageURL() {
				String url =  page.url();
				System.out.println("page url : " + url);
				return url;
			}
	 
			
			

			 public void navigateToDashboard() {
			        page.navigate(AppConstants.Dasboard_Page_URL); // Navigate to the actual Dashboard URL
			    }
			
			
			public String getDashboardPageTitle() {
				String title =  page.title();
				System.out.println("page title: " + title);
				return title;
			}




			public String getDashboardPageURL() {
			String url =  page.url();
			System.out.println("page url : " + url);
			return url;
			}
			
			public String getExpectedJobPageURL() {
				String url =  page.url();
				System.out.println("page url : " + url);
				return url;
			}
			
			
			public String getExpectedCandidatePageURL() {
				String url =  page.url();
				System.out.println("page url : " + url);
				return url;
			}
	 

			public boolean isDraftJobsClickable(String draftJobs) {
		        try {
		           page.click(draftJobs);
		            return true; // Click succeeded, item is clickable
		        } catch (Exception e) {
		            return false; // Click failed, item is not clickable
		        }

			}

			public boolean isActiveCandidateCardClickable() {
				try {
				page.click(this.activeCandidateCard);
		         return true;//Click pass, item is clickable
		        }

                  catch (Exception e) 
				{
		            return false; // Click failed, item is not clickable
		        }

			}
			
		    public boolean isActiveJobsClickable() {
		        try {
		            page.click(this.activeJobs);
		            return true; // Click succeeded, item is clickable
		        } 
		        catch (Exception e) 
		        {
		            return false; // Click failed, item is not clickable
		        }

	        }

				        public boolean isTeamMembersClickable() {
					        try {
					            page.click(this.teamMembers);
					            return true; // Click succeeded, item is clickable
					        } catch (Exception e) {
					            return false; // Click failed, item is not clickable
					        }

				        }

				        public boolean isRecentApplicantsSectionEmpty() {
				            return page.isVisible("id=recentApplicantsEmptyMessage");
				        }

				        public int getRecentApplicantsCount() {
				            return page.querySelectorAll("css=#recentApplicants .applicant").size();
				        }


				     // Method to navigate to the Job Page
				        public JobPage navigateToJobPage() {
				            page.click(jobs);
				            return new JobPage(page); // Return the new JobPage instance
				        }
				        
						// Method to click "View Jobs" and handle new tab
						// Method to click "View Jobs" and handle new tab
					    public Page clickViewJobsAndHandleNewTab() {
					    	        BrowserContext context = page.context();
					    	        Page newPage = context.waitForPage(() -> {
					    	            page.click(viewJobPage);  // Click on "View Jobs" button
					    	        });
					    	        newPage.waitForLoadState();
					    	        return newPage;
					    	    

					    }
				 
					    public Page clickNotification() {
					    	   // Click the notification element
					        page.click(notification);

					        // Wait for the next element (selectNotification) to be visible before clicking it
					        page.waitForSelector(selectNotification);

					        // Click the selectNotification element
					        page.click(selectNotification);

					        // Return the current page object
					        return page;
					    }
				        
					    
					    
					    
}

