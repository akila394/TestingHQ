package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Planet {
    WebDriver driver;

    public Planet(WebDriver driver) {
        this.driver= driver;
    }

    public void clickExploreButton(String planetName) {

        //List<WebElement> planetList = driver.findElements(By.className("planet"));
        PlanetPage planetpage = new PlanetPage(driver);

        for (WebElement planet : planetpage.getAllPlanets()) {
            //String pName = planetpage.getPlanetName();
            String pName = planet.findElement(By.cssSelector("[class='name headline primary--text']")).getText();
            if (pName.equalsIgnoreCase(planetName)) {
                planet.findElement(By.className("v-btn__content")).click();
            }
        }

    }

    public void clickExploreButtonByDistance(long distancevalue){
        List<WebElement> planetList = driver.findElements(By.className("planet"));

        for(WebElement eachplanet: planetList){
            String distance = eachplanet.findElement(By.className("distance")).getText();
            //System.out.println(distance);
//            long numericString = Long.parseLong(distance.replaceAll("[^\\d,]", ""));
//            long value = Long.parseLong(numericString.replace(",", ""));
            String numericString = distance.replaceAll("[^\\d,]", "").replace(",", "");
            long value = Long.parseLong(numericString);
            System.out.println(value);
            if(value == distancevalue){
                eachplanet.findElement(By.className("v-btn__content")).click();
            }

        }
    }


    public WebElement popUpMessage()
    {
        By popupMessage = By.cssSelector("[class*='popup-message']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(popupMessage));
        return popupElement;
    }
}
