package Production.InspectEz;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page.SignUpPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SignUpTest extends Base{
	
	@Test
	public void signupTestCase() throws IOException, InterruptedException {
				
		AndroidDriver<AndroidElement> driver=capabilities("InspectEzApp");
		GenericUtilities gen= new GenericUtilities(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SignUpPage sup =new SignUpPage(driver);
				//com.exzeo.inspectionapp:id/button_skip
		for(int i=0; i<3;i++)
		{
		sup.ViewNext.click();
		}
		sup.GetStarted.click();
		Thread.sleep(5000);
		sup.SignUp.click();
		sup.EmailId.sendKeys("username@yopmail.com");
		sup.Password.sendKeys("Password@123");
		sup.CreateAccount.click();
		
		sup.CountryCode.click();
		sup.cc.click();
		sup.MobileNumber.sendKeys("9639495533");
		Thread.sleep(2000);
		sup.SendVerificationCode.click();
		
		Thread.sleep(5000);
		sup.viewPositiveButton.click();
		Thread.sleep(1000);
		driver.openNotifications();
		Thread.sleep(20000);
		//driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.view.ViewGroup[1]")).click();
		System.out.println(sup.otpMessage.getText());
		String Otp = sup.otpMessage.getText();
		Thread.sleep(10000);
		//System.out.println(driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.view.ViewGroup[1]")).getText());
		//String Otp=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.samsung.android.messaging:id/text_content' and @index='1']")).getText();
		System.out.println(Otp);
		String[] New= Otp.split(" ");
		String n=New[0];
		System.out.println(n);
		//Thread.sleep(10000);
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		Thread.sleep(2000);
		//driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		//System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@resource-id = 'android:id/message_text' and @contains(text(), 'JustEz verification code')]")).getText());
		
		/**
		System.out.println(driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Copy OTP\"]")).getText());
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Copy OTP\"]")).click();
		**/
		//driver.findElement(By.id("com.android.systemui:id/dismiss_view")).click();
		Thread.sleep(5000);
		AndroidElement SubmitOtp = (AndroidElement) sup.TextVerificationCode;
		SubmitOtp.sendKeys(n);
		Thread.sleep(5000);
		/**
		 Actions actions = new Actions(driver);
		 
		actions.keyDown(SubmitOtp, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		**/
		sup.ButtonVerificationCode.click();
		
		sup.TextGetStarted.click();
		
		Assert.assertEquals(sup.TextGetStarted.getText(), "Get Started!");
		
		for(int i=0;i<3;i++)
		{
		gen.waitFunc(driver, i);
		}
		
		sup.SkipContinue.click();
		driver.findElementById("username").sendKeys();
		driver.findElementById("password").sendKeys();
		driver.findElementById("loginBtn").sendKeys();		
	}

}
