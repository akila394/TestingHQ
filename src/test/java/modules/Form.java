package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Form {

    WebDriver driver;
    public Form(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void clickState(String state) {
        driver.findElement(By.cssSelector("[class='v-select__selections']")).click();

        List<WebElement> states = driver.findElements(By.cssSelector("[class='v-list-item__title']"));
        for(WebElement eachstate : states){
            if(eachstate.getText().equalsIgnoreCase(state)){
                eachstate.click();
            }
        }
    }

    public void clickAgree() {
        driver.findElement(By.cssSelector("[class='v-input--selection-controls__ripple']")).click();
    }

    public void clickSubmit() {
        List<WebElement> formElements= driver.findElements(By.cssSelector("[class='v-btn__content']"));
        for(WebElement eachformElement: formElements){
            if(eachformElement.getText().equalsIgnoreCase("submit")){
                eachformElement.click();
                break;
            }
        }
    }
}
