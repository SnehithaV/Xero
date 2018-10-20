package TestScripts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFShapeFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ReusableMethods extends XeroBaseClass{

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public static void initializeExtentReport(String reportName) {
		String reportPath = new SimpleDateFormat("YYYYMMDDHHmmss").format(new Date());
		htmlReporter = new ExtentHtmlReporter("./TestReports/" +reportPath+reportName + ".html");
		
		 extent = new ExtentReports();
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Host Name", "TekArch");
		 extent.setSystemInfo("Environment", "QA-Xero Automation");
		 extent.setSystemInfo("User Name", "Snehitha");
		 
		 htmlReporter.config().setDocumentTitle("Xero Execution Report");
		 htmlReporter.config().setReportName("Execution Report");
		 htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		 htmlReporter.config().setTheme(Theme.STANDARD);
		
	}
	
	public static String takeScreenShot() throws IOException {
		String reportPath= new SimpleDateFormat("YYYYMMDDHHmmss").format(new Date());
		String destination = "./TestReports/Screenshots/"+reportPath +"image.PNG";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(destination), true);
		return destination;
		
	}
	public static ExtentTest createTestScriptReport(String testScriptName) {
		logger=extent.createTest(testScriptName);
		return logger;
	}
	public static void endExtentReport() {
		extent.flush();
	}
		
	public static void enterText(WebElement webelement, String webelementName, String text) throws IOException {
		if(webelement.isDisplayed()) {
			webelement.sendKeys(text);
			logger.log(Status.PASS,MarkupHelper.createLabel(text+" entered in " +webelementName, ExtentColor.GREEN));
					
		}
		else {
			logger.log(Status.FAIL,MarkupHelper.createLabel(webelementName +" not found", ExtentColor.RED));
			String imagePath=takeScreenShot();
			logger.addScreenCaptureFromPath(imagePath);
		}
	}
	
	public static void clickElement(WebElement webelement,String webelementName) throws IOException {
		if(webelement.isDisplayed()) {
			webelement.click();
			logger.log(Status.PASS, MarkupHelper.createLabel(webelementName +" is clicked", ExtentColor.GREEN));
		}
		else {
			logger.log(Status.FAIL, MarkupHelper.createLabel(webelementName +" not found", ExtentColor.RED));
			String imagePath=takeScreenShot();
			logger.addScreenCaptureFromPath(imagePath);
		}
	}
	
	public static void verifyText(WebElement webelement,String webelementName, String expectedText) throws IOException {
		if(webelement.isDisplayed()) {
			//System.out.println(webelement.getText());
			//System.out.println(expectedText);
			if(webelement.getText().equalsIgnoreCase(expectedText)) {
				logger.log(Status.PASS, MarkupHelper.createLabel(webelementName +" is displayed as expected", ExtentColor.GREEN));
			}
			else {
				logger.log(Status.FAIL, MarkupHelper.createLabel(webelementName +"is not same as expectedText", ExtentColor.RED));
				String imagePath=takeScreenShot();
				logger.addScreenCaptureFromPath(imagePath);
			}
		}
		else {
			logger.log(Status.FAIL, MarkupHelper.createLabel(webelement +" is not displayed", ExtentColor.RED));
		}
		
	}
	
	public static String[][] readXLData(String path, String sheetName) throws IOException{
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();
		
		String data[][] = new String[rows][columns];
			for(int i=0;i<rows;i++) {
				for(int j=0;j<columns;j++) {
					HSSFCell cell = sheet.getRow(i).getCell(j);
					if(cell.getCellType()==CellType.STRING) {
						data[i][j]=cell.getStringCellValue();
					}
					else if(cell.getCellType()==CellType.NUMERIC) {
						data[i][j]=String.valueOf(cell.getNumericCellValue());
					}
				}
			}
		
		return data;
		
		
	}
	public static Properties loadPropertyFile(String path) throws IOException {
		Properties pro = new Properties();
		FileReader reader = new FileReader(path);
		BufferedReader br = new BufferedReader(reader);
		pro.load(reader);
		return pro;
		
	}
	
	public static By getLocator(String strElement, Properties propertyFile) throws Exception {
		String locator = propertyFile.getProperty(strElement);
		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
		System.out.println("Retrieving object of type"+ locatorType + "' and value '" + locatorValue + "from the object map");
		if(locatorType.toLowerCase().equals("id"))
            return By.id(locatorValue);
        else if(locatorType.toLowerCase().equals("name"))
            return By.name(locatorValue);
        else if((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
            return By.className(locatorValue);
        else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
            return By.className(locatorValue);
        else if((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
            return By.linkText(locatorValue);
        else if(locatorType.toLowerCase().equals("partiallinktext"))
            return By.partialLinkText(locatorValue);
        else if((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
            return By.cssSelector(locatorValue);
        else if(locatorType.toLowerCase().equals("xpath"))
            return By.xpath(locatorValue);
        else
            throw new Exception("Unknown locator type '" + locatorType + "'");
		
	}
}



















