package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /*create method with name "selectMenu" it has one parameter name "menu" of type string.
    This method should click on the menu whatever name is passed as parameter
     */
    public void selectMenu(String menu, By by) {
        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names) {
            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        selectMenu("Show All Desktops", By.xpath("//a[contains(text(),'Show All Desktops')]"));
        verifyExpectedAndActual(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"),"Desktops");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        selectMenu("Show All Laptops & Notebooks", By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        verifyExpectedAndActual(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"),"Laptops & Notebooks");
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
        selectMenu("Show All Components", By.xpath("//a[contains(text(),'Show All Components')]"));
        verifyExpectedAndActual(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"),"Components");
    }
    @After
    public void tearDown() {
        closeBrowser();

    }

}
