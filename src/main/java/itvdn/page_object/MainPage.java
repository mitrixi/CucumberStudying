package itvdn.page_object;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

//  открывает страницу c хостом из serenity.properties webdriver.base.url
@DefaultUrl("/ru")
//  проверяет что текущая открытая страница в браузере соотвествует паттерну
@At(".*/ru")
public class MainPage extends PageObject {

    //  этот FindBy из SerenityBDD.Core он возвращает WebElementFacade - обертку над WebElement из Selenium
    @FindBy(css = "#search-on-top")
    private WebElementFacade searchElement;

    @FindBy(css = ".email-success-message")
    private WebElementFacade emailSuccessMessage;

    private By emailInputLocator = By.cssSelector(".email-input");
    private By subscriptionSubmit = By.cssSelector(".subscription-submit");

    @WhenPageOpens
    public void maximiseScreen() {
        getDriver().manage().window().maximize();
    }

    public void search(final String text) {
        searchElement.click();
        searchElement.sendKeys(text);
        searchElement.sendKeys(Keys.ENTER);
    }

    public void subscribeTo(String email) {
        moveTo(emailInputLocator).type(email);
        $(subscriptionSubmit).click();
    }

    public boolean isSuccessMessageVisible() {
        return waitFor(emailSuccessMessage).isVisible();
    }

    public boolean isFailSubscriptionVisible() {
        return $(emailInputLocator).hasClass("invalid");
    }
}
