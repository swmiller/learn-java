import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create a new Person object
        Person person = new Person("John Doe", "American", "01/01/1990", new String[] { "123456789", "987654321" }, 1);

        // Print the name of the person
        printPersonDetails(person);
    }

    public static void printPersonDetails(Person person) {
        System.out.println("Name         : " + person.getName());
        System.out.println("Nationality  : " + person.getNationality());
        System.out.println("Date of Birth: " + person.getDateOfBirth());
        System.out.println("Passport     : " + Arrays.toString(person.getPassport()));
        System.out.println("Seat Number  : " + person.getSeatNumber());
    }
}