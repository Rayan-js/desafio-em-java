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

public class Cenario3 {
    

    public static void main(String[] args) {
        
        String data_nasc = "10/19/1990";
        String domain = "http://demo.automationtesting.in/Register.html";
        
        case3(data_nasc);
    }
    
    public static void case3(String data_nasc) {
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
            WebElement datepicker = nav.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[5]/ul/li[3]"));
            datepicker.click();
        } catch (Exception e) {
            System.out.println("Erro ao acessar elemento. Erro: " + e.getMessage());
        }

        // Encontre o elemento de entrada de data
        WebElement dataElement = nav.findElement(By.xpath("//*[@id='datepicker1']"));

        // Remova o atributo "readonly" usando JavaScript para permitir a edição do campo
        ((JavascriptExecutor) nav).executeScript("arguments[0].removeAttribute('readonly')", dataElement);

        // Envie as teclas de atalho para limpar o campo
        dataElement.sendKeys(Keys.CONTROL + "a");
        dataElement.sendKeys(Keys.DELETE);

        // Envie as teclas de atalho para inserir a data desejada (substitua 'data_desejada' pela data real)
        dataElement.sendKeys(data_nasc);

        try {
            // Encontre o elemento de entrada de data
            WebElement dataFinal = nav.findElement(By.xpath("//*[@id='datepicker2']"));
        
            // Envie as teclas de atalho para limpar o campo
            dataFinal.sendKeys(Keys.CONTROL + "a");
            dataFinal.sendKeys(Keys.DELETE);
            dataFinal.sendKeys(data_nasc);
        
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        // Clique em um elemento específico após o bloco try-catch
        nav.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/h1")).click();
        

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