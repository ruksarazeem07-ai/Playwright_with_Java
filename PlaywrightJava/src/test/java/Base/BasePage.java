package Base;

//import com.microsoft.playwright.Page;
import utils.PlaywrightDriver;

public class BasePage extends CommonMethods {

    public BasePage() {
        super(PlaywrightDriver.getPage());
    }
}