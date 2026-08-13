package com.automation.playwright;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Element_using_getByLabel
{
	public static void main(String[] args)
	{
		Playwright playwright=Playwright.create();
		
		ArrayList<String> arguments=new ArrayList<>();
		arguments.add("--start-maximized");
		
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page=context.newPage();
		
		page.navigate("https://cronosedc.cronos.ws/");
		
//		Identifying the elements by using getByLabel
		page.getByLabel("username").fill("sammed");
		page.getByLabel("Next").click();
		
		Locator password=page.getByLabel("Password");
		password.click();
		password.type("Sammed@100");
		
		page.getByLabel("SIGN IN").click();
	}
}
