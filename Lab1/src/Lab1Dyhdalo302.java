import java.io.*;
import java.util.*;
/**
 * Клас Lab1Dyhdalo302 реалізує приклад програми до лабораторної роботи №1
 * @author Taras
 * @version 1.0
 * @since version 1.0
 */

public class Lab1Dyhdalo302 {
    /**
	 * Статичний метод main є точкою входу в програму
	 * @param args аргументи командного рядка
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
      public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введiть розмiр матрицi: ");
        int nRows = in.nextInt();
        in.nextLine();
        System.out.print("Введiть символ-заповнювач: ");
        String filler = in.nextLine();
        if (filler.length() != 1) {
            System.out.println("Помилка: потрiбно ввести один символ.");
            return;
        }
        char c = filler.charAt(0);

        char[][] jagged = new char[nRows][];
        for (int i = 0; i < nRows; i++) {
            jagged[i] = new char[nRows - i];
            for (int j = 0; j < jagged[i].length; j++) {
                jagged[i][j] = c;
                 if (j == 0)
                jagged[i][j] = '%'; 
            }
        }

        PrintWriter fout = new PrintWriter("Output.txt");

        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
                fout.print(jagged[i][j] + " ");
            }
            System.out.println();
            fout.println();
        }

        in.close();
        fout.close();
        System.out.println("Результат збережено у Output.txt");
    }
}