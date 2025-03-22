public class Main {

    public static void main(String[] args) {
        Person person = new Person("Rayan Slim", "Canadian", "01/01/1111",
                new String[] { "Rayan Slim", "Canadian", "01/01/1111" }, 5);

        // person.name = "Rayan Slim";
        // person.nationality = "Canadian";
        // person.dateOfBirth = "01/01/1111";
        // person.passport = new String[]{person.name, person.nationality,
        // person.dateOfBirth};
        // person.seatNumber = 5;

        // System.out.println(person.name);
        // System.out.println(person.nationality);
        // System.out.println(person.dateOfBirth);
        // System.out.println(Arrays.toString(person.passport));
        // System.out.println(person.seatNumber);

        System.out.println("Name: " + person.getName() + "\n" + "Nationality: " + person.getNationality() + "\n"
                + "Date of Birth: " + person.getDateOfBirth() + "\n" + "Seat Number: " + person.getSeatNumber() + "\n");
    }
}
