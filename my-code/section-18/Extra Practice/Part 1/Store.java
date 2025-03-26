import java.util.ArrayList;

public class Store {
    private ArrayList<Book> books;

    public Store() {
        books = new ArrayList<Book>();
    }

    public Book getBook(int index) {
        return new Book(books.get(index));
    }

    public void setBook(int index, Book book) {
        books.set(index, new Book(book));
    }

    public void addBook(Book book) {
        books.add(new Book(book));
    }

    public boolean contains(Book book) {
        return this.books.contains(book);
    }

    public void sellBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                books.remove(i);
                break;
            }
        }
    }
}
