package com.herokuapp.srbarriga.pages;

import com.herokuapp.srbarriga.utils.DriverManager;
import com.herokuapp.srbarriga.utils.PropertiesManager;
import com.herokuapp.srbarriga.utils.ScenarioRepository;
import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage extends DriverManager {

    PropertiesManager propertiesManager = new PropertiesManager();

    private int timeout = Integer.parseInt(propertiesManager.getProp("timeout"));
    private static Logger log = Logger.getLogger(BasePage.class.getName());

    protected BasePage(){
        PageFactory.initElements(webDriver, this);
    }

    protected void esperarElementoFicarClicavel(WebElement element) {
        new WebDriverWait(webDriver, timeout)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void esperarElementoFicarVisivel(WebElement element) {
        new WebDriverWait(webDriver, timeout)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void esperarElementoSairDaTela(WebElement element) {
        new WebDriverWait(webDriver, timeout)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    protected void tentarClicarBotaoLoop(WebElement element) throws InterruptedException {
        int tentativas = 0;
        do {
            try {
                waitProcessPage();
                esperarElementoFicarClicavel(element);
                element.click();
            } catch (Exception ignored) {
            }
            tentativas++;
        } while (tentativas < 10);
    }

    protected void clicarElemento(WebElement element) {
        try {
            waitProcessPage();
            esperarElementoFicarClicavel(element);
            element.click();
        } catch (ElementNotInteractableException e) {
            Actions actions = new Actions(webDriver);
            actions.moveToElement(element).click().build().perform();
        } catch (WebDriverException e) {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            ScenarioRepository.screenShot(webDriver);
            log.error("Falha ao clicar no elemento :" + element);
        }
    }

    protected void tirarPrint(){
        ScenarioRepository.screenShot(webDriver);
    }

    protected void tirarPrint(WebElement...elements){
        waitProcess();
        ScenarioRepository.screenShot(webDriver, elements);
    }

    protected String recuperarTexto(WebElement element) {
        String valor = null;
        try {
            waitProcessPage();
            esperarElementoFicarVisivel(element);
            valor = element.getText();
        } catch (Exception e) {
            ScenarioRepository.screenShot(webDriver);
            log.error("Falha ao clicar no elemento :" + element);
        }
        return valor;
    }

    protected void correrListaEClicarElemento(List<WebElement> listaDeElementos, String campo) {
        for (WebElement element : listaDeElementos) {
            if (recuperarTexto(element).equalsIgnoreCase(campo)) {
                clicarElemento(element);
                break;
            }
        }
    }

    protected void digitarTexto(WebElement element, String texto) {
        try {
            waitProcessPage();
            esperarElementoFicarVisivel(element);
            element.sendKeys(texto);
        } catch (Exception e) {
            ScenarioRepository.screenShot(webDriver);
            log.error("Falha ao clicar no elemento :" + element);
        }
    }

    protected boolean verificaElementoPresenteTela(WebElement element) {
        boolean valor = false;
        try {
            waitProcessPage();
            esperarElementoFicarClicavel(element);
            valor = element.isDisplayed();
        } catch (Exception e) {
            ScenarioRepository.screenShot(webDriver);
            log.error("Falha ao clicar no elemento :" + element);
        }
        return valor;
    }

    private void waitProcessPage(){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeout);
        webDriverWait.until(waitProcess());
    }

    private ExpectedCondition<Boolean> waitProcess() {
        return driver -> {
            try {
                String js = "var reqAjax = typeof window.Ajax !== 'undefined' ?window.Ajax.activeRequestCount : 0;\n" +
                        "var reqAngular = typeof angular !== 'undefined' ? angular.element(document.body).injector().get('$http').pendingRequests.length : 0;\n" +
                        "var reqJquery = typeof jQuery !== 'undefined' ? jQuery.active : 0;\n" +
                        "var reqDom = document.readyState;\n" +
                        "\n" +
                        "if (reqAjax === 0 && reqAngular === 0 & reqJquery === 0 && reqDom === 'complete') {\n" +
                        " return 'complete';\n" +
                        "}\n" +
                        "else {\n" +
                        " return 'process';\n" +
                        "}";

                assert driver != null;
                return ((JavascriptExecutor) driver).executeScript(js).toString().equals("complete");
            } catch (Exception e) {
                return true;
            }
        };
    }
}
