package br.com.guilhermeevangelista.selenium.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Gerar report com o plugin ClueCumber baseado no custom.css acima
 * @author Guilherme-Evangelista
 */
@CucumberOptions(
        plugin = {"json:target/cucumber-report/cucumber.json"},
        features = {"src/main/resources/features"},
        glue = {"br/com/guilhermeevangelista/selenium/test/steps", "br/com/guilhermeevangelista/selenium/core/hooks"},

        tags = "@loginsucesso"

)
public class RunParallelTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
