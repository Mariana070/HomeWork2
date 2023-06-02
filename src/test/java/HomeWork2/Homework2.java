package HomeWork2;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Homework2 {
    @Test
    public void homework2() {

/*
       Navigate to
"http://secure.smartbearsoftware.com/samples/Te
stComplete11/WebOrders/Login.aspx?"
Validate the title is equals to "Web Orders Login"
Input username "Tester"
Input password "test"
Click login button
Validate the title is equals to "Web Orders"
Validate header is equals to "List of All Orders"
        */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();

        String actualTitleWEbOrders = driver.getTitle().trim();
        String expectedTitleWebOrder = "Web Orders";
        Assert.assertEquals(expectedTitleWebOrder, actualTitleWEbOrders);
        WebElement header = driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(BrowserUtils.getText(header), "List of All Orders");

    }
    @Test
    public void testCase2() throws InterruptedException {


       /*
    Navigate to
"http://secure.smartbearsoftware.com/samples/TestCo
mplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "View all products" button
Validate "View all products" is selected
Validate header is equals to "List of Products"
Validate the url has "Products" keyword
     */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        WebElement viewAllProduct=driver.findElement(By.linkText("View all orders"));
        viewAllProduct.click();
        Thread.sleep(2000);
        viewAllProduct=driver.findElement(By.linkText("View all orders"));
        Assert.assertTrue(viewAllProduct.isSelected());
        WebElement headerListOfProduct = driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(BrowserUtils.getText(headerListOfProduct),"List of Products");
        String url = driver.getCurrentUrl();
      Assert.assertTrue(url.contains("Products"));

    }
    @Test
    public void testCase3(){
        /*
    Navigate to
"http://secure.smartbearsoftware.com/sample
s/TestComplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Find the links for
View all orders
View all products
Orders
Validate their href values are equals to :
"Default.aspx"
"Products.aspx"
"Process.aspx"
     */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        WebElement viewAllOrders = driver.findElement(By.linkText("View all orders"));
        WebElement viewAllProducts = driver.findElement(By.linkText("View all products"));
        WebElement order= driver.findElement(By.linkText("Order"));

        System.out.println(viewAllOrders.getAttribute("href").contains("Default.aspx"));
        System.out.println(viewAllProducts.getAttribute("href").contains("Products.aspx"));
        System.out.println(order.getAttribute("href").contains("Process.aspx"));
    }
    @Test
    public void testCase4() {
        /*
        Navigate to
"http://secure.smartbearsoftware.com/samples/TestComplete11
/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "Order" button
Select product "Screen Saver"
Input quantity 5
Input Customer name "CodeFish IT School"
Input Street "2200 E devon"
Input City "Des Plaines"
Input State "Illinois"
Input Zip "60018"
Select MasterCard
Input card number "444993876233"
Input expiration date "03/24"
Click Process button
     */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        WebElement order = driver.findElement(By.linkText("Order"));
        order.click();
        WebElement product = driver.findElement(By.tagName("select"));
        BrowserUtils.selectBy(product, "ScreenSaver", "text");
        WebElement quantity = driver.findElement(By.xpath("//input[@onchange='productsChanged()']"));
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.xpath("//li[1]//input"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.xpath("//ol[2]//li[2]//input"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.xpath("//ol[2]//li[3]//input"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.xpath("//ol[2]//li[4]//input"));
        state.sendKeys("Illinois");
        WebElement zipCode = driver.findElement(By.xpath("//ol[2]//li[5]//input"));
        zipCode.sendKeys("60018");
        WebElement masterCard = driver.findElement(By.xpath("//li//input[@value=\"MasterCard\"]"));
        masterCard.click();
        WebElement cardNr = driver.findElement(By.xpath("//ol[3]/li[2]/input"));
        cardNr.sendKeys("444993876233");
        WebElement expirationDate = driver.findElement(By.xpath("//ol[3]/li[3]/input"));
        expirationDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.cssSelector(".btn_light"));
        processButton.click();

        /*
Validate text "New order has been successfully
added." is displayed below the Process button.
Click View all orders button
Validate new order is added and all inputs are
matching with new order
 */

        WebElement  successfulOrder= driver.findElement(By.tagName("strong"));
        Assert.assertEquals(BrowserUtils.getText(successfulOrder),"New order has been successfully added.");
        WebElement viewAllOrders = driver.findElement(By.linkText("View all orders"));
        viewAllOrders.click();
        List<WebElement>actualList= driver.findElements(By.xpath("//tr[2]//td"));
        List<String>expectedList = Arrays.asList("CodeFish IT School","ScreenSaver","5","06/02/2023","2200 E devon","Des Plaines","Illinois","60018","MasterCard","444993876233","03/24");
        for (int i = 1,j=0; i <actualList.size()-1 ; i++,j++){
            Assert.assertEquals(BrowserUtils.getText(actualList.get(i)),expectedList.get(j));

        }

    }

}
