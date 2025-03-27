package model;

import java.util.ArrayList;

public class CarDealership {
    private ArrayList<Car> cars;

    public CarDealership() {
        this.cars = new ArrayList<>();
    }

    public Car getCar(int index) {
        if (index < 0 || index >= cars.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return new Car(cars.get(index)); // Assuming Car has a copy constructor
    }

    public void setCar(Car car, int index) {
        if (index < 0 || index >= cars.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        cars.set(index, new Car(car)); // Assuming Car has a copy constructor
    }

    public void addCar(Car car) {
        cars.add(new Car(car)); // Assuming Car has a copy constructor
    }
}