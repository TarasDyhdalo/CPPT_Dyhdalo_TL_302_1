package KI302.Dyhdalo.Lab6;

public abstract class Building implements Comparable<Building> {

    protected String name;
    protected double heightMeters;
    protected int floors;
    protected double areaSqm;

    public Building(String name, double heightMeters, int floors, double areaSqm) {
        this.name = name;
        this.heightMeters = heightMeters;
        this.floors = floors;
        this.areaSqm = areaSqm;
    }

    public String getName() {
        return name;
    }

    public double getHeightMeters() {
        return heightMeters;
    }

    public int getFloors() {
        return floors;
    }

    public double getAreaSqm() {
        return areaSqm;
    }

    @Override
    public int compareTo(Building other) {
        return Double.compare(this.heightMeters, other.heightMeters);
    }

    @Override
    public String toString() {
        return String.format(
                "%s: floors=%d, height=%.2f m, area=%.2f m^2",
                name, floors, heightMeters, areaSqm
        );
    }
}
