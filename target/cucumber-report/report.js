$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/features/Example.feature");
formatter.feature({
  "name": "teste frame",
  "description": "",
  "keyword": "Funcionalidade"
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
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "busco por \"marilia mendonça\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "com.example.steps.TestSteps.buscoPor(java.lang.String)"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "os resultados sao exibidos",
  "keyword": "Então "
});
formatter.match({
  "location": "com.example.steps.TestSteps.osResultadosSaoExibidos()"
});
formatter.embedding("image/png", "embedded1.png", null);
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Pesquisar por michel telo",
  "description": "",
  "keyword": "Cenario",
  "tags": [
    {
      "name": "@busca"
    },
    {
      "name": "@micheltelo"
    }
  ]
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
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "busco por \"michel telo\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "com.example.steps.TestSteps.buscoPor(java.lang.String)"
});
formatter.embedding("image/png", "embedded2.png", null);
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "os resultados sao exibidos",
  "keyword": "Então "
});
formatter.match({
  "location": "com.example.steps.TestSteps.osResultadosSaoExibidos()"
});
formatter.embedding("image/png", "embedded3.png", null);
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});