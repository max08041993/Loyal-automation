package ru.invitro.loyalty.driver;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class CustomChromeDriver implements DriverSource {

    public static String downLoadPath = "C:\\chrome\\";

    @Override
    public WebDriver newDriver() {
        Map<String, Object> chromeDrivePreference = new HashMap<>();
        chromeDrivePreference.put("download.prompt_for_download", false);
        chromeDrivePreference.put("plugins.always_open_pdf_externally", true);
        chromeDrivePreference.put("download.default_directory", downLoadPath);
        chromeDrivePreference.put("profile.default_content_settings.popups", 0);
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
//        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//        options.setCapability( "goog:loggingPrefs", logPrefs );
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromeDrivePreference);
        options.addArguments("--disable-notifications");
        options.addArguments("--window-size=1920,1080");
        options.setCapability( "goog:loggingPrefs", logPrefs );
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        options.merge(caps);
        return new ChromeDriver(service,options);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}