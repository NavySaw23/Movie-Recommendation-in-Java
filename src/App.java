import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scn =  new Scanner(System.in);
        System.out.println("Enter a Genre - ");
        String genre = scn.nextLine();
        
        System.setProperty("webriver.chrome.driver", "./src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rottentomatoes.com/browse/movies_in_theaters/genres:" + genre);

        List<WebElement> list = driver.findElements(By.className("p--small"));
        for (WebElement element : list) {
            String text = element.getText();
            System.out.println(text);
        }

        Thread.sleep(1000);
        driver.quit();
        
    }
}
