package KI302.Dyhdalo.Lab3;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Tree myTree = null;
            myTree = new Tree("Apple trunk", 60, "Green", 250, 300, 90,
                              5, "Apple", 40);
        System.out.println("Tree object created. Check 'PlantLog.txt' for details.");

        myTree.showDetails();
        myTree.water();
        myTree.giveSunlight();
        myTree.growOlder();
        myTree.performSeasonalActivity();

        String harvestedFruit = myTree.harvest();
        System.out.println("Harvested: " + harvestedFruit);
        System.out.println("Current yield after harvest: " + myTree.getYield());

        myTree.growOlder(); 
        System.out.println("Current yield after another year: " + myTree.getYield());

        System.out.println("Current health: " + myTree.getHealth());
        System.out.println("Current height: " + myTree.getHeight() + " cm");
        myTree.close();
    }
}
