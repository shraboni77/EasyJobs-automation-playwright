package com.qa.easyjobs.factory;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	Playwright playwright;
	BrowserType browserType;
	BrowserContext browserContext;
   	Page page;
	Properties prop;
	
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	

	public static Playwright getPlaywright() {
		return tlPlaywright.get();
	}


	public static Browser getBrowser() {
		return tlBrowser.get();
	}

	public static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}

	public static Page getPage() {
		return tlPage.get();
	}


	public Page initBrowser(Properties prop, boolean useSavedState) {

		String browserName = prop.getProperty("browser").trim();
		System.out.println("browser name is : " +browserName);
		tlPlaywright.set(Playwright.create());

		switch (browserName.toLowerCase()) {

		case "chromium":
			
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)));
					

			break;

		case "firefox":
			tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)));
			break;

		case "safari":
			tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)));
			break;

		case "chrome":
			tlBrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(50)));
			break;

		default:
			System.out.println("please pass the right browser name......");
			break;
		}
		 
		// Initialize browser context with viewport size set to null to maximize window size
      

		// Use saved authentication state if it exists
		 
		if (useSavedState && new java.io.File("auth.json").exists()) 
		{
			 tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("auth.json"))));
		} 
		
		else 
		{
		    tlBrowserContext.set(getBrowser().newContext());
		}
			
			
		tlPage.set(getBrowserContext().newPage());
		getPage().navigate(prop.getProperty("url"));
		return getPage();
	}

	  public void saveAuthState() {

		  getBrowserContext().storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("auth.json")));
	    }

	public Properties init_prop(){

		try {
			FileInputStream ip = new FileInputStream("./src/test/resources /config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
	


}













