import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Cenario4 {
    

    public static void main(String[] args) {
        
        String domain = "http://demo.automationtesting.in/Register.html";
        
        case4();
    }
    
    public static void case4() {
        WebDriver nav = webIncognito("http://demo.automationtesting.in/Register.html");
        nav.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // Navega pelo top menu
        try {
            WebElement widgets = nav.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[5]"));
            Actions actions = new Actions(nav);
            actions.moveToElement(widgets).perform();
            System.out.println("Barra encontrada!");
        } catch (Exception e) {
            System.out.println("Elemento não encontrado. Erro: " + e.getMessage());
        }

        try {
            WebElement widgets4 = nav.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[5]/ul/li[4]"));
            widgets4.click();
        } catch (Exception e) {
            System.out.println("Erro ao acessar elemento. Erro: " + e.getMessage());
        }

        // Encontre o elemento de entrada de data
        WebElement slider = nav.findElement(By.xpath("//*[@id='slider']"));

        // Obtenha a largura da barra de slide
        int larguraSlider = slider.getSize().getWidth();

        // Imprima a largura
        System.out.println(larguraSlider);

        // Calcule a posição para mover 50% da barra de slide
        int pos1 = 0;
        // int posicao2 = larguraSlider / 2;

        // Crie uma instância de ActionChains
        Actions action = new Actions(nav);

        // Clique e segure o controle deslizante, mova-o e, em seguida, libere
        action.clickAndHold(slider).moveByOffset(pos1, 0).release().perform();
        // action.clickAndHold(slider).moveByOffset(posicao2, 0).release().perform();

        try {
            // Aguarde 10 segundos
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Ou qualquer outra manipulação de exceção que você deseja fazer
        }

        // Feche o navegador
        nav.quit();

    }

    public static WebDriver webIncognito(String url) {
        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\rayan\\AppData\\Local\\Programs\\Python\\Python312\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--ignore-certificate-errors");
        WebDriver nav = new ChromeDriver(options);
        nav.manage().window().maximize();
        nav.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        nav.get(url);
        return nav;
    }

}