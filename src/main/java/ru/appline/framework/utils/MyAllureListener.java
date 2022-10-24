package ru.appline.framework.utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.framework.managers.DriverManager;

public class MyAllureListener extends AllureJunit5 implements AfterTestExecutionCallback {

    @Attachment(value = "screenshot", type = "image/png", fileExtension = "png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        if (extensionContext.getExecutionException().isPresent()) {
            addScreenshot();
        }
    }

}
