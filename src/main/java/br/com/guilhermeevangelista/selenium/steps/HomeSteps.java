package br.com.guilhermeevangelista.selenium.steps;

import br.com.guilhermeevangelista.selenium.pages.HomePage;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

public class HomeSteps {

    private HomePage homePage = new HomePage();

    @Então("valido que o login foi realizado com sucesso")
    public void validoQueOLoginFoiRealizadoComSucesso() {
        Assert.assertTrue(homePage.validarTelaHomeAtiva());
    }
}
