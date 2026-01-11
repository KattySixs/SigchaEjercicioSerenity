package automationtest.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "automationtest.glue",
        plugin = {"json:build/cucumber-reports/json/cucumber.json", "summary"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@SauceDemo"
)
public class WebRunnerTest {
}
