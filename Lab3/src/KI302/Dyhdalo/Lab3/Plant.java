package KI302.Dyhdalo.Lab3;

import java.io.*;

public abstract class Plant {
    private Stem stem;
    private Root root;
    private Leaf leaf;
    private int leafCount;
    private int heightCm;
    private int health;
    protected PrintWriter log;
    public abstract void performSeasonalActivity();

    public Plant() throws IOException {
        this.stem = new Stem("Generic Stem");
        this.root = new Root(10);
        this.leaf = new Leaf("Green");
        this.leafCount = 5;
        this.heightCm = 30;
        this.health = 90;
        this.log = new PrintWriter(new BufferedWriter(new FileWriter("PlantLog.txt", false)), true);
        log.println("Default Plant (abstract) constructor used.");
    }

    public Plant(String stemName, int rootDepth, String leafColor, int leafCount, int heightCm, int health) throws IOException {
        this.stem = new Stem(stemName);
        this.root = new Root(rootDepth);
        this.leaf = new Leaf(leafColor);
        this.leafCount = leafCount;
        this.heightCm = heightCm;
        this.health = (health > 100) ? 100 : (health < 0 ? 0 : health);
        this.log = new PrintWriter(new BufferedWriter(new FileWriter("PlantLog.txt", false)), true);
        log.println("Parameterized Plant (abstract) constructor used.");
    }

    public Stem getStem() {
        return stem;
    }

    public Root getRoot() {
        return root;
    }

    public Leaf getLeaf() {
        return leaf;
    }

    public void showDetails() {
        log.println("Stem name: " + stem.getName() + ", Root depth: " + root.getDepth() + ", Leaf color: " + leaf.getColor());
    }

    public void grow(int cm) {
        if (cm > 0) {
            heightCm += cm;
            log.println("Plant grew by " + cm + " cm. New height: " + heightCm);
        }
    }

    public void water() {
        health += 5;
        if (health > 100) health = 100;
        log.println("Plant watered. Health: " + health);
    }

    public void giveSunlight() {
        heightCm += 1;
        log.println("Plant received sunlight. Height now: " + heightCm);
    }

    public void growLeaf() {
        leafCount++;
        log.println("New leaf grew. Total leaves: " + leafCount);
    }

    public void dropLeaf() {
        if (leafCount > 0) {
            leafCount--;
            log.println("Leaf dropped. Remaining leaves: " + leafCount);
        } else {
            log.println("No leaves left to drop.");
        }
    }

    public int getHealth() {
        return health;
    }

    public int getHeight() {
        return heightCm;
    }

    public int getLeafCount() {
        return leafCount;
    }

    public void damage(int amount) {
        if (amount > 0) {
            health -= amount;
            if (health < 0) health = 0;
            log.println("Plant damaged by " + amount + ". Health now: " + health);
        }
    }

    public void close() {
        if (log != null) {
            log.println("Plant resources closed.");
            log.close();
            log = null; 
        }
    }

    public class Leaf {
        private String color;

        public Leaf(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

    public class Root {
        private int depth;

        public Root(int depth) {
            this.depth = depth;
        }

        public int getDepth() {
            return depth;
        }

        public void growDeeper(int cm) {
            if (cm > 0) {
                depth += cm;
            }
        }
    }

    public class Stem {
        private String name;

        public Stem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}