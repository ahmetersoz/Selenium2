package PRoje2;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CAse5 extends BaseDriver {
    @Test
    public void Case5(){
        driver.get("https://shopdemo.e-junkie.com/");

        //Recaptcha

        WebElement contact=driver.findElement(By.xpath("//a[@class='contact']"));
        contact.click();

        WebElement name=driver.findElement(By.xpath("//input[@id='sender_name']"));
        name.sendKeys("yunus");

        WebElement email=driver.findElement(By.xpath("//input[@id='sender_email']"));
        email.sendKeys("yunus888@gmail.com");

        WebElement subject=driver.findElement(By.xpath("//input[@id='sender_subject']"));
        subject.sendKeys("Hayırlı işler");

        WebElement message=driver.findElement(By.cssSelector("[id='sender_message']"));
        message.sendKeys("Group selamlarını sunar!!!");

        WebElement sendbutton=driver.findElement(By.xpath("//*[text()='Send Message']"));
            sendbutton.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertTrue("Alert",driver.switchTo().alert().getText().contains("Recaptcha"));
        BekleKapat();




    }
}
