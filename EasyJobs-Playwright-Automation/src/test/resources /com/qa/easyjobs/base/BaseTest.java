package com.qa.easyjobs.base;
import java.util.Properties;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.easyjobs.factory.PlaywrightFactory;
import com.qa.easyjobs.pages.ApplicationPage;
import com.qa.easyjobs.pages.CandidateApplyPage;
import com.qa.easyjobs.pages.ConversationPage;
import com.qa.easyjobs.pages.DashboardPage;
import com.qa.easyjobs.pages.JobPage;
import com.qa.easyjobs.pages.LoginPage;

public class BaseTest {

    protected PlaywrightFactory pf;
	protected Page page;
	protected Properties prop;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected JobPage jobPage;
    protected ConversationPage conversationPage;
    protected CandidateApplyPage candidateApplyPage;
    protected ApplicationPage applicationPage;

	@BeforeTest

	public void setup()

	{
		pf = new PlaywrightFactory();
		prop = pf.init_prop();
		boolean useSavedSession = !this.getClass().getSimpleName().equals("LoginPageTest");
        page = pf.initBrowser(prop, useSavedSession);
      
	    loginPage = new LoginPage(page);
		dashboardPage = new DashboardPage(page);
		jobPage = new JobPage(page);
		conversationPage = new ConversationPage(page);
		candidateApplyPage = new CandidateApplyPage(page);
      
		
	}


   @AfterTest
    public void tearDown() {
   // You can close the browser here if needed
  
	   PlaywrightFactory.getBrowser().close();
   }

}