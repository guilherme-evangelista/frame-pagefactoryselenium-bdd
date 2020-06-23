package br.com.guilhermeevangelista.selenium.pages;

import br.com.guilhermeevangelista.selenium.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    
    @FindBy (xpath = "//a[contains(text(), 'Novo usuário?')]")
    private WebElement btnNovoUsuario;

    @FindBy (xpath = "//input[@name='email']")
    private WebElement cmpEmail;

    @FindBy (xpath = "//input[@name='senha']")
    private WebElement cmpSenha;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement btnEntrar;

    public boolean aguardarPaginaInicialCarregar(){
        super.tirarPrint(cmpEmail, cmpSenha, btnEntrar);
        return super.verificaElementoPresenteTela(btnEntrar);
    }

    public void clicarBotaoNovoUsuario(){
        super.clicarElemento(btnNovoUsuario);
        tirarPrint(btnNovoUsuario);
    }

    public void clicarBotaoEntrar(){
        super.clicarElemento(btnEntrar);
    }

    public boolean validarMensagemDeCadastro(String text){
        super.tirarPrint();
        return super.verificaTextoPresenteTela(text);
    }
}
