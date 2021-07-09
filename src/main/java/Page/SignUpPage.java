package Page;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage {

	public SignUpPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id ="com.exzeo.inspectionapp:id/image_view_next")
	public AndroidElement ViewNext;
	
	@AndroidFindBy(id ="com.exzeo.inspectionapp:id/text_view_get_started")
	public AndroidElement GetStarted;
	
	@AndroidFindBy(id ="com.exzeo.inspectionapp:id/text_view_sign_up")
	public AndroidElement SignUp;
	
	@AndroidFindBy(id ="com.exzeo.inspectionapp:id/edit_text_email")
	public AndroidElement EmailId;
	
	@AndroidFindBy(id ="com.exzeo.inspectionapp:id/edit_text_password")
	public AndroidElement Password;
	
	@AndroidFindBy(id ="com.exzeo.inspectionapp:id/button_create_account")
	public AndroidElement CreateAccount;
	
	@AndroidFindBy(id ="com.exzeo.inspectionapp:id/spinner_country_code")
	public AndroidElement CountryCode;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='+91']")
	public AndroidElement cc;
	
	@AndroidFindBy(id ="com.exzeo.inspectionapp:id/edit_text_mobile_number")
	public AndroidElement MobileNumber;
	
	@AndroidFindBy(id ="com.exzeo.inspectionapp:id/button_send_verification_code")
	public AndroidElement SendVerificationCode;
	
	@AndroidFindBy(id ="com.exzeo.inspectionapp:id/text_view_positive_button")
	public AndroidElement viewPositiveButton;
	
	@AndroidFindBy(id ="android:id/message_text")
	public AndroidElement otpMessage;
	
	@AndroidFindBy(id ="com.exzeo.inspectionapp:id/edit_text_verification_code")
	public AndroidElement TextVerificationCode;
	
	@AndroidFindBy(id ="com.exzeo.inspectionapp:id/button_send_verification_code")
	public AndroidElement ButtonVerificationCode;
	
	@AndroidFindBy(id = "//android.widget.Button[@text= 'Get Started!']")
	public AndroidElement TextGetStarted;
	
	@AndroidFindBy(id ="com.exzeo.inspectionapp:id/tv_skip_continue")
	public AndroidElement SkipContinue;
	
	
}
