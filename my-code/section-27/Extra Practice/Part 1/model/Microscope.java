package model;

public class Microscope extends LabEquipment {

    public static final int MIN_MAGNIFICATION = 1;

    private int magnification;

    public Microscope(LabEquipment source) {
        super(source);
    }

    public Microscope(String manufacturer, String model, int year, int magnification) {
        super(manufacturer, model, year);
        setMagnification(magnification);
    }

    public int getMagnification() {
        return magnification;
    }

    public void setMagnification(int magnification) {

        if (magnification < MIN_MAGNIFICATION) {
            throw new IllegalArgumentException(
                    "Magnification must be greater than or equal to the minimum magnification.");
        }
        this.magnification = magnification;
    }

    @Override
    public String performMaintenance() {
        return "Microscope maintenance: Clean the lenses and check the light source.";
    }

    @Override
    public LabEquipment clone() {
        return new Microscope(this.getManufacturer(), this.getModel(), this.getYear(), this.getMagnification());
    }
}
