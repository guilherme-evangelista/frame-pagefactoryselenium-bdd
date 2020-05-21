package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage extends BasePage{

    public TestPage(){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (xpath = "//input[@name='q']")
    private WebElement cmpPesquisa;

    @FindBy (xpath = "//img[@height='154']")
    private WebElement imgGoogle;

    @FindBy (xpath = "//input[@value='Pesquisa Google' and ancestor::div[@class='FPdoLc tfB0Bf']]")
    private WebElement btnPesquisar;

    @FindBy (xpath = "//div[@id='result-stats']")
    private WebElement msgResultadoDePesquisa;

    public boolean aguardarPaginaInicialCarregar(){
        super.tirarPrint();
        return super.verificaElementoPresenteTela(btnPesquisar);
    }

    public void preencherCampoDePesquisa(String busca){
        super.digitarTexto(cmpPesquisa, busca);
    }

    public void clicarBotaoPesquisar(){
        super.tirarPrint(cmpPesquisa, btnPesquisar);
        super.clicarElemento(btnPesquisar);
    }

    public boolean validarResultadoDePesquisa(){
        super.tirarPrint(msgResultadoDePesquisa);
        return super.verificaElementoPresenteTela(msgResultadoDePesquisa);
    }
}
