package daoura.tests.homepage;

import daoura.framework.core.BaseTest;
import daoura.pageobjects.homepage.MagazineTrivago;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MagazineTrivagoPageTests extends BaseTest {

    /**
     * 1. Search for any location on magazine.trivago.com by using the search bar
     */
    @Test
    public void LocationSearchTest() {
        MagazineTrivago magazineTrivago = new MagazineTrivago(getDriver());

        WebElement searchIButtonElement = magazineTrivago.getSearchButtonElement();
        searchIButtonElement.click();

        WebElement searchInputText = magazineTrivago.getSearchText();
        searchInputText.sendKeys("Canada");
        searchInputText.sendKeys(Keys.ENTER);
    }



}
