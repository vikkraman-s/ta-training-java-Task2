package NewPastePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BeforeNewPasteWebElements {

    public static WebElement code(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id=\"postform-text\"]"));
    }

    public static WebElement getDropdown(WebDriver driver) {
        return driver.findElement(By.xpath("(//span[@class='selection'])[2]"));
    }

    public static WebElement getItem(WebDriver driver) {
        return driver.findElement(By.xpath("(//ul/li[text()='Bash'])[1]"));
    }

    public static WebElement pasteName(WebDriver driver){
        return  driver.findElement(By.xpath("//*[@id=\"postform-name\"]"));
    }

    public static WebElement button(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[10]/button"));
    }
}
