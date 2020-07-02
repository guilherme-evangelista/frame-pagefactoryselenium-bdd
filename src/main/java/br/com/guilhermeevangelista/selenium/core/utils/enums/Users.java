package br.com.guilhermeevangelista.selenium.core.utils.enums;

public enum Users {
    PADRAO("WebGuilherme@TestAutomacao1", "testsenha1"),
    INVALIDO("WebtGuilhermeTestAutomacao1", "testsenha1"),

    CADASTRADO("", "");

    String email, senha;

    Users(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}