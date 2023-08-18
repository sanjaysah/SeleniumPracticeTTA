package com.thetestingacademy.july22;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class OHRMAutomationChallenge17Aug {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        //Login
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Assertion
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/hr/web/index.php/pim/viewEmployeeList");

        //find all row - List<WebElements> and iterate to find name with Anthony Joseph and status terminated
        List<WebElement> EmployeeRow = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
        for(WebElement e: EmployeeRow){
            WebElement name = e.findElement(By.xpath("//div[@class='oxd-table-card']/div/div[3]/div"));
            WebElement terminated = e.findElement(By.xpath("//div[@class='oxd-table-card']/div/div[6]/div"));
            if(name.getText().equals("Aman")&&terminated.getText().equals("Terminated")){
                e.findElement(By.xpath("//div[@class='oxd-table-card']/div/div[9]/div/button[1]")).click();
            }
        }


        //driver.quit();
    }
}
