package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlanetPage {
    private WebDriver driver;
    WebElement planetList;
    public PlanetPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickPlanetButton(){
        driver.findElement(By.cssSelector("[aria-label='planets']")).click();
    }

    public List<WebElement> getAllPlanets(){
        List<WebElement> planetList = driver.findElements(By.className("planet"));
        return planetList;
    }

    public String getPlanetName(){
        return planetList.findElement(By.cssSelector("[class='name headline primary--text']")).getText();
    }

}
