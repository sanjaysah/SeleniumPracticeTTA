package com.thetestingacademy.july22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class katalon {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        //driver.findElement(By.id("btn-make-appointment")).click();
        //driver.findElement(By.xpath("//a[text()='Make Appointment']")).click(); // text() method in xpath
        driver.findElement(By.xpath("//a[contains(text(),'Appointment')]")).click(); // contains method
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).submit();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

        //Appointment Page
        WebElement dropdown = driver.findElement(By.id("combo_facility"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Seoul CURA Healthcare Center");
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        driver.findElement(By.id("radio_program_medicare")).click();
        driver.findElement(By.id("txt_visit_date")).sendKeys("04/09/2023");
        driver.findElement(By.id("txt_comment")).sendKeys("I want to get better!!");
        driver.findElement(By.id("btn-book-appointment")).submit();

        String appointmentconfirmation = driver.findElement(By.xpath("//h2[text()='Appointment Confirmation']")).getText();
        Assert.assertEquals(appointmentconfirmation,"Appointment Confirmation");
        driver.quit();
    }
}
