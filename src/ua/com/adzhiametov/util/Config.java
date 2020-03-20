package ua.com.adzhiametov.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by arsen_adzhiametov on 15/01/2016.
 */
public class Config {

	private static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
	private static final String PAGES_COUNT_KEY = "fs.to.pages";

	public static String getProperty(String key) {

		String value = "";

		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("resources\\config.properties");
			prop.load(input);
			return prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	public static int pagesCount() {
		return Integer.parseInt(getProperty(PAGES_COUNT_KEY));
	}

	public static String chromeDriverPath() {
		return getProperty(CHROME_DRIVER_KEY);
	}
}
