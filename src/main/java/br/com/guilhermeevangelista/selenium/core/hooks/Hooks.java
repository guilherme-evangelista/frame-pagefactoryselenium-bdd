package br.com.guilhermeevangelista.selenium.core.hooks;

import br.com.guilhermeevangelista.selenium.core.DriverFactory;
import br.com.guilhermeevangelista.selenium.core.screenshot.ScenarioRepository;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks{

    @Before
    public void initializeTest(Scenario scenario){
        ScenarioRepository.add(scenario);
    }

    @After
    public static void driverClose(){
        DriverFactory.killDriver();
        ScenarioRepository.remove();
    }

}
