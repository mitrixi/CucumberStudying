package definitions.itvdn;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
import itvdn.steps.ITVDNSiteSteps;
import net.thucydides.core.annotations.Steps;


public class ITVDNSiteStepDefenitions {

    // Для использования шагов их нужно просто объявить без инициализации
    @Steps
    private ITVDNSiteSteps testSteps;

    @Before
    public void doStuff() {

    }

    @After
    public void doAfterScenario() {

    }

    @After
    public void doAfterScenario2() {

    }

    @Given("Customer open site")
    public void openSite() {
        testSteps.openSite();
    }

    // $ определяет что это переменная
    @Given("Customer open '$courseName' video course")
    public void openSiteOnVideoCourse(String name) {
        testSteps.openVideoCourse(name);
    }

    @When("Customer subscribes to mailing with '$mail'")
    public void subscribe(String mail) {
        testSteps.subscribeToEmail(mail);
    }

    @When("Customer perform search with '$key'")
    public void performeSearch(String key) {
        testSteps.search(key);
    }

    @Then("Customer see results")
    public void checkSearchResults() {
        testSteps.checkResults();
    }

    @Then("Customer see success notification")
    public void successNotificaiton() {
        testSteps.verifySubscription();
    }

    @Then("Customer see fail notification")
    public void customerSeeValidation() {
        testSteps.subscriptionFail();
    }
}
