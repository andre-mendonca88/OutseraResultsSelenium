package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {
    public static void takeScreenshot(WebDriver driver, String filePath) {
        try {
            Thread.sleep(2000); // Adiciona uma pausa de 2 segundos
            System.out.println("Taking screenshot...");
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            // Cria os diretórios se não existirem
            Files.createDirectories(Paths.get(filePath).getParent());
            Files.copy(srcFile.toPath(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
