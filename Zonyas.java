import java.time.*;
import java.time.format.*;
import java.util.*;
import java.time.temporal.ChronoUnit;


public class Zonyas {
    private Duration dia;
    private ZonedDateTime dayObj;

    public Zonyas(long dia) {
        this.dia = Duration.ofDays(dia);
        this.dayObj = ZonedDateTime.now(ZoneId.systemDefault()).plus(dia, ChronoUnit.DAYS);
    }

    public String ultimoDiaDoMes(int ano, int mes) {
        int ultimoDia = YearMonth.of(ano, mes).lengthOfMonth();
        LocalDate lastDay = LocalDate.of(ano, mes, ultimoDia);
        return lastDay.format(DateTimeFormatter.ofPattern("dd"));
    }

    public String[] weekDays() {
        ZonedDateTime day = this.dayObj;

        // Dia da semana
        String diaDaSemana = day.format(DateTimeFormatter.ofPattern("EEEE")).substring(0, 1).toUpperCase() + day.format(DateTimeFormatter.ofPattern("EEEE")).substring(1);
        // Dia do mês
        String diaDoMes = day.format(DateTimeFormatter.ofPattern("dd 'de' MMMM", new Locale("pt", "BR")));
        // Dia
        String dia = day.format(DateTimeFormatter.ofPattern("dd"));
        // Mês extenso
        String mesExtenso = day.format(DateTimeFormatter.ofPattern("MMMM", new Locale("pt", "BR")));
        // Mês
        String mes = day.format(DateTimeFormatter.ofPattern("MM"));
        // Ano
        String ano = day.format(DateTimeFormatter.ofPattern("yyyy"));
        // Hora
        String hora = day.format(DateTimeFormatter.ofPattern("HH"));
        // Minuto
        String minuto = day.format(DateTimeFormatter.ofPattern("mm"));

        // Último dia do mês
        String ultimoDia = ultimoDiaDoMes(Integer.parseInt(ano), Integer.parseInt(mes));

        return new String[]{dia, diaDaSemana, diaDoMes, ultimoDia, mes, mesExtenso, ano, hora, minuto};
    }

    public static void main(String[] args) {
        Zonyas zonyas = new Zonyas(0);
        String[] weekDays = zonyas.weekDays();
        for (String dayInfo : weekDays) {
            System.out.println(dayInfo);
        }
    }
}
