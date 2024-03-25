import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Cenario1 {

    // Variáveis de dados do formulário
    private static final String nome = "Bruce";
    private static final String sobrenome = "Wayne";
    private static final String email = "teste@exemplo";
    private static final String telefone = "55019985654582";
    private static final String ano_de_nascimento = "1990";
    private static final String mes_de_nascimento = "october";
    private static final String dia_de_nascimento = "19";
    private static final String genero = "m";
    private static final String endereco = "WallStreet, boulevard -256 / NY";
    private static final String[] hobbies_a_automatizar = {"Leparkour", "Movies", "Hockey"};
    private static final String[] idiomas = {"English", "Portuguese", "Spanish", "French"};
    private static final String[] habilidades = {"C++"};
    private static final String pais = "Japan";
    private static final String senha = "sem_senha";
    private static final String caminho_do_arquivo = "C:\\Users\\rayan\\OneDrive\\Imagens\\baki.jpg";
    

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

        // WebDriver nav = webIncognito(domain);
        // ChromeDriver nav = new ChromeDriver() ;
        case1();
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        // // WebDriverWait wait = new WebDriverWait(nav, 10);

        // try {
        //     // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header']/div/div/div/div[1]/a/img")));
        //     System.out.println("Página carregada");
        // } catch (Exception e) {
        //     System.out.println("Elemento não encontrado ou a página demorou muito para carregar.");
        // }

        // try {
        //     WebElement nomeElement = nav.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[1]/input"));
        //     nomeElement.sendKeys("Bruce");
        //     nav.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[2]/input")).sendKeys("Wayne");
        //     System.out.println("Nome e sobrenome preenchidos");
        // } catch (Exception e) {
        //     System.out.println("Elemento não encontrado.  Erro: " + e.getMessage());
        // }

        // // Continuar preenchendo o formulário...
    }

    public static void case1() {
        WebDriver nav = webIncognito("http://demo.automationtesting.in/Register.html");
        nav.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {

            System.out.println("Página carregada");
        } catch (Exception e) {
            System.out.println("Elemento não encontrado ou a página demorou muito para carregar.");
        }

        try {
            WebElement nomeElement = nav.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[1]/input"));
            nomeElement.sendKeys(nome);
            nav.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[2]/input")).sendKeys(sobrenome);
            System.out.println("Nome e sobrenome preenchidos");
        } catch (Exception e) {
            System.out.println("Elemento não encontrado.  Erro: " + e.getMessage());
        }

        try {
            nav.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[2]/div/textarea")).sendKeys(endereco);
            System.out.println("Endereço preenchido");
        } catch (Exception e) {
            System.out.println("Elemento não encontrado.  Erro: " + e.getMessage());
        }

        // Mais código continua...

        // Email e telefone
        try {
            nav.findElement(By.xpath("//*[@id='eid']/input")).sendKeys(email);
            WebElement phone = nav.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[4]/div/input"));

            // Execute um script JavaScript para alterar o padrão do telefone
            String novoPadrao = "^\\d{10,15}$";
            String script = String.format("arguments[0].setAttribute('pattern', '%s')", novoPadrao);
            ((ChromeDriver) nav).executeScript(script, phone);

            phone.sendKeys(telefone);
            System.out.println("E-mail e telefone preenchidos");
        } catch (Exception e) {
            System.out.println("Elemento não encontrado. Erro: " + e.getMessage());
        }

        // Gênero
        try {
            String primeiraLetra = String.valueOf(genero.charAt(0)).toLowerCase();
            if (primeiraLetra.equals("m")) {
                nav.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[5]/div/label[1]/input")).click();
            } else {
                nav.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[5]/div/label[2]/input")).click();
            }
            System.out.println("Gênero preenchido");
        } catch (Exception e) {
            System.out.println("Elemento não encontrado. Erro: " + e.getMessage());
        }

        // Hobbies
        try {
            for (String hobby : hobbies_a_automatizar) {
                switch (hobby) {
                    case "Cricket":
                        nav.findElement(By.id("checkbox1")).click();
                        break;
                    case "Movies":
                        nav.findElement(By.id("checkbox2")).click();
                        break;
                    case "Hockey":
                        nav.findElement(By.id("checkbox3")).click();
                        break;
                    default:
                        break;
                }
            }
            System.out.println("Hobbies preenchidos");
        } catch (Exception e) {
            System.out.println("Erro ao acessar elemento, erro: " + e.getMessage());
        }

        // Linguas
        try {
            // Localizar o menu de seleção de idioma
            WebElement menuLingua = nav.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[7]/div/multi-select"));
            menuLingua.click();

            // Aguardar 1 segundo
            Thread.sleep(1000);

            // Obter a lista de elementos de idioma
            List<WebElement> linguas = menuLingua.findElements(By.tagName("li"));

            // Iterar sobre os elementos da lista
            for (int i = 0; i < linguas.size(); i++) {
                WebElement linguaLi = linguas.get(i);
                WebElement lingua = linguaLi.findElement(By.tagName("a"));

                // Aguardar 0.5 segundos
                Thread.sleep(500);

                // Verificar se o idioma está na lista desejada
                if (contemIdioma(lingua.getText(), idiomas)) {
                    // Scrollar a página até o elemento
                    ((JavascriptExecutor) nav).executeScript("arguments[0].scrollIntoView();", linguaLi);

                    // Aguardar 0.5 segundos
                    Thread.sleep(500);

                    // Exibir o nome do idioma em verde
                    System.out.println(lingua.getText());

                    // Selecionar o idioma
                    lingua.click();

                    System.out.println("Idioma escolhido");

                    // Sair do loop após selecionar o idioma
                    // break;
                }
            }
            nav.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[1]/input")).click();
        } catch (Exception e) {
            System.out.println("Elemento não encontrado. Erro: " + e.getMessage());}
            
          // Skills
        try {
            WebElement skillsSelect = nav.findElement(By.xpath("//*[@id='Skills']"));
            skillsSelect.click();
            Thread.sleep(1000);
            
            List<WebElement> skillsOptions = skillsSelect.findElements(By.tagName("option"));
            for (WebElement skillOption : skillsOptions) {
                String skill = skillOption.getText().trim();
                Thread.sleep(500);
                
                // Verifica se a habilidade está presente no array de habilidades
                boolean containsSkill = false;
                for (String habilidade : habilidades) {
                    if (habilidade.equals(skill)) {
                        containsSkill = true;
                        break;
                    }
                }
                
                if (containsSkill) {
                    ((JavascriptExecutor) nav).executeScript("arguments[0].scrollIntoView();", skillOption);
                    Thread.sleep(500);
                    System.out.println(skill);
                    skillOption.click();
                }
            }
            System.out.println("Habilidade adicionada");
            nav.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[1]/input")).click();
        } catch (Exception e) {
            System.out.println("Elemento não encontrado. Erro: " + e.getMessage());
        }
        

        // Localize o campo de pesquisa
        try {
            WebElement campoPesquisa = nav.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[10]/div/span/span[1]/span"));
            campoPesquisa.click();

            Thread.sleep(1000);

            // Digite o nome do país na caixa de pesquisa
            WebElement pesquisa = nav.findElement(By.xpath("/html/body/span/span/span[1]/input"));
            pesquisa.sendKeys(pais);

            Thread.sleep(1000);

            campoPesquisa.sendKeys(Keys.ARROW_DOWN);
            campoPesquisa.sendKeys(Keys.ENTER);

            System.out.println("País selecionado!");
        } catch (Exception e) {
            System.out.println("Elemento não encontrado. Erro: " + e.getMessage());
        }
        
        // Selecione a data
        try {
            WebElement anoElement = nav.findElement(By.xpath("//*[@id='yearbox']"));
            WebElement mesElement = nav.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[11]/div[2]/select"));
            WebElement diaElement = nav.findElement(By.xpath("//*[@id='daybox']"));

            anoElement.click();
            Thread.sleep(300);
            anoElement.sendKeys(ano_de_nascimento);
            anoElement.sendKeys(Keys.ENTER);

            Thread.sleep(300);
            mesElement.click();
            Thread.sleep(300);
            mesElement.sendKeys(mes_de_nascimento);
            mesElement.sendKeys(Keys.ENTER);

            Thread.sleep(300);
            diaElement.click();
            Thread.sleep(300);
            diaElement.sendKeys(dia_de_nascimento);
            diaElement.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Elemento não encontrado. Erro: " + e.getMessage());
        }

        // Digita uma senha
        try {
            WebElement firstPasswordField = nav.findElement(By.xpath("//*[@id='firstpassword']"));
            WebElement secondPasswordField = nav.findElement(By.xpath("//*[@id='secondpassword']"));

            firstPasswordField.sendKeys(senha);
            secondPasswordField.sendKeys(senha);

            System.out.println("Senha digitada com sucesso!");
        } catch (Exception e) {
            System.out.println("Elemento não encontrado. Erro: " + e.getMessage());
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        // Photo
        try {
            WebElement photoBtnSection = nav.findElement(By.xpath("//*[@id='section']/div/div/div[3]/div[2]/input"));
            Thread.sleep(1000);
            
            // Envie o caminho do arquivo para o elemento de upload de arquivo
            photoBtnSection.sendKeys(caminho_do_arquivo);
            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println("Elemento não encontrado. Erro: " + e.getMessage());
        }

        // Submit  Formulário
        try {
            nav.findElement(By.xpath("//*[@id='submitbtn']")).click();
            System.out.println("Automação concluída!");
        } catch (Exception e) {
            System.out.println("Elemento não encontrado. Erro: " + e.getMessage());
        }

}

    private static boolean contemIdioma(String idioma, String[] idiomas) {
            for (String idiomaLista : idiomas) {
                if (idioma.equals(idiomaLista)) {
                    return true;
                }
            }
            return false;
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