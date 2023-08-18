package com.thetestingacademy.july22;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class JSAlerts3 {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        //External wait
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("SANJAY");
        //alert.accept();
        //System.out.println(text);
        alert.dismiss();//Escape button

        String result = driver.findElement(By.id("result")).getText();
        //Assert.assertEquals(result,"You entered: SANJAY"); // when enter pressed
        Assert.assertEquals(result,"You entered: null"); // when escape pressed
        //driver.quit();

    }
}
