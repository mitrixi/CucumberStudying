package definitions;

//import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.cucumber.CucumberWithSerenityRuntime;
import org.junit.runner.RunWith;

//  класс SerenityStories запускает все сценарии из src/test/resources/stories
//  классы раннеры должны находиться в одном или родительском пакете к *Definitions.class

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\stories\\orderCoffee")
public class AcceptanceTests {
}
