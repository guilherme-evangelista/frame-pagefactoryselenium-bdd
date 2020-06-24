package br.com.guilhermeevangelista.selenium.pages.enums;

public enum Users {
    PADRAO("WebGuilherme@TestAutomacao1", "testsenha1");

    String email, senha, nome;

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
}
