package KI302.Dyhdalo.Lab6;

import java.util.ArrayList;
import java.util.List;

public class BuildingContainer<T extends Building> {

    private List<T> items;
    private int capacity;

    public BuildingContainer(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>(capacity);
    }

    // Додати споруду
    public void add(T building) {
        if (items.size() >= capacity) {
            throw new IllegalStateException("Контейнер заповнений");
        }
        items.add(building);
    }

    // Видалити споруду за індексом
    public T remove(int index) {
        return items.remove(index);
    }

    // Кількість елементів
    public int size() {
        return items.size();
    }

    // Перевірка порожності
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Пошук максимальної споруди (найвищої)
    public T findMax() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Контейнер порожній");
        }

        T max = items.get(0);
        for (T b : items) {
            if (b.compareTo(max) > 0) {
                max = b;
            }
        }
        return max;
    }

    // Сумарна площа всіх споруд
    public double totalArea() {
        double sum = 0.0;
        for (T b : items) {
            sum += b.getAreaSqm();
        }
        return sum;
    }

    // Виведення всіх елементів
    public void printAll() {
        if (items.isEmpty()) {
            System.out.println("Контейнер порожній.");
            return;
        }
        for (T b : items) {
            System.out.println(" - " + b);
        }
    }
}
