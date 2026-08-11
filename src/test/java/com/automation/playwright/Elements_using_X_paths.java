package com.automation.playwright;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Elements_using_X_paths
{
	public static void main(String[] args)
	{
		ArrayList<String> arguments=new ArrayList<>();
		arguments.add("--start-maximized");
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page=context.newPage();
		
		page.navigate("https://cronosedc.cronos.ws/Login");
		
//		identification of elements by using Relative X-paths
//		Syntaxes:
//				1. X-path by attribute: 	   //tagname[@AN='AV']
//				2. X-path by text: 		   	   //tagname[text()='text']
//				3. X-path by contains	 	   //tagname[Contains(@AN, 'AV)]    or   //tagname[Contains(text(), 'text')]
//				4. X-path by group index	   (//tagname[@AN='AV'])[1]
//				5. X-path by traversing
		
		page.locator("//input[@name='loginname']").fill("user.1");
		page.locator("(//button[@type='submit'])[1]").click();
		page.locator("//input[@name='password']").fill("123");
		page.locator("(//button[@type='submit'])[2]").click();
		
		page.close();
		browser.close();
		playwright.close();
	}
}
