package KI302.Dyhdalo.Lab2;
import java.io.*;

/**
 * Клас {@code PlantApp} демонструє роботу класу {@link Plant}.
 * Створює рослину, виконує різні дії та виводить стан у консоль і лог-файл
 * @author Dyhdalo
 * @version 1.0
 */

public class PlantApp {
    /**
     * Головний метод для запуску програми
     * @param args аргументи командного рядка
     * @throws IOException якщо виникає помилка роботи з лог-файлом
     */
    public static void main(String[] args) throws IOException {

        Plant plant = new Plant("Stem", 5, "Green", 3, 15, 80);
        plant.showDetails();
        plant.grow(5);
        plant.water();
        plant.giveSunlight();
        plant.growLeaf();
        plant.dropLeaf();
        plant.damage(20);

        System.out.println("Plant status: height=" + plant.getHeight() + " cm, leaves=" + plant.getLeafCount() + ", health=" + plant.getHealth());

        plant.close();
    }
}
