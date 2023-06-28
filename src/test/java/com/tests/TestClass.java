package com.tests;

import modules.Form;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestClass {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setup() {
        browserSetup();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        driver.manage().window().maximize();
    }

    @Test
    public void clickmeDownTest() {

        WebElement element = driver.findElement(By.cssSelector(
                "[class*='v-btn v-btn--block']"));
        element.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(element,
                "CLICK ME UP!"));

        Assertions.assertEquals(element.getText(), "CLICK ME UP!");
    }

    @Test
    public void fillFormText() throws InterruptedException {


        //Given

        //When
        driver.findElement(By.cssSelector("[aria-label='forms']")).click();
        Form form = new Form(driver);
        form.enterName("Akila");
        form.enterEmail("akila@gmail.com");
        form.clickState("vic");
        form.clickAgree();
        form.clickSubmit();

        //Then

        By popupMessageLocator= By.cssSelector("[class*='popup-message']");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(popupMessageLocator));

        String actualText = driver.findElement(popupMessageLocator).getText();
        Assertions.assertEquals("Thanks for your feedback Akila", actualText);

    }

    @Test
    public void planetTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("[aria-label='planets']")).click();

        List<WebElement> planetNames = driver.findElements(By.cssSelector("h2[class='name headline primary--text']"));
        List<WebElement> planets = driver.findElements(By.cssSelector("[class='v-btn__content']"));

        boolean found = false;

        for (int i = 0; i < Math.min(planetNames.size(), planets.size()); i++) {
            WebElement planet = planets.get(i);
//            System.out.println(planets.size());
//            System.out.println(planetNames.size());
            WebElement planetName = planetNames.get(i);

            if (planetName.getText().equalsIgnoreCase("Earth")) {
                planet.click();
                found = true;
                break;
            }

        }
        Thread.sleep(3000);
        if (!found == true) {
            System.out.println("Earth planet not found.");
        }
    }


    private void browserSetup()
    {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
