package definitions;

//import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

//  класс SerenityStory запускает конкретный сценарий с абсолютно идентичным именем из resources/stories

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\stories\\itvdn")
public class ITVDNSiteTests {
}

