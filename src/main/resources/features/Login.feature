#language: pt
#encoding: utf-8

@login @regressivo
Funcionalidade: Login

  @positivo @web
  Cenario: Realizar login com sucesso no sistema
    Dado que eu acesso o site
    Quando realizo login com o usuario "padrao"
    Então valido que a mensagem "Bem vindo, Web Guilherme!" esta sendo exibida

  @negativo @web
  Cenario: Não realizar login ao passar email invalido
    Dado que eu acesso o site
    Quando realizo login com o usuario email invalido
    Então valido que nao foi possivel realizar o login

