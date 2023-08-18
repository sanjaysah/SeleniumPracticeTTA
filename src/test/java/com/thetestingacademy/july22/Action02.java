package com.thetestingacademy.july22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Action02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        Actions action = new Actions(driver);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement popupClose = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']"));
            }
        });
        Thread.sleep(3000);

        //driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
        action.moveByOffset(10,10).click().build().perform();
        Thread.sleep(2000);
        action.moveByOffset(10,10).click().build().perform();

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        action.moveToElement(fromCity).click().sendKeys("Bengaluru").build().perform();

        List<WebElement> sources = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
        for (WebElement e:sources){
            if(e.getText().contains("Bengaluru")){
                e.click();
                break;
            }

        }

        WebElement toCity = driver.findElement(By.id("toCity"));
        action.moveToElement(toCity).click().sendKeys("New Delhi").build().perform();

        List<WebElement> destinations = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']/div/ul/li"));
        for (WebElement e: destinations) {
            if(e.getText().contains("New Delhi")){
                e.click();
                break;
            }
        }
        //driver.quit();

    }
}
