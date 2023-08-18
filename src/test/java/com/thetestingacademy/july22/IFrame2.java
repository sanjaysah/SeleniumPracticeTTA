package com.thetestingacademy.july22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class IFrame2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://codepen.io/mmoonn/full/PwvraE");

        driver.switchTo().frame("result");

        WebElement move = driver.findElement(By.xpath("//body/div"));
        Actions action = new Actions(driver);
        action.moveToElement(move).build().perform();

        driver.switchTo().defaultContent();
    }
}
