package itvdn.page_object;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;

//      Содержит набор разных вариантов url c параметрами
@NamedUrls(
        {
                @NamedUrl(name = "open.course", url = "/ru/video/{1}")
        }
)
public class CoursePage extends PageObject {
}
