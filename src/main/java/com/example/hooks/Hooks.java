package com.example.hooks;

import com.example.utils.DriverManager;
import com.example.utils.ScenarioRepository;
import com.example.utils.Web;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends DriverManager{

    @Before
    public void initializeTest(Scenario scenario){
        ScenarioRepository.add(scenario);
        if ("FIREFOX".equals((System.getProperty("properties") == null ? "" : System.getProperty("properties").toUpperCase()))) {
            initDriver(Web.FIREFOX);
        } else {
            initDriver(Web.CHROME);
        }
    }

    @After
    public static void driverClose(){
        closeDriver();
        ScenarioRepository.remove();
    }
}
