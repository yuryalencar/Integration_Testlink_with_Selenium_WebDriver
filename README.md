# Integration Testlink with Selenium WebDriver
**Integração da ferramenta: TestLink com o Selenium WebDriver - Atualizado em 18/10/2017**

**Versão das Tecnologias Utilizadas:**
*  TestLink 1.9.16 (Moka pot)
*  Selenium WebDriver 3.6.0

**Bibliotecas e Pacotes Necessárias:**
*  ws-commons-util-1.0.2.jar
*  xmlrpc-client-3.1.jar
*  xmlrpc-common-3.1.jar
*  testlink-api-client-2.0.jar
*  JUnit 4.12 - junit-4.12.jar
*  selenium-server-standalone-3.6.0.jar

**Pré-Requisitos:**
*  Possuir o TestLink instalado.
*  Possuir o Driver que manipula o navegador escolhido para a execução dos testes. Ex.: chromedriver(Google Chrome), geckodriver(Mozilla Firefox).
*  Caminho do driver pré-inseridos nas variáveis do sistema.
*  Importar no Projeto as Bibliotecas e Pacotes Citados Anteriormente.

**Configuração do TestLink:**
*  Passo 1: Alterar o arquivo "custom\_config.inc.php.example" para "custom_config.inc.php".
*  Passo 2: Adicionar duas linhas uma contendo: "$tlCfg->api->enabled = TRUE;" e outra "$tlCfg->exec_cfg->enabled_test_automation = ENABLED;".
*  Passo 3: Modificar o tipo de execução do Caso de Teste para "Automatizado".

**Configuração do Projeto de Testes com o SeleniumWebDriver:**
*  Criar uma classe de integração que pode deve ser utilizada em todos os testes com a finalidade de fazer o upload dos resultados.
*  Verificar a utilização de "Assert's" do JUnit, o mal uso pode acarretar problemas no envio de erros.
*  Obs.: Os testes também utilizam dos drivers para a manipulação dos navegadores.

_Obs.: Um exemplo genérico da configuração do projeto de testes usando o SeleniumWebDriver pode ser encontrado no projeto atual. Os códigos referentes à configuração estão presentes em: path\_do\_computador\integration\_testlink\_with\_selenium\_webdriver\ExemploIntegracao\test\org\unipampa\exemplointegracao\br._

**_Contato: yuryalencar19@gmail.com e julianamareco18@gmail.com_**