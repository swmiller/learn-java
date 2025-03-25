public class ContactManager {
    private Contact[] contacts; // array of Contact objects

    public ContactManager(Contact[] sourceContacts) {
        contacts = new Contact[sourceContacts.length];

        for (int i = 0; i < sourceContacts.length; i++) {
            contacts[i] = new Contact(sourceContacts[i]);
        }
    }

    public Contact getContact(int index) {
        return new Contact(contacts[index]);
    }

    public void setContact(Contact contact, int index) {
        this.contacts[index] = new Contact(contact);
    }

    public int getContactCount() {
        return contacts.length;
    }
}
