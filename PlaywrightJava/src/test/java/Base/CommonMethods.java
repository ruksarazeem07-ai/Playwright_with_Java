package Base;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class CommonMethods {

	protected Page page;

	public CommonMethods(Page page) {
		this.page = page;
	}

	public void click(String selector) {
		try {
			page.locator(selector).click();
		} catch (Exception e) {
			Assert.fail("Click failed: " + selector + " -> " + e.getMessage());
		}
	}

	public void type(String selector, String value) {
		try {
			page.locator(selector).fill(value);
		} catch (Exception e) {
			Assert.fail("Type failed: " + selector);
		}
	}

	public void mouseHover(String selector) {
		try {
			page.hover(selector);
		} catch (Exception e) {
			Assert.fail("Hover failed: " + selector);
		}
	}

	public boolean isElementPresent(String locator) {
		return page.locator(locator).isVisible();
	}

	public void selectByLabel(String selector, String value) {
		try {
			page.selectOption(selector, new SelectOption().setLabel(value));
		} catch (Exception e) {
			Assert.fail("Select failed: " + selector);
		}
	}

//	public void verifyURLContains(String expected) {
//		try {
//			page.waitForURL("**" + expected + "**");
//			String actual = page.url();
//			Assert.assertEquals(actual.contains(expected), "URL mismatch. Actual: " + actual);
//		} catch (Exception e) {
//			Assert.fail("URL verification failed: " + e.getMessage());
//		}
//	}

	public void verifyURLContains(String expected) {

		page.waitForURL("**" + expected + "**");

		String actual = page.url();

		Assert.assertTrue("URL mismatch. Actual: " + actual, actual.contains(expected));
	}

	public void verifyVisible(String selector) {
		Assert.assertTrue("Element not visible: " + selector, page.locator(selector).isVisible());
	}

	public void verifyText(String selector, String expected) {
		Assert.assertEquals(page.locator(selector).textContent(), expected);
	}
	
	public void selectOption(String locator, String value) {
	    try {
	        page.waitForSelector(locator);
	        page.locator(locator).selectOption(value);
	        System.out.println("Selected option: " + value + " for locator: " + locator);
	    } catch (Exception e) {
	        e.printStackTrace();
	        Assert.fail("Failed to select option: " + e.getMessage());
	    }
	}
	
	public void clickCheckbox(String locator) {
	    try {
	        page.waitForSelector(locator);
	        page.locator(locator).check();
	        Assert.assertTrue("Checkbox is not checked!", page.locator(locator).isChecked());
	        System.out.println("Checkbox checked: " + locator);
	    } catch (Exception e) {
	        e.printStackTrace();
	        Assert.fail("Failed to check checkbox: " + e.getMessage());
	    }
	}
}