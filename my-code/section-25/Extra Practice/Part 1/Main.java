import java.util.Scanner;

import enumeration.BodyType;
import model.Car;
import model.CarDealership;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String make = promptForMake(scanner);
        String model = promptForModel(scanner);
        BodyType bodyType = promptForBodyType(scanner);
        int year = promptForYear(scanner);
        double price = promptForPrice(scanner);

        Car newCar = new Car(make, model, bodyType, year, price);

        CarDealership dealership = new CarDealership();
        dealership.addCar(newCar);

        System.out.println("Car added to the dealership: " + newCar.getMake() + " " + newCar.getModel());
    }

    private static int promptForYear(Scanner scanner) {
        System.out.print("Enter production year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (invalidYear(year)) {
            throw new IllegalArgumentException("Invalid production year.");
        }

        return year;
    }

    private static BodyType promptForBodyType(Scanner scanner) {
        System.out.println("Body types:");
        for (BodyType bodyType : BodyType.values()) {
            System.out.println(bodyType);
        }

        System.out.print("Enter body type: ");
        String bodyTypeString = scanner.nextLine().toUpperCase();

        try {
            return BodyType.valueOf(bodyTypeString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid body type.");
        }
    }

    private static double promptForPrice(Scanner scanner) {
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        return price;
    }

    private static String promptForModel(Scanner scanner) {
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        if (isNullOrBlank(model)) {
            throw new IllegalArgumentException("Model cannot be null or blank.");
        }

        return model;
    }

    private static String promptForMake(Scanner scanner) {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        if (isNullOrBlank(make)) {
            throw new IllegalArgumentException("Make cannot be null or blank.");
        }

        return make;
    }

    private static boolean isNullOrBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean invalidYear(int year) {
        return year < Car.MIN_PRODUCTION_YEAR;
    }
}