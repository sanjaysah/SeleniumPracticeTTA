package com.thetestingacademy.july22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class MultipleWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");

        driver.findElement(By.linkText("Click Here")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> getWindows = driver.getWindowHandles();
        for (String element:getWindows) {
            driver.switchTo().window(element);
        }

        driver.switchTo().window(mainWindow);


    }
}
