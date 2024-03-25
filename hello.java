import java.util.HashMap;
import java.util.Map;


public class hello {
    
    public static void main(String[] args) {
        Zonyas z = new Zonyas(0);
        String[] dateInfo = z.weekDays();

        String dia = dateInfo[0];
        String mes = dateInfo[4];
        String ano = dateInfo[6];
        
        String data_nasc = "10/19/1990";
        // Cenario1 cenario = new Cenario1();
        // cenario.case1();

        // Chamar a funcionalidade do Cenario1
        Cenario1.case1();
        // Chamar a funcionalidade do Cenario2
        Cenario2.case2(dia,mes,ano);
        // Chamar a funcionalidade do Cenario3
        Cenario3.case3(data_nasc);
        // Chamar a funcionalidade do Cenario4
        Cenario4.case4();

        System.out.print("Hello World!\n");

        // Exemplos de uso
        pRed("Texto em vermelho");
        pGreen("Texto em verde");
        pYellow("Texto em amarelo");
        pCyan("Texto em ciano");

        // Use as informações obtidas na formatação da mensagem e chame a função pGreen()
        pGreen("%s/%s/%s\n", dia, mes, ano);
    }


    public static void pRed(String texto) {
        // Instanciando a classe PrintColor com a cor vermelha e negrito
        PrintColor printRed = new PrintColor(null, "red", null, true, false, false);
        // Chamando o método printText da instância com o texto fornecido
        printRed.printText(texto);
    }

    public static void pGreen(String format, Object... args) {
        // Instanciando a classe PrintColor com a cor verde e negrito
        PrintColor printGreen = new PrintColor(null, "green", null, true, false, false);
        // Construindo a string formatada
        String text = String.format(format, args);
        // Chamando o método printText da instância com o texto fornecido
        printGreen.printText(text);
    }

    public static void pYellow(String text) {
        // Instanciando a classe PrintColor com a cor amarela (sem negrito)
        PrintColor printYellow = new PrintColor(null, "yellow", null, false, false, false);
        // Chamando o método printText da instância com o texto fornecido
        printYellow.printText(text);
    }

    public static void pCyan(String text) {
        // Instanciando a classe PrintColor com a cor ciano e negrito
        PrintColor printCyan = new PrintColor(null, "cyan", null, true, false, false);
        // Chamando o método printText da instância com o texto fornecido
        printCyan.printText(text);
    }

    public static String[] times(String[] args) {
        // Crie uma instância de Zonyas com um deslocamento de dias
        Zonyas zonyas = new Zonyas(0);

        // Chame o método weekDays() para obter informações sobre o dia atual
        return zonyas.weekDays();
    }
}
