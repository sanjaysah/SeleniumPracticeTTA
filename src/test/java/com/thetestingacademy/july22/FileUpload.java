package com.thetestingacademy.july22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/selenium/upload.html");

        driver.findElement(By.id("fileToUpload")).sendKeys("/Users/sanjaykumar/Desktop/irctc.png");
        driver.findElement(By.name("submit")).click();
        driver.quit();
    }
}
