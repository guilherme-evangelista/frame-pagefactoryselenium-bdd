package com.herokuapp.srbarriga.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[.='Seu Barriga']")
    private WebElement btnSeuBarriga;

    public boolean validarPresencaBotaoSeuBarriga(){
        return super.verificaElementoPresenteTela(btnSeuBarriga);
    }

}
