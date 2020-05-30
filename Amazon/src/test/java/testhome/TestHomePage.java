package testhome;

import common.WebAPI;
import home.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestHomePage extends WebAPI {
//    static HomePage homepage;
//    static AboutPage aboutpage;


    //PageFactory Get Init Elements method help us to get Driver
//    public static void getInItElements() {
//        HomePage  homepage = PageFactory.initElements(driver, HomePage.class);
//        AboutPage aboutpage = PageFactory.initElements(driver, AboutPage.class);
//


    @Test
    public static void testSearchBox() {

        // Create Page Object using pagefacory so that we can use the variables from these pages using @FindBy
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        AboutPage aboutpage = PageFactory.initElements(driver, AboutPage.class);

// Call the method using the page factory page object
        homepage.doSearch("Hand Sanitizer");
        homepage.validateSearch();
    }

}



