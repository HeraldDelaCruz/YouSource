package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
					glue = {"steps","hooks"},
					//tags = "@test",
					publish=true,
					plugin = {"pretty","html:target/CucumberReports/Report.html"}
					
				)
public class TestRunner {

}
