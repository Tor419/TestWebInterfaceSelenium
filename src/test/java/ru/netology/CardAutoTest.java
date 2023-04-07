package ru.netology;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardAutoTest {
    private WebDriver driver;

    @AfterAll
    static void setUpAll() {
        System.setProperty("driver.chrome.driver", "./driver/chromedriver_win/chromedriver.exe");
    }
    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*")
        driver = new ChromeDriver();
    }
    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }
    @Test
    void shouldTestSomething() {
        driver.get("http://localhost:9999/");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        inputs.get(0).sendKeys("Сидоров Иван");
        inputs.get(1).sendKeys("+79856239080");
        driver.findElement(By.className("Checkbox")).click();
        driver.findElement(By.tagName("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.className("paragraph paragraph_theme_alfa-on-white")).getText();
        assertEquals(expected, actual);
    }
}
