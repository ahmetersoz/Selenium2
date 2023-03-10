package PRoje2;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Case2 extends BaseDriver {
    @Test
    public void Case2(){

        driver.get("https://shopdemo.e-junkie.com/");


        WebElement ebook = driver.findElement(By.cssSelector("button[onclick*='1595015']"));
        ebook.click();

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        WebDriverWait waitbutton = new WebDriverWait(driver, Duration.ofSeconds(5));

        waitbutton.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));

            WebElement debit=driver.findElement(By.xpath("//*[@data-option='CC']"));
            debit.click();
            WebElement payBut=driver.findElement(By.cssSelector("[class='Pay-Button']"));
            payBut.click();
            WebElement warning=driver.findElement(By.cssSelector("[name='close-circle']+span"));
            waitbutton.until(ExpectedConditions.visibilityOf(warning));
        Assert.assertTrue("Mesaj Görüntülenemedi",warning.isDisplayed());
        BekleKapat();

    }
}
