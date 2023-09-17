import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.Keys;
// import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.By;
import java.util.Scanner;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        // scans genre
        Scanner txt= new Scanner(System.in);
        System.out.println("enter a genre");
        String gen=txt.nextLine();
        // driver.navigate().to("http://www.google.com/");

        // opens webdriver
        System.setProperty("webriver.chrome.driver", "C:\\programs\\oops project\\movie recommendations\\src\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver (options);
        
        // opens rottentomatoes and finds genre
        driver.get("https://www.rottentomatoes.com/browse/movies_at_home/genres:" +gen);
        Thread.sleep(100);

        // printing the movies
        List <WebElement> names= driver.findElements(By.className("p--small"));
        for(WebElement movie: names){
            String name=movie.getText();
            System.out.println(name);
        }
        driver.quit();   
    }
}