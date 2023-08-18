package com.thetestingacademy.july22;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selectorshub.com/xpath-practice-page/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement usernameInput = (WebElement) js.executeScript("return document.querySelector('div#userName').shadowRoot.querySelector('input#kils')");
        WebElement PizzaInput = (WebElement) js.executeScript("return document.querySelector('div#userName').shadowRoot.querySelector('div#app2').shadowRoot.querySelector('input#pizza')");

        usernameInput.sendKeys("Username");
        PizzaInput.sendKeys("Cheese Burst Tandoori FullHouse");

        //driver.quit();
    }
}
