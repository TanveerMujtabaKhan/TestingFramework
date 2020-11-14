package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager{
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		String str = sdf.format(new Date());
		System.out.println(System.getProperty("user.dir")+"Midtrans_"+str+".html");
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"Midtrans_"+str+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("ProjectName", "Dkatalis-Midtrans");
		extent.setSystemInfo("Tester", "Tanveer Mujtaba Khan");
	}
	public static void endReport() {

		extent.flush();
	}
}
