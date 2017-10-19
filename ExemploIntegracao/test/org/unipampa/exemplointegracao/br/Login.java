package org.unipampa.exemplointegracao.br;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testlink.api.java.client.TestLinkAPIResults;

/**
 * Exemplo de Classe de testes usando a integração com a finalidade
 * de se fazer vários reports.
 * @author Yury Alencar Lima
 */
public class Login {

    // Será utilizada posteriormente para a manipulação do navegador por todos os métodos
    // por isto pode ser definida como uma variável de classe com a finalidade de não precisar
    // criar a cada método um novo objeto relacionado.
    public static WebDriver driver;
    // OPCIONAL: Site sobre o teste, caso utilize mais de um site para realizar os testes é interessante
    // a utilização desta variável somente com a aplicação principal.
    public static String url = "https://SITE_UNDER_TESTING.com/";

    /**
     * Método que será executado antes de cada caso de teste com a finalidade
     * de abrir o navegador.
     * @throws MalformedURLException 
     */
    @Before
    public void openBrowser() throws MalformedURLException {
        //Esta linha modifica a propriedade do webdriver com a finalidade de apontar para o
        //local que está presente o driver manipulador do navegador escolhido.
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Exemplo de método de teste utilizando reports integrados com o TestLink.
     * @throws Exception 
     */
    @Test
    public void exampleTest() throws Exception {
        // Se torna necessário para saber quando acontece um erro nos passos e assim
        //reportar o erro através do catch
        try {
            // Ir à URL do SITE UNDER TESTING
            driver.get(url);
        
            //@TODO : IMPLEMENTAR TODO SEU CASO DE TESTES.
            
            // É Recomendado que para cada passo do Caso de Testes especificados se tenha
            //uma verificação IF ao invés do Assert com a finalidade de verificação está
            //escolha implica na possibilidade de enviar mensagens de erros diferentes indicando
            //assim o passo que foi encontrado o erro. (Exemplo de verificar se um elemento existe)
            if (driver.findElement(By.cssSelector("span.header-btn-text")) == null) { 
                throw new Exception("PASSO X: NÃO FOI POSSÍVEL E ENCONTRAR O ELEMENTO"
                        + " --- DENTRO DA PÁGINA ----");
            }
            
            // Caso passem em todos os passos é reportado o sucesso do teste através deste exemplo
            ExemploIntegracao.updateResults("ExampleTestCase", null, TestLinkAPIResults.TEST_PASSED);
        } catch (Exception e) {
            // Caso tenha encontrado algum problema é enviado o erro para a nuvem utilizando a mensagem
            //presente no erro encontrado.
            ExemploIntegracao.updateResults("ExampleTestCase", e.getMessage(), 
                    TestLinkAPIResults.TEST_FAILED);
            
            // Como a entrada no bloco "catch" sinaliza a encontrada do erro é possível utilizar o
            //Assert.fail direto tendo em vista que o erro já foi encontrado, e é possível também
            //exibir a mensagem de acordo com o erro específico. (OPCIONAL: TENDO EM VISTA QUE TAMBÉM
            //É POSSÍVEL O USO DE ASSERTS E ENVIO DAS MENSAGENS REALICIONADAS, CASO ACONTEÇA O USO DE
            //ASSERTS DENTRO DO BLOCO "CATCH" É UTILIZADO AssertError)
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Método que contém a finalidade de fechar o navegador depois de cada execução.
     */
    @After
    public void closeBrowser() {
        driver.quit();
    }

}
