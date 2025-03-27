package model;

import enumeration.BodyType;

public class Car {
    private String make;
    private String model;
    private BodyType bodyType;
    private int productionYear;
    private double price;

    public static final int MIN_PRODUCTION_YEAR = 1900;
    public static final double MIN_Price = 0;
    public static final double MAX_Price = 200_000;

    // All fields constructor
    public Car(String make, String model, BodyType bodyType, int productionYear, double price) {
        setMake(make);
        setModel(model);
        setBodyType(bodyType);
        setProductionYear(productionYear);
        setPrice(price);
    }

    // Copy constructor
    public Car(Car source) {
        setMake(source.getMake());
        setModel(source.getModel());
        setBodyType(source.getBodyType());
        setProductionYear(source.getProductionYear());
        setPrice(source.getPrice());
    }

    // Getters and setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        if (make == null || make.isBlank()) {
            throw new IllegalArgumentException("Make cannot be null or blank.");
        }

        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model cannot be null or blank.");
        }

        this.model = model;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        if (bodyType == null) {
            throw new IllegalArgumentException("Body type cannot be null.");
        }

        this.bodyType = bodyType;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        if (productionYear < MIN_PRODUCTION_YEAR) {
            throw new IllegalArgumentException("Production year cannot be less than " + MIN_PRODUCTION_YEAR + ".");
        }
        this.productionYear = productionYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= MIN_Price || price > MAX_Price) {
            throw new IllegalArgumentException("Price must be greater than 0 and less than 200,000.");
        }

        this.price = price;
    }
}