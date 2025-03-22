public class Main {

    public static void main(String[] args) {
        Person person = new Person("Rayan Slim", "Canadian", "01/01/1111", 5);
        person.setSeatNumber(10);

        printPerson(person);

        Person twin = new Person(person);
        twin.setName("Jad Slim");
        twin.setSeatNumber(3);

        printPerson(twin);
    }

    private static void printPerson(Person person) {
        System.out.println("Name: " + person.getName() + "\n" + "Nationality: " + person.getNationality() + "\n"
                + "Date of Birth: " + person.getDateOfBirth() + "\n" + "Seat Number: " + person.getSeatNumber() + "\n");
    }
}
