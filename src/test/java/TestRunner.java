import cucumber.api.CucumberOptions;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import utilities.CommonEvents;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(

        plugin = {"pretty"},
        glue = {"step_defs"},
        features = {"src/test/resources/features/"},
        tags = {"~@ignore", "@run"}
         )

public class TestRunner {

    @AfterClass()
    public static void tearDown() {
     //  CommonEvents.closeDriver();
    }
}
