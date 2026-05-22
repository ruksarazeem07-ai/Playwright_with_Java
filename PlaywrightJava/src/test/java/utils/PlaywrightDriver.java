package utils;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitUntilState;

public class PlaywrightDriver {

	public static PlaywrightDriver playwrightDriver;
	private Playwright playwright;
	public Browser browser;
	public Page page;
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	private static FileInputStream fis;

	private static ThreadLocal<Playwright> pw = new ThreadLocal<>();
	private static ThreadLocal<Browser> br = new ThreadLocal<>();
	private static ThreadLocal<Page> pg = new ThreadLocal<>();

	public static Playwright getPlaywright() {

		return pw.get();
	}

	public static Browser getBrowser() {

		return br.get();
	}

	public static Page getPage() {

		return pg.get();
	}

	private PlaywrightDriver() {

//		try {
//			fis = new FileInputStream("./src/main/resources/properties/OR.properties");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			OR.load(fis);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		

		try {
			fis = new FileInputStream("./src/test/resources/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		playwright = Playwright.create();
		pw.set(playwright);

		BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false)
				.setArgs(Arrays.asList("--start-maximized"));

		if (config.getProperty("browser").equals("chrome")) {

			browser = getPlaywright().chromium().launch(options);

		}

		else if (config.getProperty("browser").equals("firefox")) {

			browser = getPlaywright().firefox()
					.launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(false));

		} else if (config.getProperty("browser").equals("webkit")) {
			browser = getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		}

		br.set(browser);

		BrowserContext context = browser
				.newContext(new Browser.NewContextOptions().setViewportSize(null).setScreenSize(null));

		page = context.newPage();
		pg.set(page);
	}

	public static void setupDriver() {

		playwrightDriver = new PlaywrightDriver();
	}

	public static void openPage(String url) {

		getPage().navigate(url);
//		getPage().navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE).setTimeout(60000));
//		getPage().waitForLoadState(LoadState.DOMCONTENTLOADED);
	}

	public static void closeBrowser() {

		getBrowser().close();
		getPage().close();
	}

	public static void quitPlaywright() {

		if (getPage() != null) {

			getPlaywright().close();

		}

	}

}
