package KI302.Dyhdalo.Lab3;

import java.io.IOException;

public class Tree extends Plant implements Harvestable {

    private int age;
    private String fruitType;
    private int fruitYield;

    public Tree(String stemName, int rootDepth, String leafColor, int leafCount, int heightCm, int health,
                int age, String fruitType, int fruitYield) throws IOException {
        
        super(stemName, rootDepth, leafColor, leafCount, heightCm, health);

        this.age = age;
        this.fruitType = fruitType;
        this.fruitYield = fruitYield;

        log.println("Tree created. Age: " + age + ", Fruit: " + fruitType);
    }

    @Override
    public void performSeasonalActivity() {
        log.println("The tree '" + getStem().getName() + "' is performing seasonal activity.");
        int leavesToDrop = getLeafCount() / 10;
        if (leavesToDrop == 0 && getLeafCount() > 0)
            leavesToDrop = 1;
        log.println(leavesToDrop + " leaves were dropped during seasonal activity.");
    }

    @Override
    public String harvest() {
        if (fruitYield > 0) {
            log.println("Harvesting " + fruitYield + " units of " + fruitType + " from " + getStem().getName());
            fruitYield = 0; 
            return fruitType;
        } else {
            log.println("No " + fruitType + " to harvest from " + getStem().getName());
            return "None";
        }
    }

    @Override
    public int getYield() {
        return fruitYield;
    }

    public void growOlder() {
        age++;
        grow(10);
        getRoot().growDeeper(5); 
        log.println("Tree '" + getStem().getName() + "' aged. New age: " + age);
        
        if (age > 5) {
            fruitYield += 20; 
            log.println("New fruit grown. Total yield: " + fruitYield);
        }
    }

    public int getAge() {
        return age;
    }

    @Override
    public void showDetails() {
        super.showDetails(); 
        log.println("Tree specific details -> Age: " + age +
                    ", Fruit: " + fruitType + " (Yield: " + fruitYield + ")");
    }
}