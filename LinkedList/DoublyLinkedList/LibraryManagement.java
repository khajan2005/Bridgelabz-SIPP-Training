package LinkedList.DoublyLinkedList;

class Book {
    String title, author, genre;
    int bookID;
    boolean isAvailable;
    Book next, prev;

    public Book(int bookID, String title, String author, String genre, boolean isAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryManagement {
    Book head = null, tail = null;

    public void addBookAtBeginning(Book book) {
        if (head == null) {
            head = tail = book;
        } else {
            book.next = head;
            head.prev = book;
            head = book;
        }
    }

    public void addBookAtEnd(Book book) {
        if (tail == null) {
            head = tail = book;
        } else {
            tail.next = book;
            book.prev = tail;
            tail = book;
        }
    }

    public void addBookAtPosition(Book book, int position) {
        if (position <= 0 || head == null) {
            addBookAtBeginning(book);
            return;
        }

        Book current = head;
        int index = 0;
        while (index < position - 1 && current.next != null) {
            current = current.next;
            index++;
        }

        book.next = current.next;
        book.prev = current;
        if (current.next != null)
            current.next.prev = book;
        current.next = book;

        if (book.next == null)
            tail = book;
    }

    public void removeBook(int bookID) {
        Book current = head;
        while (current != null && current.bookID != bookID) {
            current = current.next;
        }

        if (current == null)
            return;

        if (current.prev != null)
            current.prev.next = current.next;
        else
            head = current.next;

        if (current.next != null)
            current.next.prev = current.prev;
        else
            tail = current.prev;
    }

    public void searchByTitle(String title) {
        Book current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                printBook(current);
            }
            current = current.next;
        }
    }

    public void searchByAuthor(String author) {
        Book current = head;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                printBook(current);
            }
            current = current.next;
        }
    }

    public void updateAvailability(int bookID, boolean newStatus) {
        Book current = head;
        while (current != null) {
            if (current.bookID == bookID) {
                current.isAvailable = newStatus;
                return;
            }
            current = current.next;
        }
    }

    public void displayForward() {
        Book current = head;
        while (current != null) {
            printBook(current);
            current = current.next;
        }
    }

    public void displayReverse() {
        Book current = tail;
        while (current != null) {
            printBook(current);
            current = current.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private void printBook(Book b) {
        System.out.println("Book ID: " + b.bookID + ", Title: " + b.title + ", Author: " + b.author +
                ", Genre: " + b.genre + ", Available: " + b.isAvailable);
    }

    public static void main(String[] args) {
        LibraryManagement lib = new LibraryManagement();

        lib.addBookAtEnd(new Book(101, "1984", "George Orwell", "Dystopian", true));
        lib.addBookAtBeginning(new Book(102, "The Hobbit", "J.R.R. Tolkien", "Fantasy", true));
        lib.addBookAtPosition(new Book(103, "Clean Code", "Robert C. Martin", "Programming", true), 1);

        System.out.println("All books (Forward):");
        lib.displayForward();

        System.out.println("\nAll books (Reverse):");
        lib.displayReverse();

        System.out.println("\nSearch by Author 'George Orwell':");
        lib.searchByAuthor("George Orwell");

        System.out.println("\nUpdating availability of Book ID 101 to false...");
        lib.updateAvailability(101, false);

        System.out.println("\nAfter update:");
        lib.displayForward();

        System.out.println("\nTotal books in library: " + lib.countBooks());

        System.out.println("\nRemoving Book ID 102...");
        lib.removeBook(102);
        lib.displayForward();
    }
}
