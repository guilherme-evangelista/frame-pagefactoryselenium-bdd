package com.example.steps;

import com.example.pages.TestPage;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import org.junit.Assert;

public class TestSteps {

    protected TestPage testPage;

    public TestSteps(){
        this.testPage = new TestPage();
    }

    @Dado("que eu acesso o site")
    public void queEuAcessoOSite() {
        Assert.assertTrue(testPage.aguardarPaginaInicialCarregar());
    }

    @Quando("busco por {string}")
    public void buscoPor(String busca) {
        testPage.preencherCampoDePesquisa(busca);
        testPage.clicarBotaoPesquisar();
    }

    @Então("os resultados são exibidos")
    public void osResultadosSãoExibidos() {
        Assert.assertTrue(testPage.validarResultadoDePesquisa());
    }
}
