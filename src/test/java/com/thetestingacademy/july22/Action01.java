package com.thetestingacademy.july22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action01 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");

        Actions action = new Actions(driver);
        WebElement sourceCity = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));
        action.moveToElement(sourceCity).click().sendKeys("DEL").build().perform();

        driver.quit();

    }
}
