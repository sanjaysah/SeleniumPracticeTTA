package com.thetestingacademy.july22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class webtableDynamic {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/webtable1.html");

        /*// Solution 1:
        int rows = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr")).size();
        int cols = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[1]/td")).size();

        String first_path = "//table[@class='tsc_table_s13']/tbody/tr[";
        String second_path = "]/td[";
        String third_path = "]";

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                String dynamic_path = first_path+i+second_path+j+third_path;
                String data = driver.findElement(By.xpath(dynamic_path)).getText();
                if(data.contains("Taiwan")){
                    String City_path = dynamic_path+"/following-sibling::td";
                    String city = driver.findElement(By.xpath(City_path)).getText();
                    System.out.println("City of Taiwan is - "+city);
                    break;
                }
            }
        }*/

        // Solution 2:
        WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']"));
        List<WebElement> rowsElements = table.findElements(By.tagName("tr"));

        for (int i = 1; i < rowsElements.size(); i++) {
            List<WebElement> colsElements = rowsElements.get(i).findElements(By.tagName("td"));
            for (WebElement e:colsElements) {
                System.out.println(e.getText()+", ");
                if(e.getText().contains("Taiwan")){
                    String city = colsElements.get(1).getText();
                    System.out.println("City of Taiwan is - "+city);
                    //break;
                }
            }
        }

        //driver.quit();
    }
}
