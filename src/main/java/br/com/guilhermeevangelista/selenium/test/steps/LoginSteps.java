package br.com.guilhermeevangelista.selenium.test.steps;

import br.com.guilhermeevangelista.selenium.test.pages.LoginSFPage;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class LoginSteps {

    protected LoginSFPage loginPage = new LoginSFPage();

    @Dado("^que eu acesso o site$")
    public void queEuAcessoOSite() {
        Assert.assertTrue(loginPage.aguardarPaginaInicialCarregar());
    }

    @Quando("^clico em novo usuario$")
    public void clicoEmNovoUsuario() {

    }

    @Quando("^realizo login com o usuario email invalido$")
    public void realizoLoginComOUsuarioEmailInvalido() {
        loginPage.preencherEmail("invalido");
        loginPage.preencherSenha("invalido");
        loginPage.clicarBotaoEntrar();
    }

    @Então("valido que nao foi possivel realizar o login$")
    public void validoQueNaoFoiPossivelRealizarOLogin() {
        Assert.assertTrue(loginPage.validarTelaLogin());
    }

    @Quando("^realizo login com o usuario \"([^\"]*)\"$")
    public void realizoLoginComOUsuario(String user) throws Throwable {
        loginPage.preencherEmail(user);
        loginPage.preencherSenha(user);
        loginPage.clicarBotaoEntrar();
    }
}
