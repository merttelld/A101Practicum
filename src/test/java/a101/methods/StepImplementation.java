package a101.methods;

import a101.driver.BaseTest;
import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.logging.LogManager;

public class StepImplementation extends BaseTest {

    JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

    @Step("<seconds> kadar bekle")
    public void waitForSecond(int second) throws InterruptedException {
        Thread.sleep(1000 * second);
    }

    @Step("<key> id li elemente tıkla")
    public void clickElementById(String key) {
        driver.findElement(By.id(key)).click();
    }

    @Step("<key> Css li elemente tıkla")
    public void clickElementByCss(String key) {
        driver.findElement(By.cssSelector(key)).click();
    }

    @Step("<key> Xpath li elemente tıkla")
    public void clickElementByXpath(String key) {
        driver.findElement(By.xpath(key)).click();
        System.out.println(key + "Elemente tiklandi");
    }

    @Step("<key> Sayfayı aşağı kaydır")
    public void scrollWithAction(String key) {
        WebElement webElement = driver.findElement(By.xpath(key));
        jsDriver.executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
                webElement);
        System.out.println("Scroll yapildi");
    }

    @Step("<key>li ürünün siyah olduğu doğrulanır")
    public void assertionProduct(String key) {
        Assertions.assertTrue(driver.findElement(By.xpath(key)).getText().contains("Siyah"), "Ürün bulunamadı");
        System.out.println("Urunun siyah oldugu dogrulandi");
    }

    @Step("<key> e <text> gir")
    public void sendKeys(String key, String text) {
        driver.findElement(By.xpath(key)).sendKeys(text);
        System.out.println("Sendkeys islemi basarili");
    }

    @Step("<key> ile <text> sayfa kontrolu")
     public void assertionPaymentPage(String key, String text) {
        Assertions.assertTrue(driver.findElement(By.xpath(key)).getText().contains(text),"İfadeler esit degil");
     }

    @Step("<key> Xpath li elemente tıkla2")
    public void clickElementByXpath2(String key) {
        JavascriptExecutor executor = (JavascriptExecutor)driver; executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(key)));
        System.out.println(key + "Elemente tiklandi");
    }
}
