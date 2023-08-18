package com.thetestingacademy.july22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators01 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/practice.html");

        //WebElement mainRefElement = driver.findElement(By.xpath("//span[text()='Years of Experience']"));
        WebElement nearElement50px = driver.findElement(with(By.id("exp-1"))
                .toRightOf(By.xpath("//span[text()='Years of Experience']")));
        nearElement50px.click();

        //driver.quit();
    }
}
