package com.herokuapp.srbarriga.steps;

import com.herokuapp.srbarriga.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage;

    public LoginSteps(){
        loginPage = new LoginPage();
    }

    @Dado("que eu acesso o site")
    public void queEuAcessoOSite() {
        Assert.assertTrue(loginPage.validarPresencaBotaoSeuBarriga());
    }

    @Quando("realizo login com usuario {string}")
    public void realizoLoginComUsuario(String status) {

    }
}
