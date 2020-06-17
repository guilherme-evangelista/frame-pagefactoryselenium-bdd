package br.com.guilhermeevangelista.selenium.pages;

import br.com.guilhermeevangelista.selenium.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPage extends BasePage {
    
    @FindBy (xpath = "//input[@name='q']")
    private WebElement cmpPesquisa;

    @FindBy (xpath = "//input[@value='Estou com Sote' and parent::center[not(preceding-sibling::style)]]")
    private WebElement btnEstouComSorte;

    @FindBy (xpath = "//input[@value='Pesquisa Google' and parent::center[not(preceding-sibling::style)]]")
    private WebElement btnPesquisarGoogle;

    @FindBy (xpath = "//div[@id='search']")
    private WebElement msgResultadoDePesquisa;

    public boolean aguardarPaginaInicialCarregar(){
        super.tirarPrint(cmpPesquisa, btnEstouComSorte, btnPesquisarGoogle);
        return super.verificaElementoPresenteTela(cmpPesquisa);
    }

    public void preencherCampoDePesquisa(String busca){
        super.digitarTexto(cmpPesquisa, busca);
    }

    public void clicarBotaoPesquisar(){
        super.tirarPrint(cmpPesquisa, btnPesquisarGoogle);
        super.clicarElemento(btnPesquisarGoogle);
    }

    public boolean validarResultadoDePesquisa(){
        super.tirarPrint();
        return super.verificaElementoPresenteTela(msgResultadoDePesquisa);
    }
}
