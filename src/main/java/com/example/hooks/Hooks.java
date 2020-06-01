package com.example.hooks;

import com.example.core.DriverFactory;
import com.example.core.utils.ScenarioRepository;
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
