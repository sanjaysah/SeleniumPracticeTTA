package com.thetestingacademy.july22;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Selenium001 {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        //options.addExtensions(new File("/Users/sanjaykumar/Downloads/extension_5_8_1_0.crx"));
        //options.addArguments("--window-size=1000,800");
        options.addArguments("--start-maximized");
        options.addArguments("--user-data-dir=/Users/sanjaykumar/Library/Application Support/Google/Chrome/Profile 1");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);//EAGER and NONE
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.thetestingacademy.com");
        System.out.println(driver.getTitle());
        //driver.close();

    }
}
