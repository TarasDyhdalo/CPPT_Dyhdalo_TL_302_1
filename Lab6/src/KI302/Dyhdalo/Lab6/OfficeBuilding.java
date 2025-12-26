package KI302.Dyhdalo.Lab6;

public class OfficeBuilding extends Building {

    private int offices;

    public OfficeBuilding(String name,
                          double heightMeters,
                          int floors,
                          double areaSqm,
                          int offices) {
        super(name, heightMeters, floors, areaSqm);
        this.offices = offices;
    }

    public int getOffices() {
        return offices;
    }

    @Override
    public String toString() {
        return super.toString() + ", offices=" + offices;
    }
}
