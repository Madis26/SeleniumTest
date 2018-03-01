package com.ignite.ee.Page;

import org.openqa.selenium.chrome.ChromeDriver;

public class Page {
    protected ChromeDriver webDriver;
    protected Page(ChromeDriver webDriver) {
        this.webDriver = webDriver;
    }
    public ChromeDriver getWebDriver() {
        return webDriver;
    }
    public String getTitle() {
        return webDriver.getTitle();
    }
}
