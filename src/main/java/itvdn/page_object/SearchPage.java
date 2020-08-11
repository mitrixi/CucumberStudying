package itvdn.page_object;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class SearchPage extends PageObject {

    @FindBy(css = ".search-result")
    List<WebElementFacade> searchResultElements;

    public List<WebElementFacade> getResults() {
        return searchResultElements;
    }
}
