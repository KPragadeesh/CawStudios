import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseComponent {
    public WebDriver driver;

    public BaseComponent(String browserName) {
        this.driver = initializeDriver(browserName);
    }

    public WebDriver initializeDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void goTo() {
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
    }

    public static String readJsonFileToString(String fileName) {
        Path filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", fileName);
        String jsonData = null;
        try {
            jsonData = new String(Files.readAllBytes(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonData;
    }

}
