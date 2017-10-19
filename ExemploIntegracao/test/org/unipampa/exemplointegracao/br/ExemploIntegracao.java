package org.unipampa.exemplointegracao.br;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

/**
 * Classe de exemplo de integração entre o TestLink e o Selenium WebDriver
 * Atualizada em 18/10/2017
 * 
 * @author Yury Alencar Lima
 */
public class ExemploIntegracao {

    // Key da API, que se localiza nas configurações, cuidado para não gerar mais de uma.
    public static final String TESTLINK_KEY = "de56f17331a52bf204393c559c76cc39";
    // Link referente à URL do TestLink que será feita a conexão.
    public static final String TESTLINK_URL = "http://NOME_DO_HOST/testlink(PODE_VARIAR)/lib/api/xmlrpc/v1/xmlrpc.php";
    // Nome do projeto no TestLink que será testado.
    public static final String TEST_PROJECT_NAME = "EXAMPLE PROJECT NAME";
    // Nome do Plano de teste referente ao projeto no TestLink que será testado.
    public static final String TEST_PLAN_NAME = "EXAMPLE TEST PLAN NAME";
    // OPCIONAL: Nome do caso de teste presente projeto no TestLink que será testado.
    public static final String TEST_CASE_NAME = "EXAMPLE TEST CASE NAME";
    // Nome do Baseline referente ao projeto no TestLink que será testado.
    public static final String BUILD_NAME = "EXAMPLE BASELINE NAME";
    
    /**
     * Este método tem como finalidade enviar os resultados encontrados por meio
     * dos testes para o TestLink na nuvem.
     * @param testCaseName - Nome do caso de testes previamente já inserido no TestLink.
     * @param exception - Notas relacionadas ao erro encontrado caso o teste tenha falhado.
     * @param results - Resultado referente ao final do teste podendo ser PASSOU, FALHOU dentre os
     * suportados pela ferramenta.
     * @throws TestLinkAPIException 
     */
    public static void updateResults(String testCaseName, String exception, String results) throws TestLinkAPIException{
        // Conectando com o TestLink por meio da chave e da URL.
        TestLinkAPIClient testlink = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
        // Reportando os resultados encontrados através dos testes anteriormente executados.
        testlink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName,
                BUILD_NAME, exception, results);
    }
    
}
