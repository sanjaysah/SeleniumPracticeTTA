package com.thetestingacademy.july22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVG01 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        driver.findElement(By.className("_3704LK")).sendKeys("IPhone");
        WebElement searchSVG = driver.findElement(By.xpath("//*[name()='svg']/*[name()='g' and @fill-rule='evenodd']"));
        Actions action = new Actions(driver);
        action.moveToElement(searchSVG).click().perform();
        action.moveToElement(searchSVG).click().perform();
        //driver.quit();
    }

}
