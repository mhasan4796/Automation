import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sun.tools.tree.FinallyStatement;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SeleniumTest
{

	WebDriver dr;
	String cPath="/Users/mhasan/Downloads/chromedriver";
	String cDriver="webdriver.chrome.driver";
	String url="http://www.macys.com";
	String url1="http://www.amazon.com";
	String home,bedBath,women,activeWear,productSelction,size,selectBox,quantity,addTobag,myBag,chekout;


	@BeforeClass
	public void start() throws InterruptedException
	{

		System.setProperty(cDriver,cPath);
		dr= new ChromeDriver();
		Thread.sleep(500);
		dr.manage().window().maximize();
		home="./*//*[@id='flexLabel_22672']/a";
		bedBath="./*//*[@id='flexLabel_7495']/a";
		women="./*//*[@id='flexLabel_118']/a";
		activeWear=".//*[@id='firstNavSubCat']/li[3]/ul/li[1]/a";
		productSelction=".//*[@id='3468483']/div[1]/div[2]/div[1]/a";
		size= ".//*[@id='orderPanel3468483']/div[2]/div[2]/div[1]/ul/li[3]/div";
		selectBox=".//*[@id='orderPanel3468483']/div[5]/div[1]/div[1]/form/select";
		quantity=".//*[@id='orderPanel3468483']/div[5]/div[1]/div[1]//option[1]";//selectByXpath
		addTobag=".//*[@id='orderPanel3468483']/div[5]/div[1]/div[2]/button";
		myBag=".//*[@id='checkoutLink']";//
		chekout=".//*[@id='continueCheckout']";

	}
    @Test()
	public void test1() throws InterruptedException, IOException, AWTException {

		dr.get(url);
		dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//dr.findElement(By.xpath("./*//*[@id='flexLabel_22672']/a")).click();//click
		System.out.println("TEST 1");



		WebElement ele = dr.findElement(By.xpath(home));

		Actions action = new Actions(dr);

		//action.moveToElement(ele).moveToElement(dr.findElement(By.xpath(bedBath))).click().build().perform();

		try
		{
			action.moveToElement(ele).moveToElement(dr.findElement(By.xpath(bedBath))).moveToElement(dr.findElement(By.xpath(women))).click().build().perform();
		}
		catch(Exception e)
		{
			dr.navigate().back();
			dr.findElement(By.xpath(women)).click();
		}
		finally
		{
			System.out.println("pass women cloth ");
			dr.findElement(By.xpath(activeWear)).click();
			System.out.println("pass active ");

			dr.findElement(By.xpath(productSelction)).click();
			Thread.sleep(20);
			System.out.println("pass product");
			dr.findElement(By.xpath(size)).click();
			dr.findElement(By.xpath(selectBox)).click();
			Thread.sleep(50);
			dr.findElement(By.xpath(quantity)).click();
			dr.findElement(By.xpath(addTobag)).click();System.out.println("pass addToBag");
			Thread.sleep(20);
			dr.findElement(By.xpath(myBag)).click(); System.out.println("pass myBag");
            Thread.sleep(20);
			dr.findElement(By.xpath(chekout)).click();
            Thread.sleep(5);
			System.out.println("testscript successful ");
			dr.navigate().to(url1);
            System.out.println("my current url now :"+dr.getCurrentUrl());
        }




		//have to see how to work with multple window like hover over
    }



   /* public void currentDate()
    {   DateFormat dateFormat;
        Date date = new Date();
        dateFormat = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
        System.out.println(dateFormat.format(date));
        String date1= dateFormat.format(date);
        System.out.println("current time  now"+date1);//actual time
        System.out.println("my current time  now :"+date.getTime());//it gives a random number
    }

    public void screenShot() throws AWTException, IOException
    {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        Robot robot = new Robot();
        String format = "jpg";
        String fileName = "FullScreenshot." + format;

        BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
        ImageIO.write(screenFullImage, format, new File(fileName));

        System.out.println("A full screenshot saved!");
    }*/

	/*@Test
	public void febonaciSeries()
	{
		int a,b,c;
			a=0;
			b=1;
			c= a+b;
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);

			while(c>89)
			{
			a=b;
			b=c;
			c=a+b;

			System.out.println(c);
			System.out.println("c is in while loop");
			}
	}*/

	@AfterClass
	public void end()
	{
		dr.close();
	}



}
