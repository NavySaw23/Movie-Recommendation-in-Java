import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Project\\Chrome driver\\chromedriver-win64\\chromedriver.exe");

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Rotten Tomatoes homepage
        driver.get("https://editorial.rottentomatoes.com/guide/popular-movies/");

        // Locate a list of movie name elements using the given CSS selector
        List<WebElement> movieNameElements = driver.findElements(By.cssSelector("h2 a"));

        // Locate a list of synopsis elements using the given CSS selector
        List<WebElement> synopsisElements = driver.findElements(By.cssSelector(".info.synopsis"));

        // Print the movie names and synopses
        for (int i = 0; i < 10; i++)
        {
            WebElement movieNameElement = movieNameElements.get(i);
            WebElement synopsisElement = synopsisElements.get(i);

            String movieName = movieNameElement.getText();
            String movieSynopsis = synopsisElement.getText();

            System.out.println("Movie Name: " + movieName);
            System.out.println("Synopsis: " + movieSynopsis);
            System.out.println();
        }

        // Close the WebDriver
        driver.quit();
    }
}
/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        //path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Project\\Chrome driver\\chromedriver-win64\\chromedriver.exe");
        // Initializing the ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Navigating to the Rotten Tomatoes
        driver.get("https://editorial.rottentomatoes.com/guide/popular-movies/");
        // Locating a list of movie name elements using the given CSS selector
        List<WebElement> movieNameElements = driver.findElements(By.cssSelector("h2 a"));
        // Locating a list of synopsis elements using the given CSS selector
        List<WebElement> synopsisElements = driver.findElements(By.cssSelector(".info.synopsis"));
        // Locating a list of "[More]" links using the given CSS selector
        List<WebElement> moreLinks = driver.findElements(By.cssSelector("a[href*='/m/']"));
        System.out.println("Our top 10 rated movies are ");
        // Print the movie names, synopses, and "[More]" links
        for (int i = 0; i < 10 && i < synopsisElements.size(); i++)
        {
            WebElement movieNameElement = movieNameElements.get(i);
            WebElement synopsisElement = synopsisElements.get(i);
            WebElement moreLinkElement = moreLinks.get(i);

            String movieName = movieNameElement.getText();
            String movieSynopsis = synopsisElement.getText();
            String moreLink = moreLinkElement.getAttribute("href");

            System.out.println("Movie Name: " + movieName);
            System.out.println( movieSynopsis);
            System.out.println("More Link: " + moreLink);
            System.out.println();
        }

        // Close the WebDriver
        driver.quit();
    }
}*/