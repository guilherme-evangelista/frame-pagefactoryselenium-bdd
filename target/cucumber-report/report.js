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
formatter.embedding("image/png", "embedded1.png", null);
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "os resultados são exibidos",
  "keyword": "Então "
});
formatter.match({
  "location": "com.example.steps.TestSteps.osResultadosSãoExibidos()"
});
formatter.embedding("image/png", "embedded2.png", null);
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertTrue(Assert.java:52)\r\n\tat com.example.steps.TestSteps.osResultadosSãoExibidos(TestSteps.java:32)\r\n\tat ✽.os resultados são exibidos(file:///E:/git/framepagefactory/src/test/features/Example/Example.feature:12)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
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
formatter.embedding("image/png", "embedded3.png", null);
formatter.result({
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
formatter.step({
  "name": "busco por \"michel telo\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "com.example.steps.TestSteps.buscoPor(java.lang.String)"
});
formatter.embedding("image/png", "embedded4.png", null);
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "os resultados são exibidos",
  "keyword": "Então "
});
formatter.match({
  "location": "com.example.steps.TestSteps.osResultadosSãoExibidos()"
});
formatter.embedding("image/png", "embedded5.png", null);
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});