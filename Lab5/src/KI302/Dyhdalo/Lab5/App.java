package KI302.Dyhdalo.Lab5;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        ExpressionCalculator calc = new ExpressionCalculator();
        ResultIO io = new ResultIO();
        List<ResultRecord> records = new ArrayList<>();

        System.out.println("Введіть x у радіанах. Порожній рядок — кінець.");
        System.out.print("> ");

        try (Scanner sc = new Scanner(System.in)) {

            while (true) {
                String line = sc.nextLine().trim();
                if (line.isEmpty())
                    break;

                String[] tokens = line.split("\\s+");
                for (String t : tokens) {
                    LocalDateTime ts = LocalDateTime.now();
                    try {
                        double x = Double.parseDouble(t);
                        double y = calc.compute(x);
                        records.add(new ResultRecord(ts, x, y, "OK", ""));
                        System.out.printf("x=%s -> y=%.10f%n", t, y);
                    } catch (NumberFormatException nfe) {
                        records.add(new ResultRecord(ts, Double.NaN, Double.NaN, "ERROR", "Невалідне число"));
                        System.err.printf("Помилка: '%s' не є числом%n", t);
                    } catch (CalculationException ce) {
                        records.add(new ResultRecord(ts, Double.NaN, Double.NaN, "ERROR",
                                ce.getMessage()));
                        System.err.printf("Помилка обчислення для x=%s: %s%n", t, ce.getMessage());
                    }
                }

                System.out.print("> ");
            }

            String textFile = "results_text.csv";
            String binFile = "results_bin.dat";

            io.writeText(textFile, records);
            io.writeBinary(binFile, records);

            System.out.println("Записано у " + textFile + " і " + binFile);

            System.out.println("\n=== Перевірка читання з текстового файлу ===");
            List<ResultRecord> fromText = io.readText(textFile);
            for (ResultRecord r : fromText) {
                System.out.println(r);
            }

            System.out.println("\n=== Перевірка читання з двійкового файлу ===");
            List<ResultRecord> fromBin = io.readBinary(binFile);
            for (ResultRecord r : fromBin) {
                System.out.println(r);
            }

        } catch (IOException ioe) {
            System.err.println("Помилка вводу/виводу: " + ioe.getMessage());
        }
    }
}
