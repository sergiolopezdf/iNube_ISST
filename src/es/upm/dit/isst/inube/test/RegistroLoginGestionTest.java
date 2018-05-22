package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistroLoginGestion {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRegistroLoginGestion() throws Exception {
    driver.get("http://localhost:8080/inube/");
    driver.findElement(By.name("Login")).click();
    driver.findElement(By.linkText("¿No eres usuario? Regístrate")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Bar Manolo");
    driver.findElement(By.name("cp")).click();
    driver.findElement(By.name("cp")).clear();
    driver.findElement(By.name("cp")).sendKeys("28029");
    driver.findElement(By.id("wrapper")).click();
    driver.findElement(By.name("merchantId")).click();
    driver.findElement(By.name("merchantId")).clear();
    driver.findElement(By.name("merchantId")).sendKeys("2");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("2");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.linkText("Gestión de Perfil")).click();
    driver.findElement(By.linkText("iNube")).click();
    driver.findElement(By.linkText("Gestión de Perfil")).click();
    driver.findElement(By.xpath("//div[@id='contentWrapper']/div")).click();
    driver.findElement(By.xpath("//div[@id='contentWrapper']/div/div/table/tbody/tr[3]/td")).click();
    driver.findElement(By.xpath("//div[@id='contentWrapper']/div/div/table/tbody/tr[3]/th")).click();
    driver.findElement(By.xpath("//div[@id='contentWrapper']/div/div/table/tbody/tr[3]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
