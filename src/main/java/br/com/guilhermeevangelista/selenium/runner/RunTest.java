package br.com.guilhermeevangelista.selenium.runner;

import br.com.guilhermeevangelista.selenium.core.utils.report.Report;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json"},
        features = {"src/main/resources/features"},
        glue = {"br/com/guilhermeevangelista/selenium/steps", "br/com/guilhermeevangelista/selenium/core/hooks"},
        tags = {"@login"})

public class RunTest{

    @AfterClass
    public static void gerarRelatorio(){
        Report.gerarRelarotioClueCumber();
    }

}
