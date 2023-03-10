package PRoje2;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Case4 extends BaseDriver {
    @Test
    public void Case4(){
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement ebookAdd=driver.findElement(By.cssSelector("button[onclick*='1595015']"));
        ebookAdd.click();

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        WebDriverWait waitbutton =new WebDriverWait(driver, Duration.ofSeconds(50));

        waitbutton.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));



        WebElement debitcard=driver.findElement(By.cssSelector("[class='Payment-Button CC']"));
        debitcard.click();

        WebElement Email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        Email.sendKeys("yunus888@gmail.com");

        WebElement ConfirmEmail = driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        ConfirmEmail.sendKeys("yunus888@gmail.com");

        WebElement name = driver.findElement(By.xpath("  //input[@placeholder='Name On Card']   "));
        name.sendKeys("yunus");

        WebElement phone = driver.findElement(By.xpath("(//input[@placeholder='Optional'])[1]\n "));
       phone.sendKeys("5387553204");

        WebElement company = driver.findElement(By.xpath("(//input[@placeholder='Optional'])[2]"));
        company.sendKeys("ilkis");

        WebElement frame2 = driver.findElement(By.cssSelector("iframe[name*='privateStripeFrame']"));
        waitbutton.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame2));

        WebElement cardnumber=driver.findElement(By.name("cardnumber"));
        cardnumber.sendKeys("42424242424242421026325");
        driver.switchTo().parentFrame();


        WebElement paybutton=driver.findElement(By.cssSelector("button[class='Pay-Button']"));
        paybutton.click();
        waitbutton.until(ExpectedConditions.urlContains("www.fatfreecartpro.com"));


        WebElement warningmessage= waitbutton.until(ExpectedConditions.visibilityOfElementLocated(By.className("green_text_margin")));
        Assert.assertTrue("",warningmessage.getText().contains("order is confirmed."));
        BekleKapat();

    }
}
