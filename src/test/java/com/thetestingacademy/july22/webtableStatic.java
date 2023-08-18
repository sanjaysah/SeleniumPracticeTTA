package com.thetestingacademy.july22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class webtableStatic {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://awesomeqa.com/webtable.html");
        //Table - //table[@id='customers']
        //Rows - //table[@id='customers']/tbody/tr - total 7 row, 1 header row
        //Columns - //table[@id='customers']/tbody/tr[2]/td -  total 3 columns

        int rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int columns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

        String first_part = "//table[@id='customers']/tbody/tr[";
        String sec_part = "]/td[";
        String third_part = "]";
        System.out.println(rows+", "+columns);

        for (int i = 2; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                String dynamic_xpath = first_part+i+sec_part+j+third_part;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                //System.out.print(text+", ");
                if(data.contains("Helen Bennett")){
                    String country_path = dynamic_xpath+"/following-sibling::td";
                    String country = driver.findElement(By.xpath(country_path)).getText();
                    System.out.println("-----------");
                    System.out.println("Country if Helen Bennett is - "+country);
                }
            }
        }
        //driver.quit();
    }
}
