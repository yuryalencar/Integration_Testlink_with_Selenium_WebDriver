# Integration Testlink with Selenium WebDriver
**Integração da ferramenta: TestLink com o Selenium WebDriver - Atualizado em 18/10/2017**

**Versão das Tecnologias Utilizadas:**
*  TestLink 1.9.16 (Moka pot)
*  Selenium WebDriver 3.6.0

**Bibliotecas Necessárias:**
*  ws-commons-util-1.0.2.jar
*  xmlrpc-client-3.1.jar
*  xmlrpc-common-3.1.jar
*  testlink-api-client-2.0.jar
*  JUnit 4.12 - junit-4.12.jar
*  selenium-server-standalone-3.6.0.jar

**Pré-Requisitos:**
*  Possuir o TestLink instalado
*  Importar no Projeto as Bibliotecas Anteriormente Citadas

**Configuração do TestLink:**
*  Passo 1: Alterar o arquivo "custom_config.inc.php.example" para "custom_config.inc.php"
*  Passo 2: Adicionar duas linhas uma contendo: "$tlCfg->api->enabled = TRUE;" e outra "$tlCfg->exec_cfg->enabled_test_automation = ENABLED;"
*  Passo 3: Modificar o tipo de execução do Caso de Teste para "Automatizado"

**Configuração do Selenium:**
*  Criar uma classe de integração que pode deve ser utilizada em todos os testes com a finalidade de fazer o upload dos resultados.
*  Verificar a utilização de "Assert's" do JUnit, o mal uso pode acarretar problemas no envio de erros.