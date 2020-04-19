#language: pt
#encoding: utf-8
#author: toscana

  @login
  Funcionalidade: Login no sistema

    @loginsucesso
    Cenario: Realizar login com sucesso
      Dado que eu acesso o site
      Quando realizo login com usuario "valido"
      Então valido que o sistema apresenta uma mensagem de boas vindas

#    Cenario: Realizar login com email invalido
