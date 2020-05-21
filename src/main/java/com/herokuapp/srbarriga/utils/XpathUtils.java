package com.herokuapp.srbarriga.utils;

import com.herokuapp.srbarriga.pages.BasePage;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XpathUtils extends BasePage {

    public List<String> retornarListDeStringAPartirDeUmaListaDeElementos(WebElement...elements){
        List<String> retorno = new ArrayList<>();
        for (WebElement element : elements){
            retorno.add(super.recuperarTexto(element));
        }
        return retorno;
    }
}
