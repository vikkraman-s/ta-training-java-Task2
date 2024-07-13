package com.epam.NewpasteAfterCreate;

import NewPastePageObjects.AfterNewPasteWebElements;
import NewPastePageObjects.BeforeNewPasteWebElements;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;

public class NewPasteAfterTest {
    private WebDriver driver;
    private Actions action;
    @BeforeTest
    public void start(){
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize();
        action = new Actions(driver);
        PageFactory.initElements(driver,AfterNewPasteWebElements.class);

    }
    @Test(priority = 1, description = "Enter the code and title and click create button")
    public void checkNewPaste(){
        BeforeNewPasteWebElements.code(driver).sendKeys("   git config --global user.name  \"New Sheriff in Town\"\n" +
                "            git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "            git push origin master --force\n");

        BeforeNewPasteWebElements.getDropdown(driver).click();

        WebElement getitems = BeforeNewPasteWebElements.getItem(driver);
        action.moveToElement(getitems).perform();
        getitems.click();

        BeforeNewPasteWebElements.pasteName(driver).sendKeys("how to gain dominance among developers");
        BeforeNewPasteWebElements.button(driver).click();
    }

    @Test(priority = 2,description = "After create NewPaste verify Title")
    public void AfterNewPasteTitle(){
        String actualtTitle = driver.getTitle();
        String title= "how to gain dominance among developers - Pastebin.com";
        Assert.assertEquals(actualtTitle,title);
    }
    @Test(priority = 3,description = "After create NewPaste verify code")
    public void AfterNewPasteCode(){
        String expectedCode = "   git config --global user.name  \"New Sheriff in Town\"\n" +
                "            git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "            git push origin master --force\n";
        String actualCode = AfterNewPasteWebElements.code(driver).getText();
        Assert.assertTrue("Code not contails in expected output",expectedCode.contains(actualCode));

    }

    @Test(priority = 4,description = "After create NewPaste verify syntax")
    public void AfterNewPasteSyntax(){
        String expectedSyntax = "Bash";
        String actualSyntax = AfterNewPasteWebElements.syntax(driver).getText();
        Assert.assertEquals(actualSyntax,expectedSyntax);

    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}

