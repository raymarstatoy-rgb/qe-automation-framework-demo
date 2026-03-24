package com.demo.seleniumautomation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }

    private static ExtentReports createInstance() {

        //Reports Folder
        String reportsDir = System.getProperty("user.dir") + File.separator + "reports";
        new File(reportsDir).mkdirs();

        //One report file per run
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = reportsDir + File.separator + "AutomationReport_" + timeStamp + ".html";

        //Spark Reporter
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("Automation Execution Report");
        spark.config().setReportName("UI + API Test Results");

        //Extent report and attach reporter
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(spark);

        //System Info
        extentReports.setSystemInfo("Framework", "Selenium + TestNG + RestAssured");
        extentReports.setSystemInfo("Run", timeStamp);

        return extentReports;
    }
}