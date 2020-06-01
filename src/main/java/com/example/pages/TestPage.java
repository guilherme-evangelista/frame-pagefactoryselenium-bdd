package com.example.pages;

import com.example.core.DSL;
import com.example.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage{
    
    private final DSL dsl;

    public TestPage(){
        dsl = new DSL();
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy (xpath = "//input[@name='q']")
    private WebElement cmpPesquisa;

    @FindBy (xpath = "//input[@value='Estou com Sote' and parent::center[not(preceding-sibling::style)]]")
    private WebElement btnEstouComSorte;

    @FindBy (xpath = "//input[@value='Pesquisa Google' and parent::center[not(preceding-sibling::style)]]")
    private WebElement btnPesquisarGoogle;

    @FindBy (xpath = "//div[@id='search']")
    private WebElement msgResultadoDePesquisa;

    public boolean aguardarPaginaInicialCarregar(){
        dsl.tirarPrint(cmpPesquisa, btnEstouComSorte, btnPesquisarGoogle);
        return dsl.verificaElementoPresenteTela(cmpPesquisa);
    }

    public void preencherCampoDePesquisa(String busca){
        dsl.digitarTexto(cmpPesquisa, busca);
    }

    public void clicarBotaoPesquisar(){
        dsl.tirarPrint(cmpPesquisa, btnPesquisarGoogle);
        dsl.clicarElemento(btnPesquisarGoogle);
    }

    public boolean validarResultadoDePesquisa(){
        dsl.tirarPrint();
        return dsl.verificaElementoPresenteTela(msgResultadoDePesquisa);
    }
}
