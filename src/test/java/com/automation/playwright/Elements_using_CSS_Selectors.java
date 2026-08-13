package com.automation.playwright;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Elements_using_CSS_Selectors
{
	public static void main(String[] args) throws InterruptedException
	{
//		
		ArrayList<String> arguments=new ArrayList<>();
		arguments.add("--start-maximized");
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page=context.newPage();
		
		page.navigate("https://cronosedc.cronos.ws/Login");
		
		System.out.println("Page URL: "+page.url());
		System.out.println("Page Title: "+page.title());
		
//		Method 1: First Identify the elements & then perform the actions
		
//		identification of elements by using CSS Selector: Syntaxt: Tagname[AN='AV']
		Locator username=page.locator("input[name=\"loginname\"]");
		username.fill("user.1");
		
		Locator next=page.locator("button[aria-label=\"Next\"]");
		next.click();
		
//		For the security purpose the password field has kept disable in the application, so first click on the element then perform action.
		Locator password=page.locator("input[name=\"password\"]");
		password.click();
		password.type("123");
		
		Locator signin=page.locator("button[aria-label=\"Sign in\"]");
		signin.click();
		
//		Java wait for observation
		Thread.sleep(10000);
		
//		fill()  >> clears the field then fills the data at once.
//		type()  >> appends the data one by one.
		
		page.close();
		browser.close();
		playwright.close();
		
	}
}
