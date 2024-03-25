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

public class Cenario2 {
    

    public static void main(String[] args) {
        Zonyas z = new Zonyas(0);
        String[] dateInfo = z.weekDays();

        String dia = dateInfo[0];
        String dia_da_semana = dateInfo[1];
        String dia_do_mes = dateInfo[2];
        String ultimo_dia = dateInfo[3];
        String mes = dateInfo[4];
        String mes_extenso = dateInfo[5];
        String ano = dateInfo[6];
        String hora = dateInfo[7];
        String minuto = dateInfo[8];

        String domain = "http://demo.automationtesting.in/Register.html";

        
        case2(dia,mes,ano);
        
    }
    public static void case2(String dia, String mes, String ano) {
        WebDriver nav = webIncognito("http://demo.automationtesting.in/Register.html");
        nav.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        try {
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header']/div/div/div/div[1]/a/img")));
            System.out.println("Página carregada");
        } catch (Exception e) {
            System.out.println("Elemento não encontrado ou a página demorou muito para carregar.");
        }

        try {
            WebElement swichTo = nav.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[4]"));
            Actions actions = new Actions(nav);
            actions.moveToElement(swichTo).perform();
            System.out.println("Barra encontrada!");
        } catch (Exception e) {
            System.out.println("Elemento não encontrado. Erro: " + e.getMessage());
        }

        try {
            WebElement frames = nav.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[4]/ul/li[3]"));
            frames.click();
        } catch (Exception e) {
            System.out.println("Erro ao acessar elemento. Erro: " + e.getMessage());
        }

        try {
            WebElement iframe = nav.findElement(By.xpath("//*[@id='singleframe']"));
            nav.switchTo().frame(iframe);
            System.out.println("Mudei para o frame");
        } catch (Exception e) {
            System.out.println("Erro ao mudar para o frame. Erro: " + e.getMessage());
        }

        try {
            Thread.sleep(3000);
            WebElement input = nav.findElement(By.xpath("/html/body/section/div/div/div/input"));
            input.click();
            String texto = String.format("Teste automatizado em Java! data: %s/%s/%s", dia, mes, ano);
            input.sendKeys(texto);
        } catch (Exception e) {
            System.out.println("Erro ao acessar o input. Erro: " + e.getMessage());
        }

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