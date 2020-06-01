package com.example.runner;

import com.example.core.utils.Report;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions( strict = true,
        monochrome = true,
        plugin = {"html:target/cucumber-report", "json:target/cucumber.json"},
        features = {"src/main/resources/features"},
        glue = {"com/example/steps", "com/example/hooks"},
        tags = {"@busca"})

public class RunTest{

    @AfterClass
    public static void gerarRelatorio(){
        Report.gerarRelatio();
    }

}
