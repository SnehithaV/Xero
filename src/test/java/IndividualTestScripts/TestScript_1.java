package IndividualTestScripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import TestScripts.ReusableMethods;

public class TestScript_1 extends ReusableMethods {
	
	public static void TestScript_1() throws IOException {
		createTestScriptReport("TestCase_1");
		initializeDriver("firefox");
		driver.get("https://login.xero.com/");
		logger.log(Status.INFO,"Xero login page opened");
		WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
		enterText(userName, "UserName", "varanasi.snehitha@gmail.com");
		logger.log(Status.INFO, "Data entered in Username field");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, "Password", "Chinnu24$");
		logger.log(Status.INFO, "Data entered in Password field");
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickElement(login, "Login");
		logger.log(Status.INFO, "Login button clicked");
		//closeDriver();
	}
	public static void TestScript_2() throws IOException {
		String expectedData = "Your email or password is incorrect";
		createTestScriptReport("TestCase_2");
		initializeDriver("firefox");
		driver.get("https://login.xero.com/");
		logger.log(Status.INFO,"Xero login page opened");
		WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
		enterText(userName, "UserName", "User@gmail.com");
		logger.log(Status.INFO, "Data entered in Username field");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, "Password", "pwd");
		logger.log(Status.INFO, "Data entered in Password field");
		WebElement login = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickElement(login, "Login");
		logger.log(Status.INFO, "Login button clicked");
		WebElement errorMessage=driver.findElement(By.xpath("//div[@class='x-boxed warning']//p"));
		String errordata = errorMessage.getText();
		System.out.println(errordata);
		verifyText(errorMessage, "errordata", expectedData);
		logger.log(Status.INFO, "verified the text");
		System.out.println("completed");
		closeDriver();
	}
	
	public static void TestScript_3() throws IOException{
		createTestScriptReport("TestCase_3");
		initializeDriver("firefox");
		driver.get("https://login.xero.com/");
		logger.log(Status.INFO,"Xero login page opened");
		WebElement forgotPassword= driver.findElement(By.className("forgot-password-advert"));
		clickElement(forgotPassword, "Forgot Password ");
		logger.log(Status.INFO, "forgot password link clicked");
		WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']	"));
		enterText(userName, "UserName", "varnasi.snehitha@gmail.com");
		logger.log(Status.INFO, "Data entered in Username field");
		WebElement sendLink = driver.findElement(By.xpath("//span[@class='text']"));
		clickElement(sendLink, "Send Link");
		logger.log(Status.INFO, "Send Link clicked");
		closeDriver();
	}
	
	public static void TestScript_4() throws IOException {
		createTestScriptReport("TestCase_4");
		initializeDriver("firefox");
		driver.get("https://www.xero.com/us/");
		logger.log(Status.INFO, "Xero Website page opened");
		WebElement freeTrial = driver.findElement(By.xpath("//a[@class='hero-btn hero-btn-1 hero-cta btn btn-primary']"));
		clickElement(freeTrial, "Try Xero for Free");
		logger.log(Status.INFO, "Free Trial link Clicked");
		WebElement firstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
		enterText(firstName, "First Name", "Snehitha");
		logger.log(Status.INFO, "data enter in the text field");
		WebElement lastName = driver.findElement(By.xpath("//input[@name='LastName']"));
		enterText(lastName, "Last Name", "Varanasi");
		logger.log(Status.INFO, "data enter in the text field");
		WebElement email = driver.findElement(By.xpath("//input[@name='EmailAddress']"));
		enterText(email, "email", "varanasi.snehitha@gmail.com");
		logger.log(Status.INFO, "data enter in the text field");
		WebElement phone = driver.findElement(By.xpath("//input[@name='PhoneNumber']"));
		enterText(phone, "Phone", "1234567834");
		logger.log(Status.INFO, "data enter in the text field");
		WebElement dropDown = driver.findElement(By.xpath("//select[@name='LocationCode']"));
		Select select = new Select(dropDown);
		select.selectByVisibleText("India");
		logger.log(Status.INFO, "country name selected");
		WebElement checkBox = driver.findElement(By.xpath("//input[@value='true']"));
		clickElement(checkBox, "Check box");
		logger.log(Status.INFO, "Check box selected");
		WebElement getStarted = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		if(getStarted.isEnabled()) {
		clickElement(getStarted, "Get Started");
		}
		else {
			System.out.println("Not able to click");
		}
		logger.log(Status.INFO, "Get Started Clicked");
		closeDriver();
	}
	
	public static void TestScript_5() throws IOException{
		createTestScriptReport("TestCase_5");
		initializeDriver("firefox");
		driver.get("https://www.xero.com/us/");
		logger.log(Status.INFO, "Xero Website page opened");
		WebElement freeTrial = driver.findElement(By.xpath("//a[@class='hero-btn hero-btn-1 hero-cta btn btn-primary']"));
		clickElement(freeTrial, "Try Xero for Free");
		logger.log(Status.INFO, "Free Trial link Clicked");
		WebElement getStarted = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickElement(getStarted, "Get Started");
		logger.log(Status.INFO, "Get Started Clicked");
		String message1="First name can't be empty";
		String message2="Last name can't be empty";
		String message3 ="Email address can't be empty";
		String message4 = "Phone number can't be empty";
		WebElement errorMessage1=driver.findElement(By.xpath("//span[@id='signup-form-error-message-1']"));
		verifyText(errorMessage1, "Error1", message1);
		logger.log(Status.INFO, "Error1 verified");
		WebElement errorMessage2=driver.findElement(By.xpath("//span[@id='signup-form-error-message-2']"));
		verifyText(errorMessage2, "Error2", message2);
		logger.log(Status.INFO, "Error2 verified");
		WebElement errorMessage3=driver.findElement(By.xpath("//span[@id='signup-form-error-message-3']"));
		verifyText(errorMessage3, "Error3", message3);
		logger.log(Status.INFO, "Error3 verified");
		WebElement errorMessage4=driver.findElement(By.xpath("//span[@id='signup-form-error-message-4']"));
		verifyText(errorMessage4, "Error4", message4);
		logger.log(Status.INFO, "Error4 verified");
		WebElement email = driver.findElement(By.xpath("//input[@name='EmailAddress']"));
		enterText(email, "email", "one");
		logger.log(Status.INFO, "data enter in the text field");
		String emailError="Email address is invalid";
		WebElement emailErrorMessage = driver.findElement(By.xpath("//span[@id='signup-form-error-message-1']"));
		verifyText(emailErrorMessage, "Email error", emailError);
		logger.log(Status.INFO, "Email error verified");
		WebElement getStarted1 = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickElement(getStarted, "Get Started");
		logger.log(Status.INFO, "Get Started Clicked");
		closeDriver();
	}

	public static void TestScript_6() throws IOException {
		createTestScriptReport("TestCase_6");
		initializeDriver("firefox");
		driver.get("https://www.xero.com/us/");
		logger.log(Status.INFO, "Xero Website page opened");
		WebElement freeTrial = driver.findElement(By.xpath("//a[@class='hero-btn hero-btn-1 hero-cta btn btn-primary']"));
		clickElement(freeTrial, "Try Xero for Free");
		logger.log(Status.INFO, "free trial link Clicked");
		
		String oldWindow = driver.getWindowHandle(); 
		Set<String> getAllWindows = driver.getWindowHandles();
		WebElement termsCheckBox = driver.findElement(By.xpath("//a[contains(text(),'terms of use')]"));
		clickElement(termsCheckBox, "terms and conditions link");
			
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[0]);
		driver.switchTo().window(oldWindow);
		
		logger.log(Status.INFO, "terms and conditions link Clicked");
		
		WebElement privacy = driver.findElement(By.xpath("//a[contains(text(),'privacy notice')]"));
		clickElement(privacy, "privacy link");
		logger.log(Status.INFO, "privacy link Clicked");
		closeDriver();
		}
	
	public static void TestScript_7() throws IOException {
		createTestScriptReport("TestCase_6");
		initializeDriver("firefox");
		driver.get("https://www.xero.com/us/");
		logger.log(Status.INFO, "Xero Website page opened");
		WebElement freeTrial = driver.findElement(By.xpath("//a[@class='hero-btn hero-btn-1 hero-cta btn btn-primary']"));
		clickElement(freeTrial, "Try Xero for Free");
		logger.log(Status.INFO, "free trial link Clicked");
		WebElement offerslink = driver.findElement(By.xpath("//a[contains(text(),'offer details')]"));
		clickElement(offerslink, "offers link");
		logger.log(Status.INFO, "offerslink Clicked");
		closeDriver();
	}
	public static void TestScript_8() throws IOException {
		createTestScriptReport("TestCase_6");
		initializeDriver("firefox");
		driver.get("https://www.xero.com/us/");
		logger.log(Status.INFO, "Xero Website page opened");
		WebElement freeTrial = driver.findElement(By.xpath("//a[@class='hero-btn hero-btn-1 hero-cta btn btn-primary']"));
		clickElement(freeTrial, "Try Xero for Free");
		logger.log(Status.INFO, "free trial link Clicked");
		WebElement accountant = driver.findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"));
		clickElement(accountant, "accountant link");
		logger.log(Status.INFO, "accountant link Clicked");
		//closeDriver();
	}
	public static void TestScript_9() throws IOException {
		TestScript_1();
		WebElement dashboard = driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]"));
		clickElement(dashboard, "Dashboard");
		logger.log(Status.INFO, "Clicked on Dashboard");
		System.out.println("Dashboard clicked");
		WebElement accounts = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[1]/ul/li[2]/a"));
		clickElement(accounts, "Accounts");
		logger.log(Status.INFO, "Accounts drop down clicked");
		System.out.println("Accounts clicked");
		WebElement reports = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[5]/a[1]"));
		clickElement(reports, "Accounts");
		logger.log(Status.INFO, "Reports drop down clicked");
		System.out.println("Reports clicked");
		WebElement contacts = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[6]/a[1]"));
		clickElement(contacts, "Contacts");
		logger.log(Status.INFO, "Contacts drop down clicked");
		System.out.println("Contacts clicked");
		WebElement settings = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[7]/a[1]"));
		clickElement(settings, "Settings");
		logger.log(Status.INFO, "settings drop down clicked");
		System.out.println("Settings clicked");
		WebElement plus = driver.findElement(By.xpath("//a[@id='quicklaunchTab']"));
		clickElement(plus, "Settings");
		logger.log(Status.INFO, "new drop down clicked");
		System.out.println("new clicked");
