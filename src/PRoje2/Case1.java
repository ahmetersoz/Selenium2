package PRoje2;

import Utlity.BaseDriver;
import com.google.common.annotations.VisibleForTesting;
import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Case1 extends BaseDriver {

   @Test
    public void Case1() {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement ebook = driver.findElement(By.cssSelector("button[onclick*='1595015']"));
        ebook.click();

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        WebDriverWait waitbutton = new WebDriverWait(driver, Duration.ofSeconds(5));

        waitbutton.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));


        WebElement addPro = driver.findElement(By.xpath("//button[text()='Add Promo Code']"));
        waitbutton.until(ExpectedConditions.visibilityOf(addPro));
        addPro.click();

        WebElement promo = driver.findElement(By.className("Promo-Code-Value"));
        promo.sendKeys("ahmetersz");
        WebElement promoCodeBut = driver.findElement(By.className("Promo-Apply"));
        promoCodeBut.click();
        WebElement uyarı = driver.findElement(By.xpath("//span[text()='Invalid promo code']"));
        Assert.assertTrue(uyarı.isDisplayed());

        BekleKapat();
   }


}