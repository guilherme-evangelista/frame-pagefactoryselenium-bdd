package com.herokuapp.srbarriga.runner;

import com.herokuapp.srbarriga.utils.Report;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions( strict = true,
        monochrome = true,
        plugin = {"html:target/cucumber-report", "json:target/cucumber.json"},
        features = {"src/test/features/SrBarriga"},
        glue = {"com/herokuapp/srbarriga/steps", "com/herokuapp/srbarriga/hooks"},
        tags = {"@loginsucesso"})

public class RunTest{

    @AfterClass
    public static void gerarRelatorio(){
        Report.gerarRelatio();
    }

}
