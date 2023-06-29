package com.tests;

import modules.Planet;
import modules.PlanetPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PlanetClass {

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        driver.manage().window().maximize();
    }
    @Test
    public void getPlanetExploreTest(){

        PlanetPage planetpage = new PlanetPage(driver);
        Planet planet = new Planet(driver);
        planetpage.clickPlanetButton();
        //planetpage.clickExploreButton("Earth");
        planet.clickExploreButton("Earth");
        Assertions.assertEquals("Exploring Earth", planet.popUpMessage().getText());


        //List<WebElement> planetList = driver.findElements(By.className("planet"));


//        for(WebElement planet : planetpage.getAllPlanets()){
//           String planetName =  planet.findElement(By.cssSelector("[class='name headline primary--text']")).getText();
//           if(planetName.equalsIgnoreCase("Earth")){
//               planet.findElement(By.className("v-btn__content")).click();
//           }
//        }

    }

    @Test
    public void clickPlanetByDistanceTest(){
        PlanetPage planetpage = new PlanetPage(driver);
        Planet planet = new Planet(driver);
        planetpage.clickPlanetButton();
//        List<WebElement> planetList = driver.findElements(By.className("planet"));
//
//        for(WebElement eachplanet: planetList){
//            String distance = eachplanet.findElement(By.className("distance")).getText();
//            //System.out.println(distance);
//            String numericString = distance.replaceAll("[^\\d,]", "");
//            String value = numericString.replace(",", "");
//            System.out.println(value);
//            if(eachplanet.findElement(By.className("distance")).getText().
//                    equalsIgnoreCase("1,434,000,000 km")) {
//                eachplanet.findElement(By.className("v-btn__content")).click();
//            }
//        }
        planet.clickExploreButtonByDistance(1434000000);
        Assertions.assertEquals("Exploring Saturn", planet.popUpMessage().getText());
    }



    @AfterEach
    public void cleanUp(){

    }
}
