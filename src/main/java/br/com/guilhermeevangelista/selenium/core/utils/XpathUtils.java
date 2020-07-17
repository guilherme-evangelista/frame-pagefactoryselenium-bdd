package br.com.guilhermeevangelista.selenium.core.utils;

import br.com.guilhermeevangelista.selenium.core.driver.BasePage;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para interagir com xpath
 */
public class XpathUtils extends BasePage{

    /**
     * Metodo que retorna uma lista de String a partir de uma lista de elementos
     * @param elementos elemento(s) que contem texto
     */
    public List<String> retornarListDeStringAPartirDeUmaListaDeElementos(WebElement... elementos){
        List<String> retorno = new ArrayList<>();
        for (WebElement webElement : elementos){
            retorno.add(super.recuperarTexto(webElement));
        }
        return retorno;
    }

}
