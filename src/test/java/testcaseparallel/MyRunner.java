package testcaseparallel;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;




    @CucumberOptions(
            features = "src/test/resources/testcaseparallel",
            glue = {"testcaseparallel"},
            plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/"},
            monochrome = true,
            publish = true


    )
    public class MyRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
            return super.scenarios();
        }

    }



