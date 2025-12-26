package KI302.Dyhdalo.Lab4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // щоб крапка була десятковим роздільником

        ExpressionCalculator calc = new ExpressionCalculator();

        System.out.println("Введіть x у радіанах (через пробіл або кілька рядків).");
        System.out.println("Порожній рядок — завершити. Результати підуть у файл results.txt");
        System.out.print("> ");

        try (Scanner sc = new Scanner(System.in);
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("results.txt", false)))) {

            out.println("timestamp,x,y,status,message");

            while (true) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) break;

                String[] tokens = line.split("\\s+");
                for (String t : tokens) {
                    LocalDateTime ts = LocalDateTime.now();
                    try {
                        double x = Double.parseDouble(t);
                        double y = calc.compute(x);
                        out.printf("%s,%.15f,%.15f,OK,%s%n", ts, x, y, "");
                        System.out.printf("x=%s  ->  y=%.10f%n", t, y);
                    } catch (NumberFormatException nfe) {
                        out.printf("%s,%s,%s,ERROR,%s%n", ts, t, "", "Невалідне число");
                        System.err.printf("Помилка: '%s' не є числом%n", t);
                    } catch (CalculationException ce) {
                        out.printf("%s,%s,%s,ERROR,%s%n", ts, t, "", ce.getMessage().replace(',', ';'));
                        System.err.printf("Помилка обчислення для x=%s: %s%n", t, ce.getMessage());
                    }
                }
                System.out.print("> ");
            }

            System.out.println("Готово. Перевірте файл results.txt");

        } catch (IOException ioe) {
            System.err.println("Не вдалося відкрити файл results.txt для запису: " + ioe.getMessage());
        }
    }
}
