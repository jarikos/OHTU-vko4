
package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8080");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        System.out.println( driver.getPageSource() );
        // make logout
        element = driver.findElement(By.linkText("logout"));
        element.click();
        // login again with wrong password
        element = driver.findElement(By.linkText("login"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("appek");
        element = driver.findElement(By.name("login"));
        element.submit();
        System.out.println( driver.getPageSource() );
        driver.get("http://localhost:8080");
        // make logout
//        element = driver.findElement(By.linkText("logout"));
//        element.click();
        // login again with wrong password
        element = driver.findElement(By.linkText("login"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("seppo");
        element = driver.findElement(By.name("password"));
        element.sendKeys("reppu");
        element = driver.findElement(By.name("login"));
        element.submit();
        System.out.println( driver.getPageSource() );
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("seppo");
        element = driver.findElement(By.name("password"));
        element.sendKeys("reppu2012");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("reppu2012");
        element = driver.findElement(By.name("add"));
        element.submit();
        System.out.println( driver.getPageSource() );
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("teppo");
        element = driver.findElement(By.name("password"));
        element.sendKeys("reppu2012");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("reppu2012");
        element = driver.findElement(By.name("add"));
        element.submit();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.linkText("login"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("teppo");
        element = driver.findElement(By.name("password"));
        element.sendKeys("reppu2012");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        
        
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        
    }
}
