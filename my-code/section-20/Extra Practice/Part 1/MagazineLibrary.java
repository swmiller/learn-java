import java.util.ArrayList;

public class MagazineLibrary {
    private ArrayList<Magazine> magazines;

    public MagazineLibrary() {
        magazines = new ArrayList<>();
    }

    public void setMagazine(Magazine magazine, int index) {
        if (index >= 0 && index < magazines.size()) {
            magazines.set(index, new Magazine(magazine));
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    public Magazine getMagazine(int index) {
        if (index >= 0 && index < magazines.size()) {
            return new Magazine(magazines.get(index));
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    public void addMagazine(Magazine magazine) {
        magazines.add(new Magazine(magazine));
    }
}
