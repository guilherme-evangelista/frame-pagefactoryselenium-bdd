package br.com.guilhermeevangelista.selenium.pages;

import br.com.guilhermeevangelista.selenium.core.driver.BasePage;

import br.com.guilhermeevangelista.selenium.core.utils.FakeUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroPage extends BasePage {

    @FindBy(xpath = "//input[@name='nome']")
    private WebElement cmpNome;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement cmpEmail;

    @FindBy(xpath = "//input[@name='senha']")
    private WebElement cmpSenha;

    @FindBy(xpath = "//input[@value='Cadastrar']")
    private WebElement btnCadastrar;

    public void preencherNome(){
        super.digitarTexto(cmpNome, FakeUtils.gerarNomeCompleto());
    }

    public void preencherSenha(){
        super.digitarTexto(cmpSenha, FakeUtils.gerarCpf(false));
    }

    public void preencherEmail(){
        super.digitarTexto(cmpEmail, FakeUtils.gerarEmail());
    }

    public void clicarBotaoCadastrar(){
        tirarPrint(btnCadastrar);
        super.clicarElemento(btnCadastrar);
    }

}
