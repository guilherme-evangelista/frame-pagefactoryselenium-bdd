package br.com.guilhermeevangelista.selenium.test.pages;

import br.com.guilhermeevangelista.selenium.core.driver.BasePage;
import br.com.guilhermeevangelista.selenium.core.utils.enums.Users;
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

    public void preencherEmail(String user){
        super.digitarTexto(cmpEmail, Users.valueOf(user.toUpperCase()).getEmail());
    }

    public void preencherSenha(String user){
        super.digitarTexto(cmpSenha, Users.valueOf(user.toUpperCase()).getSenha());
    }

    public void clicarBotaoEntrar(){
        super.tirarPrint(cmpEmail, cmpSenha, btnEntrar);
        super.clicarElemento(btnEntrar);
    }

    public boolean validarTelaLogin(){
        super.tirarPrint();
        return super.verificaElementoPresenteTela(btnNovoUsuario);
    }

}
