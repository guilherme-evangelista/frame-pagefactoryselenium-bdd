#language: pt
#encoding: utf-8

@login @regressivo
Funcionalidade: Login

  @loginsucesso @positivo @web
  Cenario: Realizar login com sucesso no sistema
    Dado que eu acesso o site
    Quando realizo login com o usuario "314579"
    Entao valido que o login foi realizado com sucesso
