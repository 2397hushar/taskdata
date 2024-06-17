package testcasedata;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
    private static ExtentReports extent;
	ExtentSparkReporter report;
	
	 public static void getInstance() {
	        if (extent == null) {
	            String reportPath = System.getProperty("F:/taskfolder/Reportdata.html");
	            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
	            sparkReporter.config().setTheme(Theme.STANDARD);
	            sparkReporter.config().setDocumentTitle("Automation Test Report");
	            sparkReporter.config().setReportName("Extent Report");

	            extent = new ExtentReports();
	            extent.attachReporter(sparkReporter);
	}
	 }
}