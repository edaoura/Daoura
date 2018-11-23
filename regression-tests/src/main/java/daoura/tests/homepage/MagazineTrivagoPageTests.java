package daoura.tests.homepage;

import org.testng.annotations.Test;

import daoura.framework.core.BaseTest;
import daoura.pageobjects.homepage.MagazineTrivago;

public class MagazineTrivagoPageTests extends BaseTest {

    @Test
    public void homepageTests() {
        MagazineTrivago magazineTrivago = new MagazineTrivago(getDriver());
    }
}
