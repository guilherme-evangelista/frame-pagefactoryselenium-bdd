package br.com.guilhermeevangelista.selenium.core.hooks;

import br.com.guilhermeevangelista.selenium.core.driver.DriverFactory;
import br.com.guilhermeevangelista.selenium.core.utils.report.screenshot.ScenarioRepository;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;

public class Hooks{

    @Before
    public void inicializarTest(Scenario scenario){
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
