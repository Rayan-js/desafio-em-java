import java.util.HashMap;
import java.util.Map;

public class PrintColor {

    private String text;
    private String color;
    private String background;
    private boolean bold;
    private boolean underline;
    private boolean italic;

    public PrintColor(String text, String color, String background, boolean bold, boolean underline, boolean italic) {
        this.text = text;
        this.color = color;
        this.background = background;
        this.bold = bold;
        this.underline = underline;
        this.italic = italic;
    }

    public String pColor(String color, String background) {
        Map<String, String> colors = new HashMap<>();
        colors.put("black", "\u001B[30m");
        colors.put("red", "\u001B[31m");
        colors.put("green", "\u001B[32m");
        colors.put("yellow", "\u001B[33m");
        colors.put("blue", "\u001B[34m");
        colors.put("magenta", "\u001B[35m");
        colors.put("cyan", "\u001B[36m");
        colors.put("white", "\u001B[37m");

        if (!colors.containsKey(color)) {
            System.out.println("Invalid color '" + color + "'");
            return "";
        }

        StringBuilder result = new StringBuilder(colors.get(color));

        if (background != null) {
            Map<String, String> bgs = new HashMap<>();
            bgs.put("black", "\u001B[40m");
            bgs.put("red", "\u001B[41m");
            bgs.put("green", "\u001B[42m");
            bgs.put("yellow", "\u001B[43m");
            bgs.put("blue", "\u001B[44m");
            bgs.put("magenta", "\u001B[45m");
            bgs.put("cyan", "\u001B[46m");
            bgs.put("white", "\u001B[47m");

            if (!bgs.containsKey(background)) {
                System.out.println("Invalid background color '" + background + "'");
                return "";
            }

            result.append(bgs.get(background));
        }

        return result.toString();
    }

    public void printText(String text) {
        StringBuilder code = new StringBuilder();
        if (color != null) {
            code.append(pColor(color, background));
        }
        if (bold) {
            code.append("\u001B[1m");
        }
        if (underline) {
            code.append("\u001B[4m");
        }
        if (italic) {
            code.append("\u001B[3m");
        }

        System.out.println(code.toString() + text + "\u001B[0m");
    }

    public static void main(String[] args) {
        PrintColor printCor = new PrintColor(null, "green", null, true, false, false);
        printCor.printText("Enjoy and have fun :D !!!");
    }
    
}
