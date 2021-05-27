package br.com.guilhermeevangelista.selenium.core.hooks;

import br.com.guilhermeevangelista.selenium.core.driver.DriverFactory;
import br.com.guilhermeevangelista.selenium.core.utils.report.screenshot.ScenarioRepository;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.AfterClass;

public class Hooks{

    @Before
    public void inicializarTest(Scenario scenario){
        DriverFactory.getDriver();
        ScenarioRepository.add(scenario);
    }

    @After
    public void apenasFechar(){
        DriverFactory.closeDriver();
        ScenarioRepository.remove();
    }

    @AfterClass
    public static void matarTarefa(){
        DriverFactory.killDriver();
    }

}
