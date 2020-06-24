#language: pt
#encoding: utf-8

@cadastro @regressivo
Funcionalidade: Cadastro

  @positivo @web
  Cenario: Realizar cadastro com sucesso no sistema
    Dado que eu acesso o site
    Quando clico em novo usuario
    E crio um usuario preenchendo corretamente os campos de cadastro
    Então valido que a mensagem "Usuário inserido com sucesso" esta sendo exibida

