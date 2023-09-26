import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args) throws Exception {
        
        Scanner scn =  new Scanner(System.in);
        System.out.println("-----------Movie Recommendation System-----------");
        System.out.println("Recommendations based on GENRE or RATINGS - ");
        String choice = scn.nextLine();

        if ("GENRE".equalsIgnoreCase(choice)) {
            //Code to get recommendations based on genre

            System.out.print("Enter a Genre - ");
            String genre = scn.nextLine();
        
            System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.rottentomatoes.com/browse/movies_in_theaters/genres:" + genre);

            List<WebElement> list = driver.findElements(By.className("p--small"));
            for (WebElement element : list) {
                String text = element.getText();
                System.out.println(text);
            }

            scn.close();
            Thread.sleep(1000);
            driver.quit();
        
        }
        else if ("RATING".equalsIgnoreCase(choice)) {
            //code to get recommendations based on ratings

            System.out.println("\n");
            System.out.println("Recommendations based on RATINGS -");
            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");

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
        else {
            System.out.println("Invalid choice. Please choose GENRE or RATINGS.");
        }
    }
}
