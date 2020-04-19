$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/features/Example/Example.feature");
formatter.feature({
  "name": "teste frame",
  "description": "",
  "keyword": "Funcionalidade"
});
formatter.background({
  "name": "acessar o site",
  "description": "",
  "keyword": "Contexto"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que eu acesso o site",
  "keyword": "Dado "
});
formatter.match({
  "location": "com.example.steps.TestSteps.queEuAcessoOSite()"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Pesquisar por marilia mendonça",
  "description": "",
  "keyword": "Cenario",
  "tags": [
    {
      "name": "@busca"
    },
    {
      "name": "@mariliamendoca"
    }
  ]
});
formatter.step({
  "name": "busco por \"marilia mendonça\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "com.example.steps.TestSteps.buscoPor(java.lang.String)"
});
