package br.com.guilhermeevangelista.selenium.runner;

import br.com.guilhermeevangelista.selenium.core.utils.report.Report;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

/**
 * Gerar report com o plugin ClueCumber baseado no custom.css acima
 * @author Guilherme-Evangelista
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json"},
        features = {"src/main/resources/features"},
        glue = {"br/com/guilhermeevangelista/selenium/test/steps", "br/com/guilhermeevangelista/selenium/core/hooks"},
        tags = {"@loginsucesso"}
)
public class RunTest {
    @AfterClass
    public static void gerarRelatorio() {
        Report.gerarRelarotioClueCumber();
    }
}
