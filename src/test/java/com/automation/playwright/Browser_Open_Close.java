package com.automation.playwright;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Browser_Open_Close 
{
	public static void main (String[] args)
	{
//		Create a Playwright instance
		Playwright playwright= Playwright.create();
		
//		Declaration of ArrayList to maximizing the browser window. 
		ArrayList<String> arguments=new ArrayList<>();
		arguments.add("--start-maximized");
		
//		Launch a browser
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		
//		Create browser context to set view port size for the browser window.
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		
//		Open a tab in a browser
		Page page=context.newPage();
		
//		Navigate to the URL
		page.navigate("https://cronosedc.cronos.ws/Login");
		
//		Print page URL
		System.out.println("Page URL "+page.url());
		
//		Print page title
		System.out.println("Page Title "+page.title());
		
//		Close the page
		page.close();
		
//		Close the browser
		browser.close();
		
//		Stop the playwright instance.
		playwright.close();
		
	}
}
