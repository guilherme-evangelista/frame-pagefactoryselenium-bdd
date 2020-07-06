package br.com.guilhermeevangelista.selenium.core.driver;

import br.com.guilhermeevangelista.selenium.core.utils.PropertiesManager;
import br.com.guilhermeevangelista.selenium.core.utils.report.screenshot.ScenarioRepository;

import org.apache.log4j.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static br.com.guilhermeevangelista.selenium.core.driver.DriverFactory.getDriver;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(getDriver(), this);
    }

    private static final Logger log = Logger.getLogger(BasePage.class.getName());
    private final int timeout = Integer.parseInt(PropertiesManager.getProp("timeout"));

    protected void esperarElementoFicarClicavel(WebElement webElement) {
        new WebDriverWait(getDriver(), timeout)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void esperarElementoFicarVisivel(WebElement webElement) {
        new WebDriverWait(getDriver(), this.timeout)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void esperarElementoFicarVisivel(WebElement webElement, int timeout) {
        new WebDriverWait(getDriver(), timeout)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void esperarElementoSairDaTela(WebElement webElement) {
        new WebDriverWait(getDriver(), this.timeout)
                .until(ExpectedConditions.invisibilityOf(webElement));
    }

    protected void tentarClicarBotaoLoop(WebElement webElement) throws InterruptedException {
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

    protected void selecionarItemLista(WebElement elemento, String texto){
        Select lista = new Select(elemento);
        lista.selectByVisibleText(texto);
    }

    protected void selecionarItemLista(WebElement elemento, int index){
        Select lista = new Select(elemento);
        lista.selectByIndex(index);
    }

    protected void clicarElemento(WebElement elemento) {
        try {
            waitProcessPage();
            esperarElementoFicarClicavel(elemento);
            elemento.click();
        } catch (ElementNotInteractableException e) {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(elemento).click().build().perform();
        } catch (WebDriverException e) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].click();", elemento);
        } catch (Exception e) {
            ScenarioRepository.screenShot(getDriver());
            log.error("Falha ao clicar no elemento :" + elemento);
        }
    }

    protected void digitarTexto(WebElement elemento, String texto) {
        try {
            waitProcessPage();
            esperarElementoFicarVisivel(elemento);
            elemento.sendKeys(texto);
        } catch (WebDriverException e) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].value='"+texto+"';", elemento);
        } catch (Exception e) {
            ScenarioRepository.screenShot(getDriver());
            log.error("Falha ao digitar no elemento :" + elemento);
        }
    }

    protected String recuperarTexto(WebElement elemento) {
        String valor = null;
        try {
            waitProcessPage();
            esperarElementoFicarVisivel(elemento);
            valor = elemento.getText();
        } catch (Exception e) {
            ScenarioRepository.screenShot(getDriver());
            log.error("Falha ao clicar no elemento :" + elemento);
        }
        return valor;
    }

    public void tirarPrint(){
        waitProcessPage();
        ScenarioRepository.screenShot(getDriver());
    }

    public void tirarPrint(WebElement... webElements){
        waitProcessPage();

        ScenarioRepository.screenShot(getDriver(), webElements);
    }

    protected void correrListaEClicarElemento(List<WebElement> listaDeElementos, String campo) {
        for (WebElement webElement : listaDeElementos) {
            if (recuperarTexto(webElement).equalsIgnoreCase(campo)) {
                clicarElemento(webElement);
                break;
            }
        }
    }

    protected boolean verificaElementoPresenteTela(WebElement webElement) {
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

    public boolean verificaTextoPresenteTela(String text) {
        boolean valor = false;
        try {
            waitProcessPage();
            esperarElementoFicarClicavel(getDriver().findElement(By.xpath("//*[.='"+text+"']")));
            valor = getDriver().findElement(By.xpath("//*[.='"+text+"']")).isDisplayed();
        } catch (Exception e) {
            ScenarioRepository.screenShot(getDriver());
            log.error("Falha ao clicar no elemento :" + getDriver().findElement(By.xpath("//*[.='"+text+"']")));
        }
        return valor;
    }

    public void scrollAteOElemento(WebElement elemento){
        esperarElementoFicarVisivel(elemento);
        waitProcessPage();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", elemento);
    }

    public void scrollAteOFimDaPagina(){
        waitProcessPage();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollAteOTopoDaPagina(){
        waitProcessPage();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollTop)");
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

    public boolean validarMensagemPopUp(String texto) {
        System.out.println(getDriver().switchTo().alert().getText());
        return getDriver().switchTo().alert().getText().contains(texto);
    }
}
