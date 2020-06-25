package br.com.guilhermeevangelista.selenium.steps;

import br.com.guilhermeevangelista.selenium.pages.LoginPage;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import org.junit.Assert;

public class LoginSteps {

    protected LoginPage loginPage = new LoginPage();

    @Dado("que eu acesso o site")
    public void queEuAcessoOSite() {
        Assert.assertTrue(loginPage.aguardarPaginaInicialCarregar());
    }

    @Quando("clico em novo usuario")
    public void clicoEmNovoUsuario() {
        loginPage.clicarBotaoNovoUsuario();
    }

    @Então("valido que a mensagem {string} esta sendo exibida")
    public void validoQueAMensagemEstaSendoExibida(String mensagem) {
        Assert.assertTrue(loginPage.validarMensagemDeCadastro(mensagem));
    }

    @Quando("realizo login com o usuario {string}")
    public void realizoLoginComOUsuario(String user) {
        loginPage.preencherEmail(user);
        loginPage.preencherSenha(user);
        loginPage.clicarBotaoEntrar();
    }

    @Quando("realizo login com o usuario email invalido")
    public void realizoLoginComOUsuarioEmailInvalido() {
        loginPage.preencherEmail("invalido");
        loginPage.preencherSenha("invalido");
        loginPage.clicarBotaoEntrar();
    }

    @Então("valido que nao foi possivel realizar o login")
    public void validoQueNaoFoiPossivelRealizarOLogin() {
        Assert.assertTrue(loginPage.validarTelaLogin());
    }
}
