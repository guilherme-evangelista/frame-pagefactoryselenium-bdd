#language: pt
#encoding: utf-8

  Funcionalidade: teste frame

    @busca @mariliamendoca
    Cenario: Pesquisar por marilia mendonça
      Dado que eu acesso o site
      Quando busco por "marilia mendonça"
      Então os resultados sao exibidos

    @busca @micheltelo
    Cenario: Pesquisar por michel telo
      Dado que eu acesso o site
      Quando busco por "michel telo"
      Então os resultados sao exibidos