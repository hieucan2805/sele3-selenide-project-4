package htt.projects;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import htt.base.DriverFactory;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.invoke.MethodHandles.lookup;

public class BaseTest {
	private static final Logger log = LoggerFactory.getLogger(lookup().lookupClass());
	Configuration config;

//	@Parameters({"browser", "executionMode"})
//	@BeforeClass
//	public void setUp(String browser, @Optional("") String executionMode) throws MalformedURLException {
//		// Use the provided browser value, or a default if not provided
//		browser = java.util.Optional.ofNullable(browser).orElse("chrome");
//
//		// Use the provided executionMode value, or an empty string if not provided
//		executionMode = executionMode != null ? executionMode : "local";
//
//		DriverFactory.setupDriver(browser, executionMode);
//
//		Configuration.headless = false;
//		SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
//		log.info("Start {} TestNG testcases in {}", getClass().getName(), Configuration.browser);
//	}

	@BeforeClass
	@Parameters("browser")
	public void BeforeClass(@Optional String platform) throws MalformedURLException {
		platform = java.util.Optional.ofNullable(platform).orElse("chrome");
		log.info("Running test on {}", platform);

		DriverFactory.setupDriver("chrome", "local");

		Configuration.headless = false;
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
		log.info("Start {} TestNG testcases in {}", getClass().getName(), Configuration.browser);

	}

	@BeforeMethod
	public void launch() {
		open();
		getWebDriver().manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		// Close the browser after each test
		Selenide.closeWebDriver();
	}

	public void refreshPage() {
		;
	}

	MutableCapabilities createBrowserCapabilities(String platform) {
		MutableCapabilities options = new MutableCapabilities();

		switch (platform.toLowerCase()) {
			case "chrome": {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				chromeOptions.addArguments("--disable-extensions");
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("--disable-gpu");
				chromeOptions.addArguments("--disable-infobars");
				chromeOptions.addArguments("--disable-save-password-bubble");
				chromeOptions.setExperimentalOption("credentials_enable_service", false);
				chromeOptions.setExperimentalOption("profile.password_manager_enabled", false);
				options.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				break;
			}
			case "firefox": {
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--start-maximized");
				firefoxOptions.addArguments("--disable-extensions");
				firefoxOptions.addArguments("--no-sandbox");
				firefoxOptions.addArguments("--disable-infobars");
				firefoxOptions.setCapability("credentials_enable_service", false);
				firefoxOptions.setCapability("profile.password_manager_enabled", false);
				options.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
				break;
			}
			case "edge": {
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments("--start-maximized");
				edgeOptions.addArguments("--disable-extensions");
				edgeOptions.addArguments("--no-sandbox");
				edgeOptions.addArguments("--disable-gpu");
				edgeOptions.addArguments("--disable-infobars");
				edgeOptions.addArguments("--disable-save-password-bubble");
				edgeOptions.setCapability("credentials_enable_service", false);
				edgeOptions.setCapability("profile.password_manager_enabled", false);
				options.setCapability(EdgeOptions.CAPABILITY, edgeOptions);

				break;
			}
		}
		return options;
	}


}
