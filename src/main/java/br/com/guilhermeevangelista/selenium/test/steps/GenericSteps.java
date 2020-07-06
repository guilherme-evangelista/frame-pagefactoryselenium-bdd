package br.com.guilhermeevangelista.selenium.test.steps;

import br.com.guilhermeevangelista.selenium.core.driver.BasePage;
import io.cucumber.java.pt.Então;
import org.junit.Assert;

public class GenericSteps {

    BasePage base = new BasePage();

    @Então("valido que a mensagem {string} esta sendo exibida")
    public void validoQueAMensagemEstaSendoExibida(String mensagem) {
        Assert.assertTrue(base.verificaTextoPresenteTela(mensagem));
        base.tirarPrint();
    }
}
