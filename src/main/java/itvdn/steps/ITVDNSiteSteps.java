package itvdn.steps;

import itvdn.page_object.CoursePage;
import itvdn.page_object.MainPage;
import itvdn.page_object.SearchPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import java.util.List;

import static net.serenitybdd.core.pages.PageObject.withParameters;

//  Для создания класса Steps необходимо наследовать класс ScenarioSteps
public class ITVDNSiteSteps extends ScenarioSteps {

    //  страницы не надо инициализировать самому. ScenarioSteps делает это за нас
    private MainPage mainPage;
    private SearchPage searchPage;
    private CoursePage coursePage;

    //  @Step специальная аннотация для обозначения методов которые можно будет вызвать
    @Step
    public void openSite() {
        mainPage.open();
    }

    @Step
    public void openVideoCourse(String name) {
        coursePage.open("open.course", withParameters(name));
    }

    @Step
    public void subscribeToEmail(String email) {
        mainPage.subscribeTo(email);
    }

    @Step
    public void search(String key) {
        mainPage.search(key);
    }

    @Step
    public void verifySubscription() {
        Assert.assertTrue(mainPage.isSuccessMessageVisible());
    }

    @Step
    public void subscriptionFail() {
        Assert.assertTrue(mainPage.isFailSubscriptionVisible());
    }

    @Step
    public void checkResults() {
        List<WebElementFacade> results = searchPage.getResults();
        Assert.assertEquals("", 10, results.size());
    }
}
