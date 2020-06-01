package com.example.core.utils;

import com.example.core.DSL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class XpathUtils{

    private DSL dsl = new DSL();

    public List<String> retornarListDeStringAPartirDeUmaListaDeElementos(WebElement... webElements){
        List<String> retorno = new ArrayList<>();
        for (WebElement webElement : webElements){
            retorno.add(dsl.recuperarTexto(webElement));
        }
        return retorno;
    }

}
