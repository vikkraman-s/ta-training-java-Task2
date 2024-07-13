package NewPastePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfterNewPasteWebElements {

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/ol/li[1]/div")
    public static WebElement codeElement;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/a[1]")
    public static WebElement syntaxElement;

    public static WebElement code(WebDriver driver) {
        return codeElement;
    }

    public static WebElement syntax(WebDriver driver) {
        return syntaxElement;
    }
}
