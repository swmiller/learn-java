public class Airline {

    Person[] people; // array that stores Person objects...

    public Airline() {
        this.people = new Person[11];
    }

    public Person getPerson(int index) {
        return new Person(people[index]);
    }

    /**
     * Setter name: setPerson
     * 
     * @param person (Person)
     * 
     *               Inside the setter:
     * 
     *               1. Index the array, and set that element equal to the Person
     *               object.
     */
    public void setPerson(Person person) {
        int seatNumber = person.getSeatNumber();

        if (seatNumber < 1 || seatNumber > 11)
            throw new IllegalArgumentException("Seat number must be between 1 and 10.");

        people[seatNumber - 1] = new Person(person);
    }
}
