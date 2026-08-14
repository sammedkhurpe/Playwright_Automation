package com.automation.playwright;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Usecase_1 
{
	public static void main(String[] args) throws InterruptedException
	{
		Playwright playwright=Playwright.create();
		
		ArrayList<String> arguments=new ArrayList<>();
		arguments.add("--start-maximized");
		
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page=context.newPage();
		
		page.navigate("https://cronosedc.cronos.ws/");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("sammed");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
		Locator pass=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password"));
		pass.click();
		pass.type("Sammed@100");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
		
		
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("TOOLBAR.TOGGLE_QUICK_PANEL")).click();
		
		page.locator("md-select-value[id=\"select_value_label_7\"]").click();
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Super Admin")).click();
		
		page.locator("#layout-vertical-navigation md-backdrop").click();
		
		page.getByText("Masters", new Page.GetByTextOptions().setExact(true)).click();
		page.getByText("User Management").click();
		page.getByText("User Creation").click();	
		
	}
}
