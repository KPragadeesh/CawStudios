import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

/*
@author Pragadeesh
*/
public class HeroKuAppPageObj {
    private WebDriver driver;
    public HeroKuAppPageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//summary[normalize-space()='Table Data']")
    public WebElement tableDataButton;

    @FindBy(xpath = "//textarea[@id='jsondata']")
    public WebElement textArea;

    @FindBy(xpath = "//button[@id='refreshtable']")
    public WebElement refreshTable;

    public void addJsonDataInTableDataInput(String testData) throws IOException {
        tableDataButton.click();
        textArea.clear();
        textArea.sendKeys(BaseComponent.readJsonFileToString(testData));
        refreshTable.click();
    }

}
