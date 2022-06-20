package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaHomePage {

    public CarvanaHomePage(WebDriver driver){
        PageFactory.initElements(driver,this );
    }

    @FindBy(xpath = "//div[@data-qa='logo-wrapper']")
    public WebElement carvanaLogo;

    @FindBy(css = "div[data-qa='navigation-wrapper'] div[data-qa='menu-wrapper']")
    public List<WebElement> navigationSectionItems;

    @FindBy(css = "a[data-cv-test='headerSignInLink']")
    public WebElement signInButton;

    @FindBy(css = "#usernameField")
    public WebElement emailInputBox;

    @FindBy(css = "#passwordField")
    public WebElement passwordInputBox;

    @FindBy(xpath = "(//button[@data-qa='button-base'])[1]")
    public WebElement signInButtonModal;

    @FindBy(xpath = "//div[@data-qa='error-message-container']")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@data-cv-test='headerSearchLink']")
    public WebElement seachCarsLink;







}
