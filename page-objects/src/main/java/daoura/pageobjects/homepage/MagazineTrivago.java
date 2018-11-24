package daoura.pageobjects.homepage;

import daoura.framework.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author  Emil Daoura
 */
public class MagazineTrivago extends BasePage
{

    public  MagazineTrivago(WebDriver driver){
        super(driver);
        driver.get("http://magazine.trivago.com");
    }

    public WebElement getSearchText(){
        return driver.findElement(By.className("search-input"));
    }

    public WebElement getSearchButtonElement(){
        return driver.findElement(By.className("search-icon"));
    }
}
