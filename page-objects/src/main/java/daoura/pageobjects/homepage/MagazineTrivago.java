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
    private static final String webPageUrl = "http://magazine.trivago.com";

    private static MagazineTrivago magazineTrivago = null;

    public  MagazineTrivago(WebDriver driver){
        super(driver);
        driver.get(webPageUrl);
    }

    public static MagazineTrivago getDefault(WebDriver driver){
        if(magazineTrivago==null){
            magazineTrivago = new MagazineTrivago(driver);
        }
        return magazineTrivago;
    }

    public void navigateToFirstPage(){
        driver.navigate().to(webPageUrl);
    }

    public void closeAllBrowserTabsButNotTheFirst(){
        super.closeAllBrowserTabsButNotTheFirst();
    }

    public void focusNewTab(){
        super.focusNewTab();
    }
    public WebElement getSearchText(){
        By searchTextLocator = By.className("search-input");
        waitForElementToAppear(searchTextLocator);
        return driver.findElement(searchTextLocator);
    }

    public WebElement getSearchButtonElement(){
        By searchButtonLocator = By.className("search-icon");
        waitForElementToAppear(searchButtonLocator);
        return driver.findElement(searchButtonLocator);
    }

    public WebElement getSearchResultCountElement() {
        By searchResultLocator = By.xpath("//div[contains(@class,'search-results')]//h3[contains(@class,'section-title')]");
        waitForElementToAppear(searchResultLocator);
        return driver.findElement(searchResultLocator);
    }

    public WebElement getContactButtonElement(){
        By contactButtonLocation = By.xpath("//a[contains(@href,'contact')]");
        waitForElementToAppear(contactButtonLocation);
        return driver.findElement(contactButtonLocation);
    }

    public  WebElement getContactTextAreaElement(){
        By contactTextAreaLocation = By.xpath("//textarea[contains(@class,'contact-msg')]");
        waitForElementToAppear(contactTextAreaLocation);
        return driver.findElement(contactTextAreaLocation);
    }

    public  WebElement getContactFullNameElement(){
        By contactFullNameLocation = By.xpath("//input[not(@id) and contains(@class,'contact-input')]");
        waitForElementToAppear(contactFullNameLocation);
        return driver.findElement(contactFullNameLocation);
    }

    public  WebElement getContactEmailElement(){
        By contactEmailLocation = By.xpath("//input[@id='contact-email']");
        waitForElementToAppear(contactEmailLocation);
        return driver.findElement(contactEmailLocation);
    }

    public WebElement getContactConfirmCheckBoxElement(){
        By contactConfirmCheckBoxLocation = By.xpath("//input[@id='confirm']");
        waitForElementToAppear(contactConfirmCheckBoxLocation);
        return driver.findElement(contactConfirmCheckBoxLocation);
    }

    public WebElement getContactsubmitButtonElement(){
        By contactSubmitButtonLocation = By.xpath("//button[contains(@class,'contact-submit')]");
        waitForElementToAppear(contactSubmitButtonLocation);
        return driver.findElement(contactSubmitButtonLocation);
    }

    public WebElement getContactFeedBackElement(){
        By contactFeedBackLocation = By.xpath("//p[contains(@class,'feedback')]");
        if(contactFeedBackLocation==null){
            return null;
        }
        return driver.findElement(contactFeedBackLocation);
    }

    public WebElement getNewsLetterConfirmCheckBoxElement(){
        By contactNewsLetterConfirmCheckBoxLocation = By.xpath("//input[contains(@class,'et-confirm')]");
        return driver.findElement(contactNewsLetterConfirmCheckBoxLocation);
    }

    public WebElement getNewsLetterEmailElement(){
        By contactNewsLetterEmailLocation = By.xpath("//input[contains(@class,'et-email')]");
        return driver.findElement(contactNewsLetterEmailLocation);
    }

    public WebElement getNewsLetterSubmitButtonElement(){
        By contactNewsLetterSubmitButtonLocation = By.xpath("//div[contains(@class,'newsletter-submit')]/button[contains(@class,'submit')]");
        return driver.findElement(contactNewsLetterSubmitButtonLocation);
    }

    public WebElement getMainMenuButtonElement(){
        By mainMenuButtonLocation = By.className("nav-icon");
        return driver.findElement(mainMenuButtonLocation);
    }

    public WebElement getMenuItmeUsaWest(){
        By menuItemUsaWest = By.xpath("//a[contains(@href,'destination/usa/west')]");
        return driver.findElement(menuItemUsaWest);
    }
}
