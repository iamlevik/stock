package serenityswag.ConsoleTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.apache.commons.mail.EmailException;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class Test {


    @Managed
    WebDriver driver;

    SendEmailJava email;

    @org.junit.Test
    public void consoleAutomation() throws EmailException {
        boolean stock = true;
        driver.get("https://www.flanco.ro/consola-ps5-sony-b-chassis-825gb-gran-turismo-horizon-forbidden-sackboy-a-big-adventure-membership-90-zile-card-playstation-store-250-ron.html");

        do {

            try {
                driver.findElement(By.xpath("//span[contains(text(),'In stoc')]"));


                stock = false;

            } catch (Exception e) {
                driver.navigate().refresh();

                System.out.println("Product not stock");

            }

        } while (stock);

        email.sendEmail();


    }
}
