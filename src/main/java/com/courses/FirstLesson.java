package com.courses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class FirstLesson {

    public static void main(String[] args) {
      WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
        driver.get("http://saucedemo.com");
        WebElement usernameField = driver.findElement(By.className("form_input"));
        WebElement passwordField = driver.findElement(By.xpath("//input[2]"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        List<WebElement> list = driver.findElements(By.xpath("//button"));
        WebElement addToCart = list.get(2);
        addToCart.click();

        WebElement filter = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(filter);

        List<WebElement> listOfOptions = select.getOptions();

       for(int i = 0; i < listOfOptions.size(); i++) {
        System.out.println(listOfOptions.get(i).getText());
    }
     select.selectByValue("lohi");
     select.selectByVisibleText("Price (high to low)");



    }
}
