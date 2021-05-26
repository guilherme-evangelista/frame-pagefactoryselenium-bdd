package br.com.guilhermeevangelista.selenium.core.driver;

import br.com.guilhermeevangelista.selenium.core.driver.enums.Web;
import br.com.guilhermeevangelista.selenium.core.utils.PropertiesManager;
import br.com.guilhermeevangelista.selenium.core.utils.variaveis.VariaveisEstaticasSalesForce;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Classe com design pattern singleton para trabalhar com instancias do Driver
 *
 * @author Guilherme-Evangelista
 */
public class DriverFactory {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    /**
     * Recuperar instancia unica do Web Driver
     *
     * @return retorna o WebDriver
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    /**
     * Recuperar instancia unica do Web Driver Wait
     *
     * @return retorna o WebDriverWait
     */
    public static WebDriverWait getDriverWait() {
        if (driver == null) {
            createDriver();
        }
        return wait;
    }

    /**
     * Criar driver com o design pattern singleton
     */
    private static void createDriver() {
        if (driver != null) driver.quit();
        driver = Web.CHROME.getDriver();

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            driver.manage().window().maximize();
        }else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            driver.manage().window().fullscreen();
        }
        wait = new WebDriverWait(driver, 10);
        PropertiesManager propertiesManager = new PropertiesManager("config");
        driver.get(propertiesManager.getProp("url"+ VariaveisEstaticasSalesForce.ambiente));
    }

    /**
     * Fecha e navegador
     */
    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

    /**
     * Mata tarefa do Driver
     */
    public static void killDriver() {
        driver.quit();
        driver = null;
    }

}
