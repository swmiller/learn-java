package model;

public abstract class LabEquipment {
    private String manufacturer;
    private String model;
    private int year;

    public static final int MIN_YEAR = 1950;

    // Field Constructor
    public LabEquipment(String manufacturer, String model, int year) {
        setManufacturer(manufacturer);
        setModel(model);
        setYear(year);
    }

    // Copy Constructor
    public LabEquipment(LabEquipment source) {
        if (source != null) {
            setManufacturer(source.manufacturer);
            setModel(source.model);
            setYear(source.year);
        } else {
            throw new IllegalArgumentException("Cannot copy from null LabEquipment");
        }
    }

    // Getters and Setters
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer.isEmpty()) {
            throw new IllegalArgumentException("Manufacturer cannot be null or empty");
        }

        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty");
        }

        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < MIN_YEAR) {
            throw new IllegalArgumentException("Year cannot be less than " + MIN_YEAR);
        }

        this.year = year;
    }

    public abstract String performMaintenance();

    public abstract LabEquipment clone(); // Abstract method for cloning
}