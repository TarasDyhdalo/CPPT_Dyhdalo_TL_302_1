package KI302.Dyhdalo.Lab6;

public class App {

    public static void main(String[] args) {

        BuildingContainer<Building>[] containers = new BuildingContainer[8];

        for (int i = 0; i < containers.length; i++) {
            containers[i] = new BuildingContainer<>(3);
        }

        ResidentialBuilding res1 = new ResidentialBuilding(
                "Житловий будинок №1", 45.0, 15, 2500.0, 120);
        ResidentialBuilding res2 = new ResidentialBuilding(
                "Житловий будинок №2", 60.0, 20, 3200.0, 180);

        OfficeBuilding off1 = new OfficeBuilding(
                "Бізнес-центр А", 80.0, 25, 5000.0, 200);
        OfficeBuilding off2 = new OfficeBuilding(
                "Офісна будівля B", 55.0, 18, 3500.0, 150);

        containers[0].add(res1);
        containers[0].add(off1);

        containers[1].add(res2);
        containers[1].add(off2);

        containers[2].add(res1);
        containers[2].add(res2);
        containers[2].add(off1);

        containers[3].add(off2);
        containers[4].add(res1);
        containers[5].add(off1);
        containers[6].add(res2);
        containers[7].add(off2);

        System.out.println("=== Вміст контейнера [2] ===");
        containers[2].printAll();

        System.out.println("\nКількість споруд: " + containers[2].size());
        System.out.println("Сумарна площа: " + containers[2].totalArea() + " м²");

        System.out.println("\nНайвища споруда:");
        System.out.println(containers[2].findMax());

        System.out.println("\nВидаляємо перший елемент...");
        Building removed = containers[2].remove(0);
        System.out.println("Видалено: " + removed);

        System.out.println("\nПісля видалення:");
        containers[2].printAll();
    }
}
