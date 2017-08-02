package com.ctli.it.library;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DriverSetup {
	
	public void setup() {
		System.out.println("Ankit");
		System.out.println(System.getProperty("webdriver.driver"));
		System.out.println(System.getProperty("user.dir"));
		if (System.getProperty("webdriver.driver") != null) {
			System.out.println("Ankit kumar singh");
			if (System.getProperty("webdriver.driver").equals("chrome")) {
				String pathDriver = System.getProperty("user.dir") + "\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", pathDriver);
				copyDriver("/chromedriver.exe", "\\chromedriver.exe");
			} else if (System.getProperty("webdriver.driver").equals("iexplorer")) {
				String pathDriver = System.getProperty("user.dir") + "\\IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", pathDriver);
				copyDriver("/IEDriverServer.exe", "\\IEDriverServer.exe");
			}
		} else {
			System.out.println("Ankit kumar");
			String pathDriver = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
			System.out.println(pathDriver);
			System.setProperty("webdriver.chrome.driver", pathDriver);
			copyDriver("/chromedriver.exe", "\\Resources\\chromedriver.exe");
			System.out.println("singh");
			pathDriver = System.getProperty("user.dir") + "\\IEDriverServer.exe";
			System.out.println("singh");
			System.setProperty("webdriver.ie.driver", pathDriver);
			System.out.println("singh");
			copyDriver("/IEDriverServer.exe", "\\IEDriverServer.exe");
			System.out.println("singh");
		}
	}

	public void copyDriver(String resourceLocation, String driverLocation) {
		InputStream is = getClass().getResourceAsStream("C:\\Users\\ab73168\\Documents\\My Received Files\\SerenityWorkspace\\HAMPSTOOLS\\src\\test\\resources\\data.xml");

		//InputStream is = getClass().getResourceAsStream(resourceLocation);
		
		System.out.println(is+"is location");
		OutputStream os = null;
		try {
			os = new FileOutputStream(System.getProperty("user.dir") + driverLocation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		byte[] buffer = new byte[4096];
		int length;
		try {
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
