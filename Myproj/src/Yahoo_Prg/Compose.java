package Yahoo_Prg;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import Yahoo_prop.ComposeP;
import Yahoo_prop.LoginP;
import junit.framework.Assert;

public class Compose extends MainClass
{
 public void sendmail() throws Exception
 {
	 Thread.sleep(5000);
	 driver.findElement(By.xpath(ComposeP.xcompose)).click();
	 Thread.sleep(5000);
	 try
	 {
		 if(driver.findElement(By.name(ComposeP.ito)).isDisplayed())
		 {
			 System.out.println("hello");

			 System.out.println("Anu");

			 System.out.println("this is new line");
<<<<<<< HEAD
			 System.out.println("dfsdfsdfs");
=======

>>>>>>> branch 'master' of https://github.com/batch2991/mr1.git
			 //Reporter.log("<font color='green'><b>Compose is working</b></font>");
			 log=ext.createTest("Compose_Sendmail");
			 log.log(Status.PASS,"Compose is Working");
			 File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(f,new File("d:\\mar_2020\\images\\compose.png"));
			 log.addScreenCaptureFromPath("d:\\\\mar_2020\\\\images\\\\compose.png");
			 driver.findElement(By.id(ComposeP.ito)).sendKeys("abcd@gmail.com");
			 driver.findElement(By.id(ComposeP.isub)).sendKeys("testmail");
			 driver.findElement(By.id(ComposeP.ibody)).sendKeys("This is sample message in the body");
			 driver.findElement(By.xpath(ComposeP.xsend)).click();
			 Thread.sleep(5000);
		 }
	 }
	 catch(Exception e)
	 {
		//Reporter.log("<font color='red'><b>Compose NOT working</b></font>");
		 log=ext.createTest("Compose_Sendmail");
		 log.log(Status.FAIL,"Compose NOT Working");
		 File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(f,new File("d:\\mar_2020\\images\\compose.png"));
		 log.addScreenCaptureFromPath("d:\\\\mar_2020\\\\images\\\\compose.png");
	 }	 
 }
 public void close()
 {
	 driver.findElement(By.linkText(LoginP.lsignout)).click();
	 driver.close();
 }
}
