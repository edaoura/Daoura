package daoura.tests.homepage;

import daoura.framework.core.BaseTest;
import daoura.pageobjects.homepage.MagazineTrivago;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Emil Daoura
 */
public class MagazineTrivagoPageTests extends BaseTest {

    /**
     * 1. Search for any location on magazine.trivago.com by using the search bar
     * 5. Search for Canada as a location on magazine.trivago.com by using the search bar
     * and compare the current result to the expected fixed result 6
     */
    @Test
    public void LocationSearchTest() {
        MagazineTrivago magazineTrivago = MagazineTrivago.getDefault(getDriver());

        WebElement searchIButtonElement = magazineTrivago.getSearchButtonElement();
        searchIButtonElement.click();

        WebElement searchInputText = magazineTrivago.getSearchText();
        searchInputText.sendKeys("Canada");
        searchInputText.sendKeys(Keys.ENTER);

        WebElement searchResultCount = magazineTrivago.getSearchResultCountElement();
        String[] result = searchResultCount.getText().split(" ");
        if((result!=null) && result.length>1){
            try {
                int count = Integer.parseInt(result[0]);
                // expected result is 6
                Assert.assertTrue(count==6);
            }catch (NumberFormatException e){
                Assert.assertFalse(true);
            }
        }
    }

    /**
     * 2. Fill in the contact form and send it
     */
    @Test
    public void ContactTest() {
        MagazineTrivago magazineTrivago = MagazineTrivago.getDefault(getDriver());
        //find contact a->href and click. Using JavascriptExecutor
        // allow us to click the element without being visible.
        // For example, the cookies message could make this element invisible
        WebElement contactButtonElement = magazineTrivago.getContactButtonElement();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();" , contactButtonElement);
        // focus new opened tab. if not selected, no element could be found.
        magazineTrivago.focusNewTab();
        //select text message and fill
        WebElement contactAreaElement = magazineTrivago.getContactTextAreaElement();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();" , contactAreaElement);
        contactAreaElement.clear();
        contactAreaElement.sendKeys("Test automation please ignore!!");

        //select and fill Full name
        WebElement contactFullNameElement = magazineTrivago.getContactFullNameElement();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();" , contactFullNameElement);
        contactFullNameElement.clear();
        contactFullNameElement.sendKeys("Emil Daoura");

        //select and fill email inputText
        WebElement contactEmailElement = magazineTrivago.getContactEmailElement();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();" , contactEmailElement);
        contactEmailElement.clear();
        contactEmailElement.sendKeys("e.daoura@gmail.com");

        //find the contact confirm checkbox and select it
        WebElement contactConfirmCheckBoxElement = magazineTrivago.getContactConfirmCheckBoxElement();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();" , contactConfirmCheckBoxElement);

        // find the contact submit button and click
        WebElement contactsubmitButtonElement = magazineTrivago.getContactsubmitButtonElement();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();" , contactsubmitButtonElement);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement contactFeedBackElement = magazineTrivago.getContactFeedBackElement();
        if(contactFeedBackElement==null){
            Assert.assertFalse(true); // test failed
        }else{
            String msg = contactFeedBackElement.getText();
            if((msg!=null) && (msg.contains("Message Sent Successfully"))){
                Assert.assertTrue(true); // test ok
            }else{
                Assert.assertFalse(true); // test failed
            }
        }

        magazineTrivago.closeAllBrowserTabsButNotTheFirst();
    }

    /**
     * 3. Subscribe to the newsletter
     */
    @Test
    public void NewsLetterTest(){
        MagazineTrivago magazineTrivago = MagazineTrivago.getDefault(getDriver());
        //find and select Newsletter checkbox
        WebElement newsLetterConfirmElement = magazineTrivago.getNewsLetterConfirmCheckBoxElement();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", newsLetterConfirmElement);

        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();" , newsLetterConfirmElement);

        //find and fill the newsletter email
        WebElement newsLetterEmailElement = magazineTrivago.getNewsLetterEmailElement();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", newsLetterEmailElement);
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();" , newsLetterEmailElement);
        newsLetterEmailElement.clear();
        newsLetterEmailElement.sendKeys("e.daoura@gmail.com");

        //find and click the submit button of the newsletter
        WebElement newsLetterSubmitButtonElement = magazineTrivago.getNewsLetterSubmitButtonElement();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();" , newsLetterEmailElement);
    }


    /**
     * 4. navigate to a destination through the menu on the top left
     */
    @Test
    public void NavigationMenuTest(){
        MagazineTrivago magazineTrivago = MagazineTrivago.getDefault(getDriver());
        WebElement MainMenuButtonElement = magazineTrivago.getMainMenuButtonElement();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();" , MainMenuButtonElement);

        WebElement menuItemUsaWest = magazineTrivago.getMenuItmeUsaWest();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();" , menuItemUsaWest);

        //go back to the main page. to not disturb other tests
        magazineTrivago.navigateToFirstPage();
    }


}
