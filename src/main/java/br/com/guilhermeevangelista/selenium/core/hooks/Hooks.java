package br.com.guilhermeevangelista.selenium.core.hooks;

import br.com.guilhermeevangelista.selenium.core.driver.DriverFactory;
import br.com.guilhermeevangelista.selenium.core.utils.report.screenshot.ScenarioRepository;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;

public class Hooks{

    @Before
    public void initializeTest(Scenario scenario){
        ScenarioRepository.add(scenario);
    }

    @After
    public void onlyClose(){
        DriverFactory.closeDriver();
        ScenarioRepository.remove();
    }

    @AfterClass
    public static void driverQuit(){
        DriverFactory.killDriver();
    }

}