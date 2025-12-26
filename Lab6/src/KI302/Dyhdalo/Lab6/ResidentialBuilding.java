package KI302.Dyhdalo.Lab6;

public class ResidentialBuilding extends Building {

    private int apartments;

    public ResidentialBuilding(String name,
                               double heightMeters,
                               int floors,
                               double areaSqm,
                               int apartments) {
        super(name, heightMeters, floors, areaSqm);
        this.apartments = apartments;
    }

    public int getApartments() {
        return apartments;
    }

    @Override
    public String toString() {
        return super.toString() + ", apartments=" + apartments;
    }
}
