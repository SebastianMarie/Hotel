package newproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Main {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src\\newproject\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //base urls and page data
        String baseUrl = "https://www.bayut.com/for-sale/property/dubai/dubai-marina/";
        String expectedTitle = "Properties for Sale in Dubai Marina | Bayut.com";
        String actualTitle = "";
        String actualPopularSearches = "";
        String expectedPopularSearches = """
                Properties for sale in Dubai Marina on cash
                Ready To Move properties for sale in Dubai Marina
                Private properties for sale in Dubai Marina
                Off Plan properties for sale in Dubai Marina
                Rent To Own properties for sale in Dubai Marina
                Brand New properties for sale in Dubai Marina
                Distressed properties for sale in Dubai Marina
                Luxury properties for sale in Dubai Marina""";

        driver.get(baseUrl);
        System.out.println("Testing at " + baseUrl);

        // Test correct page by title
        actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Title Test Passed!");
        } else {
            System.out.println("Title Test Failed!");
        }

        // Popular searches div
        actualPopularSearches = driver.findElement(By.className("be1e8f7c")).getText();
        if (actualPopularSearches.contentEquals(expectedPopularSearches)){
            System.out.println("Popular Searches Test Passed!");
        } else {
            System.out.println("Popular Searches Test Failed!");
        }

        // iterative search on property listings is not possible due to page modifications

        System.out.println("Tests Finished!");
        driver.close();

    }

}