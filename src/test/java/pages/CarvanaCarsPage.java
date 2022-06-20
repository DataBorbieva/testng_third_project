package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaCarsPage {


        public CarvanaCarsPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        @FindBy(css = "div[data-test='HeaderFacets'] button")
        public List<WebElement> filterOptions;


        @FindBy(css = "input[data-qa='search-bar-input']")
    public WebElement searchInputBoxInCarsPage;

        @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

        @FindBy(id = "results-section")
    public List<WebElement> carsTile; //all tiles

    @FindBy(xpath = "//section//img")
    public List<WebElement> carsTileOnlyImage; //only images of tiles

    @FindBy(xpath = "//div[@class='favorite-vehicle']")
    public List<WebElement> carsTileAddToFavoriteButton; //all add to favorite button
    }
