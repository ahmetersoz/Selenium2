package PRoje2;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Case3 extends BaseDriver {
    @Test
    public void Case3(){

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement ebook=driver.findElement(By.cssSelector("button[onclick*='1595015']"));
        ebook.click();

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));


        WebElement debitcard=driver.findElement(By.cssSelector("[class='Payment-Button CC']"));
        debitcard.click();

        WebElement frame2 = driver.findElement(By.cssSelector("iframe[name*='privateStripeFrame']"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame2));

        WebElement kartno=driver.findElement(By.name("cardnumber"));
        kartno.sendKeys("1111111111111111");

        driver.switchTo().parentFrame();
        WebElement warningbox= driver.findElement(By.cssSelector("[name='close-circle']+span"));
        wait.until(ExpectedConditions.visibilityOf(warningbox));
        Assert.assertTrue("Hatalı Kart",warningbox.isDisplayed());
        BekleKapat();




    }
}
