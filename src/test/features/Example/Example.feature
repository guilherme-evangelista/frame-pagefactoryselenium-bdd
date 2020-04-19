#language: pt
#encoding: utf-8

  Funcionalidade: teste frame

    Contexto: acessar o site
      Dado que eu acesso o site

    @busca @mariliamendoca
    Cenario: Pesquisar por marilia mendonça
      Quando busco por "marilia mendonça"
      Então os resultados são exibidos

    @busca @micheltelo
    Cenario: Pesquisar por michel telo
      Quando busco por "michel telo"
      Então os resultados são exibidos