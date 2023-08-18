package com.thetestingacademy.july22;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        driver.get("https://app.vwo.com");
        driver.findElement(By.id("login-username")).sendKeys("93npu2yyb0@esiix.com");
        driver.findElement(By.id("login-password")).sendKeys("Wingify@123");
        driver.findElement(By.id("js-login-btn")).click();

        //Explicit wait
        //WebElement welcomeMess = driver.findElement(By.xpath("//span[normalize-space()='Need Help?']"));
        //wait.until(ExpectedConditions.elementToBeClickable(welcomeMess));
        //WebElement welcomeMess = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[normalize-space()='Need Help?']"))));

        //Fluent Wait
        WebElement needhelpButton = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("//h3[text()='Hypotheses Pipeline']"));
            }
        });

        //Assertion
        String actual = needhelpButton.getText();
        System.out.println(actual);
        String expected = "Hypotheses Pipeline";
        Assert.assertEquals(actual,expected);

        driver.navigate().to("https://app.vwo.com/logout");
        driver.close();
    }
}
