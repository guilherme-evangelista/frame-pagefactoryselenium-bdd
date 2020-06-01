package com.example.core;

import com.example.core.utils.PropertiesManager;
import com.example.core.screenshot.ScenarioRepository;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.example.core.DriverFactory.getDriver;

public class DSL {

    private static final Logger log = Logger.getLogger(DSL.class.getName());
    private final int timeout = Integer.parseInt(PropertiesManager.getProp("timeout"));

    public void esperarElementoFicarClicavel(WebElement webElement) {
        new WebDriverWait(getDriver(), timeout)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void esperarElementoFicarVisivel(WebElement webElement) {
        new WebDriverWait(getDriver(), timeout)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public void esperarElementoSairDaTela(WebElement webElement) {
        new WebDriverWait(getDriver(), timeout)
                .until(ExpectedConditions.invisibilityOf(webElement));
    }

    public void tentarClicarBotaoLoop(WebElement webElement) throws InterruptedException {
        int tentativas = 0;
        do {
            try {
                waitProcessPage();
                esperarElementoFicarClicavel(webElement);
                webElement.click();
            } catch (Exception ignored) {
            }
            tentativas++;
        } while (tentativas < 10);
    }

    public void clicarElemento(WebElement webElement) {
        try {
            waitProcessPage();
            esperarElementoFicarClicavel(webElement);
            webElement.click();
        } catch (ElementNotInteractableException e) {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(webElement).click().build().perform();
        } catch (WebDriverException e) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].click();", webElement);
        } catch (Exception e) {
            ScenarioRepository.screenShot(getDriver());
            log.error("Falha ao clicar no elemento :" + webElement);
        }
    }

    public void tirarPrint(){
        waitProcessPage();
        ScenarioRepository.screenShot(getDriver());
    }

    public void tirarPrint(WebElement... webElements){
        waitProcessPage();

        ScenarioRepository.screenShot(getDriver(), webElements);
    }

    public String recuperarTexto(WebElement webElement) {
        String valor = null;
        try {
            waitProcessPage();
            esperarElementoFicarVisivel(webElement);
            valor = webElement.getText();
        } catch (Exception e) {
            ScenarioRepository.screenShot(getDriver());
            log.error("Falha ao clicar no elemento :" + webElement);
        }
        return valor;
    }

    public void correrListaEClicarElemento(List<WebElement> listaDeElementos, String campo) {
        for (WebElement webElement : listaDeElementos) {
            if (recuperarTexto(webElement).equalsIgnoreCase(campo)) {
                clicarElemento(webElement);
                break;
            }
        }
    }

    public void digitarTexto(WebElement webElement, String texto) {
        try {
            waitProcessPage();
            esperarElementoFicarVisivel(webElement);
            webElement.sendKeys(texto);
        } catch (Exception e) {
            ScenarioRepository.screenShot(getDriver());
            log.error("Falha ao clicar no elemento :" + webElement);
        }
    }

    public boolean verificaElementoPresenteTela(WebElement webElement) {
        boolean valor = false;
        try {
            waitProcessPage();
            esperarElementoFicarClicavel(webElement);
            valor = webElement.isDisplayed();
        } catch (Exception e) {
            ScenarioRepository.screenShot(getDriver());
            log.error("Falha ao clicar no elemento :" + webElement);
        }
        return valor;
    }

    private void waitProcessPage(){
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), timeout);
        webDriverWait.until(waitProcess());
    }

    private ExpectedCondition<Boolean> waitProcess() {
        return driver -> {
            try {
                String js = "var reqAjax = typeof window.Ajax !== 'undefined' ?window.Ajax.activeRequestCount : 0;\n" +
                        "var reqAngular = typeof angular !== 'undefined' ? angular.by(document.body).injector().get('$http').pendingRequests.length : 0;\n" +
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
