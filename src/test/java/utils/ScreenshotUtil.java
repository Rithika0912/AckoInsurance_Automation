package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver,
                                           String fileName)
            throws IOException {

        File source =
                ((TakesScreenshot)driver)
                        .getScreenshotAs(OutputType.FILE);

        String destination =
                System.getProperty("user.dir")
                        + "/Screenshots/"
                        + fileName
                        + ".png";

        FileUtils.copyFile(source, new File(destination));

        return destination;
    }
}
