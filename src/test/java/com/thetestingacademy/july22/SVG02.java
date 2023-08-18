package com.thetestingacademy.july22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SVG02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");

        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='button' and @value='I agree']")).click();
        for(WebElement state: states){
            System.out.println(state.getAttribute("aria-label"));
            if(state.getAttribute("aria-label").trim().equals("Bihar")){
                action.scrollToElement(state);
                action.moveToElement(state).click().perform();
            }
        }

        //driver.quit();
    }

}