//		WebElement files = driver.findElement(By.xpath("//a[@class='files']"));
//		clickElement(files, "Settings");
//		logger.log(Status.INFO, "files drop down clicked");
//		System.out.println("files clicked");
		WebElement notification = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]/li[3]/a[1]"));
		clickElement(notification, "notification");
		driver.switchTo().frame("post_office_frame");
		logger.log(Status.INFO, "notification drop down clicked");
		driver.switchTo().defaultContent();
		System.out.println("notification clicked");
		WebElement search = driver.findElement(By.xpath("//a[@class='search']"));
		clickElement(search, "Search");
		logger.log(Status.INFO, "Search drop down clicked");
		System.out.println("Search clicked");
		WebElement help = driver.findElement(By.xpath("//a[@class='help']"));
		clickElement(help, "Help");
		logger.log(Status.INFO, "help drop down clicked");
		System.out.println("help clicked");
	}
	public static void TestScript_10() throws IOException {
		TestScript_1();
		WebElement userDropdown = driver.findElement(By.xpath("//a[@class='username']"));
		clickElement(userDropdown, "User Drop down");
		logger.log(Status.INFO, "drop down clicked");
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		clickElement(logout, "Logout");
		logger.log(Status.INFO, "Logout clicked");
	}
	
	public static void TestScript_11() throws IOException {
		TestScript_1();
		WebElement userNameDropdown = driver.findElement(By.xpath("//a[@class='username']"));
		clickElement(userNameDropdown, "User Drop down");
		logger.log(Status.INFO, "drop down clicked");
		WebElement profile = driver.findElement(By.xpath("//a[contains(text(),'Profile')]"));
		clickElement(profile, "profile");
		logger.log(Status.INFO, "profile clicked");
		WebElement addphoto = driver.findElement(By.xpath("//span[@id='button-1041-btnInnerEl']"));
		clickElement(addphoto, "Add photo clicked");
		logger.log(Status.INFO, "Upload photo opened");
		
		WebElement browse = driver.findElement(By.xpath("//input[@id='filefield-1216-button-fileInputEl']"));
		browse.sendKeys("/Users/kaushik/Desktop/download.PNG");
		WebElement upload = driver.findElement(By.xpath("//span[@id='button-1220-btnInnerEl']"));
		clickElement(upload, "Upload");
	}
	
	public static void TetScript_12() throws IOException {
		TestScript_1();
		WebElement myXero = driver.findElement(By.xpath("//h2[@class='org-name']"));
		clickElement(myXero, "My Xero");
		logger.log(Status.INFO, "My xero opened");
		WebElement myXerolink = driver.findElement(By.xpath("//a[@class='myxero-link']"));
		clickElement(myXerolink, "My Xero link");
		logger.log(Status.INFO, "My xero link opened");
		WebElement addOrganization = driver.findElement(By.linkText("Add an organization"));
		clickElement(addOrganization, "Add Organization");
		logger.log(Status.INFO, "Add Organization clicked");
		WebElement orgName = driver.findElement(By.xpath("//input[@id='text-1022-inputEl']"));
		enterText(orgName, "Org Name", "self");
		logger.log(Status.INFO, "data entered in text field");
		WebElement payTaxesdropdown = driver.findElement(By.xpath("	//div[@id='ext-gen1096']"));
		clickElement(payTaxesdropdown, "Pay Taxes");
		logger.log(Status.INFO, "clicked paytaxes dropdown");
		WebElement payTaxes = driver.findElement(By.xpath("/html/body/div[8]/div/ul/li[229]"));
		clickElement(payTaxes, "Pay Taxes");
		logger.log(Status.INFO, "paytaxes selected");
		
		WebElement timeZonedropdown = driver.findElement(By.xpath("//div[@id='ext-gen1100']"));
		clickElement(timeZonedropdown, "TimeZone drop down");
		logger.log(Status.INFO, "timezone dropdown opened");
		
		WebElement timeZone = driver.findElement(By.xpath("/html/body/div[8]/div/ul/li[130]"));
		clickElement(timeZone, "TimeZone");
		logger.log(Status.INFO, "timezone selected");
		
		WebElement work = driver.findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"));
		enterText(work, "Work", "Accounting Practice");
		
//		WebElement selectWork = driver.findElement(By.xpath("/html/body/div[10]/div/div/ul/li[1]"));
//		clickElement(selectWork, "selected work");
		logger.log(Status.INFO, "data entered in text field");
//		WebElement previous = driver.findElement(By.xpath("//input[@id='combo-1029-inputEl']"));
//		enterText(previous, "Previous", "Xero");
		WebElement startTrial=driver.findElement(By.xpath("//a[@id='simplebutton-1035']"));
		clickElement(startTrial, "start trial");
		logger.log(Status.INFO, "start trial clicked");
		
		
	}
	
	public static void TestScript_13() throws IOException, Exception {
		TestScript_1();
		
		WebElement myXero = driver.findElement(By.xpath("//h2[@class='org-name']"));
		clickElement(myXero, "My Xero");
		logger.log(Status.INFO, "My xero opened");
		
		WebElement myXerolink = driver.findElement(By.xpath("//a[@class='myxero-link']"));
		clickElement(myXerolink, "My Xero link");
		logger.log(Status.INFO, "My xero link opened");
		
		WebElement addOrganization = driver.findElement(By.linkText("Add an organization"));
		clickElement(addOrganization, "Add Organization");
		logger.log(Status.INFO, "Add Organization clicked");
		
		WebElement orgName = driver.findElement(By.xpath("//input[@id='text-1022-inputEl']"));
		enterText(orgName, "Org Name", "self");
		logger.log(Status.INFO, "data entered in text field");
		
		WebElement payTaxesdropdown = driver.findElement(By.xpath("	//div[@id='ext-gen1096']"));
		clickElement(payTaxesdropdown, "Pay Taxes");
		logger.log(Status.INFO, "clicked paytaxes dropdown");
		
		WebElement payTaxes = driver.findElement(By.xpath("/html/body/div[8]/div/ul/li[229]"));
		clickElement(payTaxes, "Pay Taxes");
		logger.log(Status.INFO, "paytaxes selected");
		
		WebElement timeZonedropdown = driver.findElement(By.xpath("//div[@id='ext-gen1100']"));
		clickElement(timeZonedropdown, "TimeZone drop down");
		logger.log(Status.INFO, "timezone dropdown opened");
		
		WebElement timeZone = driver.findElement(By.xpath("/html/body/div[8]/div/ul/li[130]"));
		clickElement(timeZone, "TimeZone");
		logger.log(Status.INFO, "timezone selected");
		
		WebElement work = driver.findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"));
		enterText(work, "Work", "Accounting");
		logger.log(Status.INFO, "data entered in text field");
		System.out.println("entered accounting");
		Thread.sleep(4000);
		WebElement workselect = driver.findElement(By.xpath("/html/body/div[10]/div/div/ul/li[1]"));
		clickElement(workselect, "Work select");
		
		
		
		Thread.sleep(4000);
		WebElement buyNow=driver.findElement(By.partialLinkText("Buy"));
		clickElement(buyNow, "Buy Now");
		System.out.println("reached");
		logger.log(Status.INFO, "Buy Now clicked");
		System.out.println("In buy now page");
		driver.getCurrentUrl();
		
	}
	
	public static void TestScript_14() throws Exception{
		TestScript_13();
		System.out.println("here");
		Thread.sleep(5000);
		WebElement here = driver.findElement(By.cssSelector(".xui-banner--message > a:nth-child(1)"));
		clickElement(here, "here clicked");
		System.out.println("here1");
//		String oldWindow = driver.getWindowHandle(); 
//		Set<String> getAllWindows = driver.getWindowHandles();
//		WebElement termsCheckBox = driver.findElement(By.xpath("//a[contains(text(),'terms of use')]"));
//		clickElement(termsCheckBox, "terms and conditions link");
			
		
//		//driver.switchTo().window(oldWindow);
//		WebElement subscription = driver.findElement(By.xpath("//span[contains(text(),'Subscriptions')]"));
//		clickElement(subscription, "click");
		
		/*List<WebElement> radio_button = driver.findElements(By.xpath("//div[@class='xui-styledcheckboxradio--radio']"));
		boolean bvalue;
		bvalue=radio_button.get(0).isSelected();
		if(bvalue==false) {
			radio_button.get(0).click();
		}
		else {
			System.out.println("already selected");
		}*/
		WebElement starter = driver.findElement(By.xpath("/section[@id=\"Starter\"]"));
		starter.isSelected();
		clickElement(starter, "Starter");
		logger.log(Status.INFO, "Starter clicked");
//		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
//		driver.switchTo().window(getWindow[0]);
		
		WebElement continuestarter = driver.findElement(By.xpath("//button[@id='continueButton']"));
		clickElement(continuestarter, "Continue");
		logger.log(Status.INFO, "continue clicked");
		
		WebElement address = driver.findElement(By.xpath("//input[@id='contactAddress']"));
		enterText(address, "Address", "3450 granada ave");
		logger.log(Status.INFO, "address entered");
		
		WebElement city = driver.findElement(By.xpath("//input[@id='contactCity']"));
		enterText(city, "City", "Santa clara");
		logger.log(Status.INFO, "city entered");
		
		WebElement region = driver.findElement(By.xpath("//div[@id='postalAddress']//button[@type='button']"));
		clickElement(region, "State");
		logger.log(Status.INFO, "Region clicked");
		WebElement selectregion = driver.findElement(By.xpath("//li[@id='California']//button[@type='button']"));
		clickElement(selectregion, "State");
		logger.log(Status.INFO, "Region clicked");
		
		WebElement zipcode = driver.findElement(By.xpath("//input[@id='contactPostalCode']"));
		enterText(zipcode, "zipcode", "95051");
		logger.log(Status.INFO, "Zipcode entered");
		
		WebElement continuereview = driver.findElement(By.xpath("//button[contains(text(),'Continue to Review & Pay')]"));
		clickElement(continuereview, "ContinueReview");
		logger.log(Status.INFO, "continue clicked");
		
	}
	public static void TestScript_17() throws IOException, Exception {
       
		TestScript_1();
		
		WebElement myXero = driver.findElement(By.xpath("//h2[@class='org-name']"));
		clickElement(myXero, "My Xero");
		logger.log(Status.INFO, "My xero opened");
		
		WebElement myXerolink = driver.findElement(By.xpath("//a[@class='myxero-link']"));
		clickElement(myXerolink, "My Xero link");
		logger.log(Status.INFO, "My xero link opened");
		
		WebElement addOrganization = driver.findElement(By.linkText("Add an organization"));
		clickElement(addOrganization, "Add Organization");
		logger.log(Status.INFO, "Add Organization clicked");
		
		WebElement orgName = driver.findElement(By.xpath("//input[@id='text-1022-inputEl']"));
		enterText(orgName, "Org Name", "self");
		logger.log(Status.INFO, "data entered in text field");
		
		WebElement payTaxesdropdown = driver.findElement(By.xpath("	//div[@id='ext-gen1096']"));
		clickElement(payTaxesdropdown, "Pay Taxes");
		logger.log(Status.INFO, "clicked paytaxes dropdown");
		
		WebElement payTaxes = driver.findElement(By.xpath("/html/body/div[8]/div/ul/li[229]"));
		clickElement(payTaxes, "Pay Taxes");
		logger.log(Status.INFO, "paytaxes selected");
		
		WebElement timeZonedropdown = driver.findElement(By.xpath("//div[@id='ext-gen1100']"));
		clickElement(timeZonedropdown, "TimeZone drop down");
		logger.log(Status.INFO, "timezone dropdown opened");
		
		WebElement timeZone = driver.findElement(By.xpath("/html/body/div[8]/div/ul/li[130]"));
		clickElement(timeZone, "TimeZone");
		logger.log(Status.INFO, "timezone selected");
		
		WebElement work = driver.findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']"));
		enterText(work, "Work", "Accounting");
		logger.log(Status.INFO, "data entered in text field");
		System.out.println("entered accounting");
		Thread.sleep(4000);
		WebElement workselect = driver.findElement(By.xpath("/html/body/div[10]/div/div/ul/li[1]"));
		clickElement(workselect, "Work select");
		
		WebElement convert = driver.findElement(By.xpath("//*[@id=\"conversionLink\"]"));
		clickElement(convert, "Convert clicked");
		
		WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"conversionCheckbox-inputEl\"]"));
		clickElement(checkBox, "Checkbox clicked");
		
		
		
		WebElement continue1=driver.findElement(By.xpath("//*[@id=\"simplebutton-1036\"]"));
		clickElement(continue1, "continue1");
		System.out.println("reached");
		logger.log(Status.INFO, "continue1clicked");
		System.out.println("In buy now page");
	}
	
	public static void TestScript_18() throws Exception {
		
		TestScript_1();
		WebElement accounts = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[1]/ul/li[2]/a"));
		clickElement(accounts, "Accounts");
		logger.log(Status.INFO, "Accounts drop down clicked");
		System.out.println("Accounts clicked");
		WebElement purchases = driver.findElement(By.xpath("//a[contains(text(),'Purchases')]"));
		clickElement(purchases, "Purchases");
	}
	public static void main(String[] args) throws Exception {
		initializeExtentReport("TestScriptExecution");
		//TestScript_1();
		//TestScript_2();
		//TestScript_3();
		//TestScript_4();
		//TestScript_5();
		//TestCase_6();
		//TestCase_7();
		//TestCase_8();
		//TestCase_9();
		//TestScript_10();
		//TestScript_11();
		//TetScript_12();
		//TestScript_13();
		//TestScript_14();
		//TestScript_17();
		TestScript_18();
		System.out.println("completed");
		endExtentReport();
	}

}
