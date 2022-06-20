package scripts;

import org.junit.Assert;
import org.testng.annotations.Test;
import utils.Waiter;

public class CarvanaTest extends Base {

    /*
    Test Case 1: Test name = Validate Carvana home page title and url
Test priority = 1
Given user is on "https://www.carvana.com/"
Then validate title equals to "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
And validate url equals to "https://www.carvana.com/"
     */
    @Test(priority = 1, description = "Test Case 1: Test name = Validate Carvana home page title and url")
    public void validateCarvanaTitleAndUrl() {
        driver.get("https://www.carvana.com/");
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");

    }

/*
Test Case 2: Test name = Validate the Carvana logo
Test priority = 2
Given user is on "https://www.carvana.com/"
Then validate the logo of the “Carvana” is displayed
 */

    @Test(priority = 2, description = "Test Case 2: Test name = Validate the Carvana logo")
    public void validateCarvanaLogo() {
        driver.get("https://www.carvana.com/");
        Assert.assertTrue(carvanaHomePage.carvanaLogo.isDisplayed());
    }

    /*  Test Case 3: Test name = Validate the main navigation section items
      Test priority = 3
      Given user is on "https://www.carvana.com/"
      Then validate the navigation section items below are displayed
              |HOW IT WORKS      |
              |ABOUT CARVANA     |
              |SUPPORT & CONTACT |

     */
    @Test(priority = 3, description = "Test Case 3: Test name = Validate the main navigation section items")
    public void validateNavigationSectionItems() {
        driver.get("https://www.carvana.com/");
        String[] expectedText = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};
        for (int i = 0; i < expectedText.length; i++) {
            //  System.out.println(carvanaHomePage.navigationSectionItems.get(i).getText());
            Waiter.pause(2);
            Assert.assertEquals(carvanaHomePage.navigationSectionItems.get(i).getText(), expectedText[i]);
        }

    }

    /*  Test Case 4: Test name = Validate the sign in error message
      Test priority = 4
      Given user is on "https://www.carvana.com/"
      When user clicks on “SIGN IN” button
      Then user should be navigated to “Sign in” modal
      When user enters email as “johndoe@gmail.com”
      And user enters password as "abcd1234"
      And user clicks on "SIGN IN" button
      Then user should see error message as "Email address and/or password combination is incorrect
      Please try again or reset your password."
  */
    @Test(priority = 4, description = "Test Case 4: Test name = Validate the sign in error message")
    public void validateSignInErrorMessage() {
        driver.get("https://www.carvana.com/");
        carvanaHomePage.signInButton.click();
        Waiter.pause(2);
        carvanaHomePage.emailInputBox.sendKeys("johndoe@gmail.com");
        Waiter.pause(2);
        carvanaHomePage.passwordInputBox.sendKeys("abcd1234");
        carvanaHomePage.signInButtonModal.click();
        Waiter.pause(2);
        System.out.println(carvanaHomePage.errorMessage.getText());
        Assert.assertEquals(carvanaHomePage.errorMessage.getText(), "Email address and/or password combination is incorrect\n" +
                "Please try again or reset your password.");
    }

    /*
    Test Case 5: Test name = Validate the search filter options and search button
Test priority = 5
Given user is on "https://www.carvana.com/"
When user clicks on "SEARCH CARS" link
Then user should be routed to "https://www.carvana.com/cars"
And user should see filter options
|PAYMENT & PRICE      |
|MAKE & MODEL      |
|BODY TYPE |
|YEAR & MILEAGE      |
|FEATURES      |
|MORE FILTERS |
*/
    @Test(priority = 5, description = "Test Case 5: Test name = Validate the search filter options and search button")
    public void validateSearchFilterOptionsAndButton() {
        driver.get("https://www.carvana.com/");
        carvanaHomePage.seachCarsLink.click();
        String[] expectedTexts5 = {"PAYMENT & PRICE",
                "MAKE & MODEL",
                "BODY TYPE",
                "YEAR & MILEAGE",
                "FEATURES",
                "MORE FILTERS"};
        for (int i = 0; i < 6; i++) {
      // System.out.println(carvanaHomePage.filterOptions.get(i).getText());
        Assert.assertEquals(carvanaCarsPage.filterOptions.get(i).getText(),expectedTexts5[i]);

        }



    /*

Test Case 6: Test name = Validate the search result tiles
Test priority = 6
Given user is on "https://www.carvana.com/"
When user clicks on "SEARCH CARS" link
Then user should be routed to "https://www.carvana.com/cars"
When user enters "mercedes-benz" to the search input box
And user clicks on "GO" button in the search input box
Then user should see "mercedes-benz" in the url
And validate each result tile
VALIDATION OF EACH TILE INCLUDES BELOW
Make sure each result tile is displayed with below information
1. an image
2. add to favorite button
3. tile body
ALSO VALIDATE EACH TILE BODY:
Make sure each tile body has below information
1. Inventory type - text should be displayed and should not be null
2. Year-Make-Model information - text should be displayed and should not be null
3. Trim-Mileage information - text should be displayed and should not be null
4. Price - Make sure that each price is more than zero
5. Monthly Payment information - text should be displayed and should not be null
6. Down Payment information - text should be displayed and should not be null
7. Delivery chip must be displayed as “Free Shipping”
NOTE: After completing all scripts, create an xml file called “test.xml” and make sure that you can run all
scripts using “mvn test -PRegression”
     */
    }
@Test(priority = 6, description = "Test Case 6: Test name = Validate the search result tiles")
    public void validateSearchResultTiles(){
    driver.get("https://www.carvana.com/");
    carvanaHomePage.seachCarsLink.click();
    carvanaCarsPage.searchInputBoxInCarsPage.sendKeys("mercedes-benz");
    Waiter.pause(2);
    carvanaCarsPage.goButton.click();
    Waiter.pause(1);
    System.out.println(driver.getCurrentUrl().contains("mercedes-benz"));


    //validate results on tile based on requirements
    //  1. an image
    for (int i = 0; i < carvanaCarsPage.carsTileOnlyImage.size(); i++) {
        Assert.assertTrue(carvanaCarsPage.carsTileOnlyImage.get(i).isDisplayed());

    }


    //2. add to favorite button
    for (int i = 0; i < carvanaCarsPage.carsTileAddToFavoriteButton.size(); i++) {
        Assert.assertTrue(carvanaCarsPage.carsTileAddToFavoriteButton.get(i).isDisplayed());

    }

    //3. tile body
    for (int i = 0; i < carvanaCarsPage.carsTile.size(); i++) {
        Assert.assertTrue(carvanaCarsPage.carsTile.get(i).isDisplayed());

    }







    }

}

