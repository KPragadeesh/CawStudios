import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.Test;
import java.io.IOException;

/*
@author Pragadeesh
*/

public class HeroKuAPPTest {

    BaseComponent baseComponent = new BaseComponent("chrome");
    HeroKuAppPageObj pageObjects = new HeroKuAppPageObj(baseComponent.driver);

    @Test
    public void testCase1() throws JSONException {
        try {
            baseComponent.goTo();
            pageObjects.addJsonDataInTableDataInput("testData.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //TestScenario1
        JSONAssert.assertEquals(baseComponent.readJsonFileToString("testData.json"),
                pageObjects.textArea.getAttribute("value"), false);
    }
}
